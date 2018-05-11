package com.test.controller;

import com.test.model.request.ProxyRequest;
import com.test.model.request.SelectRandomProxyRequest;
import com.test.model.request.SetBankProxyRequest;
import com.test.model.response.AllProxyResponse;
import com.test.model.response.ProxyResponse;
import com.test.model.response.SelectRandomProxyResponse;
import com.test.service.proxy.ProxyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    private final ProxyService proxyService;
    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @RequestMapping(value = "/proxy/save", method = RequestMethod.POST)
    public ProxyResponse bankSave(@RequestBody ProxyRequest proxyRequest){
        return proxyService.saveProxy(proxyRequest);
    }

    @RequestMapping(value = "/proxy/get-all", method = RequestMethod.POST)
    public AllProxyResponse getAllProxies(){
        AllProxyResponse allProxyResponse=new AllProxyResponse();
        allProxyResponse.setProxyList(proxyService.getAllProxies());
        return allProxyResponse;
    }

    @RequestMapping(value = "/proxy/set-bank", method = RequestMethod.POST)
    public ProxyResponse setBankToProxy(@RequestBody SetBankProxyRequest setBankProxyRequest){
        return proxyService.setBankToProxy(setBankProxyRequest);
    }

    @RequestMapping(value = "/proxy/set-black-list", method = RequestMethod.POST)
    public ProxyResponse setBlackList(@RequestBody SetBankProxyRequest setBankProxyRequest){
        return proxyService.setBlackList(setBankProxyRequest);
    }

    @RequestMapping(value = "/proxy/get-one-proxy", method = RequestMethod.POST)
    public SelectRandomProxyResponse selectRandomProxyResponse (@RequestBody SelectRandomProxyRequest request){
        return proxyService.selectProxy(request);
    }

    @RequestMapping(value = "/proxy/delete-proxy-in-black-list", method = RequestMethod.POST)
    public ProxyResponse deleteBlackList(@RequestBody SetBankProxyRequest setBankProxyRequest){
        return proxyService.deleteProxyInBlacklist(setBankProxyRequest);
    }
}
