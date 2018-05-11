package com.test.service.proxy;

import com.test.domain.Bank;
import com.test.domain.Proxy;
import com.test.model.request.ProxyRequest;
import com.test.model.request.SelectRandomProxyRequest;
import com.test.model.request.SetBankProxyRequest;
import com.test.model.response.ProxyResponse;
import com.test.model.response.SelectRandomProxyResponse;

import java.util.List;

public interface ProxyService {
    ProxyResponse saveProxy(ProxyRequest proxyRequest);
    List<Proxy> getAllProxies();
    ProxyResponse setBankToProxy(SetBankProxyRequest setBankProxyRequest);
    ProxyResponse setBlackList(SetBankProxyRequest setBankProxyRequest);
    SelectRandomProxyResponse selectProxy(SelectRandomProxyRequest request);
    ProxyResponse deleteProxyInBlacklist(SetBankProxyRequest setBankProxyRequest);
}
