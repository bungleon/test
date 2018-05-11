package com.test.service.proxy;

import com.test.domain.Bank;
import com.test.domain.Proxy;
import com.test.domain.ProxyBlackList;
import com.test.model.request.ProxyRequest;
import com.test.model.request.SelectRandomProxyRequest;
import com.test.model.request.SetBankProxyRequest;
import com.test.model.response.ProxyResponse;
import com.test.model.response.SelectRandomProxyResponse;
import com.test.repository.BankRepository;
import com.test.repository.ProxyBlackListRepository;
import com.test.repository.ProxyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProxyServiceImpl implements ProxyService {
    private final ProxyRepository proxyRepository;
    private final BankRepository bankRepository;
    private final ProxyBlackListRepository proxyBlackListRepository;

    public ProxyServiceImpl(ProxyRepository proxyRepository, BankRepository bankRepository, ProxyBlackListRepository proxyBlackListRepository) {
        this.proxyRepository = proxyRepository;
        this.bankRepository = bankRepository;
        this.proxyBlackListRepository = proxyBlackListRepository;
    }

    @Override
    public ProxyResponse saveProxy(ProxyRequest proxyRequest) {
        Proxy proxy = proxyRepository.findByProxyList(proxyRequest.getProxyList());
        if (proxy == null) {
            proxy = new Proxy();
        }
        proxy.setProxyList(proxyRequest.getProxyList());
        proxy.setName(proxyRequest.getName());
        proxyRepository.save(proxy);
        return new ProxyResponse();
    }

    @Override
    public List<Proxy> getAllProxies() {
        return proxyRepository.findAll();
    }

    @Override
    public ProxyResponse setBankToProxy(SetBankProxyRequest setBankProxyRequest) {
        Bank bank = bankRepository.findBySwiftCode(setBankProxyRequest.getSwiftCode());
        if (bank == null) {
            throw new IllegalArgumentException("Banka yok lan");
        }
        Proxy proxy = proxyRepository.findByProxyList(setBankProxyRequest.getProxyList());
        if (proxy == null) {
            throw new IllegalArgumentException("proxy yok sığır");
        }

        proxy.setBank(bank);
        proxyRepository.save(proxy);
        return new ProxyResponse();
    }

    @Override
    public ProxyResponse setBlackList(SetBankProxyRequest setBankProxyRequest) {
        Bank bank = bankRepository.findBySwiftCode(setBankProxyRequest.getSwiftCode());
        if (bank == null) {
            throw new IllegalArgumentException("Banka yok lan");
        }

        Proxy proxy = proxyRepository.findByProxyList(setBankProxyRequest.getProxyList());
        if (proxy == null) {
            throw new IllegalArgumentException("proxy yok sığır");
        }
        ProxyBlackList proxyBlackList = new ProxyBlackList();
        proxyBlackList.setBank(bank);
        proxyBlackList.setProxy(proxy);
        ProxyBlackList proxyBlackList1 = proxyBlackListRepository.save(proxyBlackList);
        if (proxyBlackList1 != null) {
            return new ProxyResponse();
        }
        throw new IllegalArgumentException("proxy yok sığır");
    }

    @Override
    public SelectRandomProxyResponse selectProxy(SelectRandomProxyRequest request) {
        Bank bank = bankRepository.findBySwiftCode(request.getSwiftCode());
        List<Proxy> proxy = proxyRepository.findAll();

        List<Proxy> selectableProxy = proxy.stream()
                .filter(x -> !x.getBlackList().stream().anyMatch(y -> y.getBank().equals(bank) && !y.isDeleted()))
                .collect(Collectors.toList());
        // TODO burayı düşüncez biraz
        if (selectableProxy.size() != 0) {
            SelectRandomProxyResponse response = new SelectRandomProxyResponse();
            Random random = new Random();
            response.setProxy(selectableProxy.get(random.nextInt(selectableProxy.size())).getProxyList());
            return response;
        }
        throw new IllegalArgumentException("Proxy yok beya");
    }

    @Override
    public ProxyResponse deleteProxyInBlacklist(SetBankProxyRequest request) {
        Bank bank = bankRepository.findBySwiftCode(request.getSwiftCode());
        if (bank == null) {
            throw new IllegalArgumentException("Banka yok lan");
        }
        Proxy proxy = proxyRepository.findByProxyList(request.getProxyList());
        if (proxy == null) {
            throw new IllegalArgumentException("proxy yok sığır");
        }
        ProxyBlackList blackList = proxyBlackListRepository.findByProxyAndBank(proxy, bank);
        blackList.setDeleted(true);
        ProxyBlackList ret=proxyBlackListRepository.save(blackList);
        if(ret!=null){
            return new ProxyResponse();
        }
        throw new IllegalArgumentException("Kaydedemedik beya");
    }
}
