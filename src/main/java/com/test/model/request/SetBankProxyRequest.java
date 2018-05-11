package com.test.model.request;

public class SetBankProxyRequest {
    private String proxyList;
    private String swiftCode;

    public String getProxyList() {
        return proxyList;
    }

    public void setProxyList(String proxyList) {
        this.proxyList = proxyList;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
