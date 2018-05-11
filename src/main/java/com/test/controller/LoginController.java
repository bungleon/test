package com.test.controller;

import com.test.domain.User;
import com.test.driver.FirefoxDriver;
import com.test.model.request.Login;
import com.test.service.login.LoginService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, Login login,HttpSession session){
        System.out.print(login.toString());
         User user=new User();
         try{
             user=loginService.controlUser(login);
             if(user==null){
                 model.addAttribute("userName2","Unknown user name or password");
                 return "login";
             }
             else{
                 session.setAttribute("userId",user.getId());
                 return "redirect:/test";
             }
         }
         catch (Exception e){
             model.addAttribute("userName2","An exception occurs");
             return "login";
         }
    }
    @RequestMapping(value = "/youtube", method = RequestMethod.POST)
    public String loginYoutubeOnGoogle(Model model, Login login,HttpSession session){
        System.out.print(login.toString());
        if(login.getUserName().equals("erman@bumin.io")&& login.getPassword().equals("72745275"))
        {
            return "test";
        }
        else{
            FirefoxDriver firefoxDriver =new FirefoxDriver();
            WebDriver driver= firefoxDriver.newDriver(session);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get("https://www.google.com.tr/");
            driver.findElement(By.id("lst-ib")).click();
            driver.findElement(By.id("lst-ib")).sendKeys(login.getUserName2(), Keys.ENTER);
            driver.findElement(By.id("uid_1")).click();
            return "login";
        }
    }
}
