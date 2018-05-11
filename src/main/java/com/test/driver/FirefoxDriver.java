package com.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.servlet.http.HttpSession;

public class FirefoxDriver {
    public FirefoxDriver() {
    }

    public WebDriver newDriver(HttpSession session) {
        WebDriver driver;

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("app.update.auto", false);
        profile.setPreference("app.update.enabled", false);
        profile.setPreference("media.peerconnection.enabled", false);
        profile.setPreference("media.peerconnection.video.enabled", false);
        capabilities.setCapability(org.openqa.selenium.firefox.FirefoxDriver.PROFILE, profile);


        driver = new org.openqa.selenium.firefox.FirefoxDriver(capabilities);

        session.setAttribute("driver", driver);
        return driver;
    }
}
