package com.test.model.response;

import com.test.domain.Proxy;

import java.util.List;

public class AllProxyResponse {
    List<Proxy> proxyList;

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public void setProxyList(List<Proxy> proxyList) {
        this.proxyList = proxyList;
    }
}
