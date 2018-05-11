package com.test.model.request;

public class AliModel {
    private String deviceOsVersion;
    private String appVersion;
    private String sifreNetIndex;
    private String parola;

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSifreNetIndex() {
        return sifreNetIndex;
    }

    public void setSifreNetIndex(String sifreNetIndex) {
        this.sifreNetIndex = sifreNetIndex;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "AliModel{" +
                "deviceOsVersion='" + deviceOsVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", sifreNetIndex='" + sifreNetIndex + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
