package com.test.controller.selenium;

import com.test.driver.FirefoxDriver;
import com.test.model.request.EnBankRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

public abstract class Selenium {
    private WebDriver newDriver(HttpSession session){
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver.newDriver(session);
    }
    private WebDriver getDriverInstance(HttpSession session) {
        if (session.getAttribute("driver") != null) {
            return (WebDriver) session.getAttribute("driver");
        }
        return newDriver(session);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String enbankNormalTransferStart(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        WebDriver driver=newDriver(session);
        session.setAttribute("driver", driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://modern.enbank.net/ibnew/login/loginPage.action?ibReq=WEB");
        driver.findElement(By.id("localeLink")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("baskanbey");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("London123?");
        try{

        }
        catch (Exception e){

        }
        return driver.toString();
    }
    @RequestMapping(value = "/captcha", method = RequestMethod.POST)
    public String captcha(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        WebDriver driver=getDriverInstance(session);
        if(driver==null){
            return "driver=null";
        }
        driver.findElement(By.className("button")).click();
        return "ok";
    }

    @RequestMapping(value = "/EnterNextPage", method = RequestMethod.POST)
    public String enbankNormalTransferEnterPage(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        WebDriver driver=getDriverInstance(session);
        if(driver==null){
            return "driver=null";
        }
        driver.findElement(By.className("button")).click();
        return "ok";
    }
}
