package com.test.controller;

import com.test.driver.FirefoxDriver;
import com.test.model.request.EnBankRequest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SeleniumController {

    @RequestMapping(value = "/havale", method = RequestMethod.POST)
    public String havale(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://modern.enbank.net/ibnew/login/loginPage.action?ibReq=WEB");
        driver.findElement(By.id("localeLink")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("baskanbey");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("London123?");
        try {
            // Captcha image id
            //driver.findElement(By.id("captchaImage")).click();
            if (driver.findElement(By.id("captcha")).isEnabled()) {
                driver.findElement(By.id("captcha")).click();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.className("button")).click();
        try {
            if (driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).getText();
            }
        } catch (Exception e) {
        }

        //enter transfer page
        driver.findElement(By.id("transferPayment")).click();
        //enter normal transfer page
        driver.findElement(By.id("normalTransfer")).click();
        // Wait for combo to click
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("sourceSavingContainerInfo"), "Withdrawable Balance:"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sourceSavingTrigger")));
        js.executeScript("document.getElementById('sourceSavingTrigger').click();");
        // Wait for account list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/ul//li")));
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("/html/body/div[4]/ul//li")).getText());
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("1", Keys.ENTER);
        driver.findElement(By.id("destinationAccount")).click();
        driver.findElement(By.id("destinationAccount")).sendKeys("148-800-6054735-1");
        //driver.findElement(By.id("destinationAccount")).sendKeys("148-800-6052844-1 ");
        driver.findElement(By.id("sourceComment")).click();
        driver.findElement(By.id("sourceComment")).sendKeys("first command");
        driver.findElement(By.id("destinationComment")).click();
        driver.findElement(By.id("destinationComment")).sendKeys("second command");
        driver.findElement(By.xpath("//*[@id='newNormal']/div[4]/input[1]")).click();
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='content-body']/dl/dd/ul/li")).getText();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.id("secondPassword")).click();
        driver.findElement(By.id("secondPassword")).sendKeys("London123?");
        driver.findElement(By.id("perform")).click();
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='content-body']/dl/dd/ul/li")).getText();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if (driver.findElement(By.xpath("//*[@id='messages']/div")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='messages']/div")).getText();
            }
        } catch (Exception e) {
        }
        return "Olmadı";
    }

    // Less than 5.000$
    @RequestMapping(value = "/interbank", method = RequestMethod.POST)
    public String normalinterbank(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.get("https://modern.enbank.net/ibnew/login/loginPage.action?ibReq=WEB");
        driver.findElement(By.id("localeLink")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("baskanbey");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("London123?");
        try {
            // Captcha image id
            //driver.findElement(By.id("captchaImage")).click();
            if (driver.findElement(By.id("captcha")).isEnabled()) {
                driver.findElement(By.id("captcha")).click();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.className("button")).click();
        try {
            if (driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).getText();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.id("transferPayment")).click();
        driver.findElement(By.id("normalAchTransfer")).click();
        // Wait for absurt combo to click
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("sourceSavingContainerInfo"), "Withdrawable Balance:"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sourceSavingTrigger")));
        js.executeScript("document.getElementById('sourceSavingTrigger').click();");
        // Wait for account list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//div[contains(text(), 'Personal Accounts')]")));
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("//html//ul/li//div[contains(text(), 'Personal Accounts')]/following::div")).getText());
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("1", Keys.ENTER);
        driver.findElement(By.id("destinationIbanNumber")).click();
        driver.findElement(By.id("destinationIbanNumber")).clear();
        driver.findElement(By.id("destinationIbanNumber")).sendKeys("IR200560080877702662178001");
        driver.findElement(By.id("owner")).clear();
        driver.findElement(By.id("owner")).sendKeys("Osman Abi");
        // Deposit ID must be digit
        driver.findElement(By.id("factorNumber")).clear();
        driver.findElement(By.id("factorNumber")).sendKeys("123456");
        driver.findElement(By.id("remark")).clear();
        driver.findElement(By.id("remark")).sendKeys("Note");
        // Enter another page
        driver.findElement(By.xpath("//*[@id='content-body']/div[2]/form/div[4]/input[1]")).click();
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.id("clientSideHint")).getText();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.id("secondPassword")).click();
        driver.findElement(By.id("secondPassword")).sendKeys("London123?");
        // Final click submit button
        driver.findElement(By.id("perform")).click();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("errorTitle"), "Error"));
        } catch (Exception e) {

        }
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='content-body']/dl/dd/ul//li")).getText();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            if (driver.findElement(By.xpath("//*[@id='messages']/div")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='messages']/div")).getText();
            }
        } catch (Exception e) {
        }
        return "Olmadı";
    }

    // Greater than 5.000 $
    @RequestMapping(value = "/interbankeft", method = RequestMethod.POST)
    public String interbank(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://modern.enbank.net/ibnew/login/loginPage.action?ibReq=WEB");
        driver.findElement(By.id("localeLink")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("baskanbey");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("London123?");
        try {
            // Captcha image id
            //driver.findElement(By.id("captchaImage")).click();
            if (driver.findElement(By.id("captcha")).isEnabled()) {
                driver.findElement(By.id("captcha")).click();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.className("button")).click();
        try {
            if (driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='errorDiv']/dl/dd/ul/li")).getText();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.id("transferPayment")).click();
        driver.findElement(By.id("rtgsTransfer")).click();
        // Wait for absurt combo to click
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("sourceAccountContainerInfo"), "Withdrawable Balance:"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sourceAccountTrigger")));
        js.executeScript("document.getElementById('sourceAccountTrigger').click();");
        // Wait for account list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//div[contains(text(), 'Personal Accounts')]")));
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("//html//ul/li//div[contains(text(), 'Personal Accounts')]/following::div")).getText());
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("1", Keys.ENTER);
        driver.findElement(By.id("destinationIban")).click();
        driver.findElement(By.id("destinationIban")).clear();
        driver.findElement(By.id("destinationIban")).sendKeys("IR20056008087770266217801");
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Osman");
        driver.findElement(By.id("family")).click();
        driver.findElement(By.id("family")).sendKeys("Osman");
        driver.findElement(By.id("tel")).click();
        driver.findElement(By.id("tel")).sendKeys("021 123456789");
        // DepositId must be digit
        driver.findElement(By.id("factorNumber")).click();
        driver.findElement(By.id("factorNumber")).sendKeys("123456");
        driver.findElement(By.id("comment")).click();
        driver.findElement(By.id("comment")).sendKeys("note");
        // Enter another page
        driver.findElement(By.id("perform")).click();
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.id("clientSideHint")).getText();
            }
        } catch (Exception e) {
        }
        driver.findElement(By.id("secondPassword")).click();
        driver.findElement(By.id("secondPassword")).sendKeys("London123?");
        driver.findElement(By.id("perform")).click();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("errorTitle"), "Error"));
        } catch (Exception e) {

        }
        try {
            if (driver.findElement(By.id("errorTitle")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='content-body']/dl/dd/ul//li")).getText();
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.xpath("//*[@id='messages']/div")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='messages']/div")).getText();
            }
        } catch (Exception e) {
        }
        return "Olmadı";
    }


    @RequestMapping(value = "/ToOtherReposit", method = RequestMethod.POST)
    public String pasargadBankToOtherReposit(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("https://iben.bpi.ir/");
        js.executeScript("document.getElementById('StatemAgreementent').click();");
        driver.findElement(By.id("username_txtContent")).click();
        driver.findElement(By.id("username_txtContent")).sendKeys("baskanbey");
        js.executeScript("$('#password_placeHolderItem').click();");
        js.executeScript("$('#password_txtContent').val('" + "London123?" + "');");
        // Captcha image wrapper id
        //driver.findElement(By.id("captchaImg")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).sendKeys("CPTCH");
        driver.findElement(By.id("btnLogin")).click();
        try {
            if (driver.findElement(By.id("lblMessage")).isEnabled()) {
                return driver.findElement(By.id("lblMessage")).getText();
            }
        } catch (Exception e) {
        }
        js.executeScript("RedirectToPage(1039); ");
        driver.findElement(By.id("ctl00_activePage_uDMSourceDeposit_imgBtnShowHideCardDepositBookRecordListView")).click();
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody")).getText());
        // Select first account
        driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody/tr[2]/td/a")).click();
        // Select none
        // driver.findElement(By.id("ctl00_activePage_uDMSourceDeposit_imgBtnShowHideCardDepositBookRecordListView")).click();
        driver.findElement(By.id("txtValue1inpDestDeposit")).click();
        //  driver.findElement(By.id("txtValue1inpDestDeposit")).sendKeys("224");
        driver.findElement(By.id("txtValue2inpDestDeposit")).click();
        //   driver.findElement(By.id("txtValue2inpDestDeposit")).sendKeys("8000");
        driver.findElement(By.id("txtValue3inpDestDeposit")).click();
        //    driver.findElement(By.id("txtValue3inpDestDeposit")).sendKeys("13310535");
        //driver.findElement(By.id("txtValue4inpDestDeposit")).click();
        driver.findElement(By.id("txtValue4inpDestDeposit")).sendKeys("1", Keys.ENTER);
        // Senders account note
        //
        driver.findElement(By.id("ctl00_activePage_txtDescription_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDescription_txtContent")).sendKeys("1");

        // When bill numbers didn't enter correctly, System has giveen an error message.
        // Bill number
        //driver.findElement(By.id("ctl00_activePage_txtBillNumber_txtContent")).click();
        //driver.findElement(By.id("ctl00_activePage_txtBillNumber_txtContent")).sendKeys("1");
        // Bill number offset
        //driver.findElement(By.id("ctl00_activePage_txtOfficeCode_txtContent")).click();
        //driver.findElement(By.id("ctl00_activePage_txtOfficeCode_txtContent")).sendKeys("1");
        // Receivers account note
        driver.findElement(By.id("ctl00_activePage_txtDestComment_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestComment_txtContent")).sendKeys("1");
        // Amount
        driver.findElement(By.id("ctl00_activePage_amount_txtContent")).click();
        //driver.findElement(By.id("ctl00_activePage_amount_txtContent")).sendKeys("1", Keys.ENTER);
        // Submit
        driver.findElement(By.id("ctl00_activePage_addSatchelControl_btnNormalDoAction")).click();
        try {
            if (driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).getText();
            }
        } catch (Exception e) {

        }
        // Confirm
        driver.findElement(By.id("ctl00_activePage_doTransfer")).click();
        // Error Message
        try {
            if (driver.findElement(By.id("ctl00_activePage_resMessage")).isEnabled()) {
                return driver.findElement(By.id("ctl00_activePage_resMessage")).getText();
            }
        } catch (Exception e) {
        }

        try {
            if (driver.findElement(By.id("ctl00_activePage_TMPage4")).isEnabled()) {
                return driver.findElement(By.id("info")).getText();
            }
        } catch (Exception e) {
        }
        return accountlist.toString();
    }

    @RequestMapping(value = "/Paya", method = RequestMethod.POST)
    public String pasargadBankPaya(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("https://iben.bpi.ir/");
        js.executeScript("document.getElementById('StatemAgreementent').click();");
        driver.findElement(By.id("username_txtContent")).click();
        driver.findElement(By.id("username_txtContent")).sendKeys("baskanbey");
        js.executeScript("$('#password_placeHolderItem').click();");
        js.executeScript("$('#password_txtContent').val('" + "London123?" + "');");
        // Captcha image wrapper id
        //driver.findElement(By.id("captchaImg")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).sendKeys("CPTCH");
        driver.findElement(By.id("btnLogin")).click();
        try {
            if (driver.findElement(By.id("lblMessage")).isEnabled()) {
                return driver.findElement(By.id("lblMessage")).getText();
            }
        } catch (Exception e) {
        }
        js.executeScript("RedirectToPage(1041);");  // Redirect paya page
        // IBAN
        driver.findElement(By.id("txtValue1inpShomareShebaMaghsad")).click();
        //driver.findElement(By.id("txtValue1inpShomareShebaMaghsad")).sendKeys("123456123456123456123456");
        driver.findElement(By.id("txtValue1inpShomareShebaMaghsad")).sendKeys("200560080877702662178001");
        // Receiver first name
        driver.findElement(By.id("ctl00_activePage_txtDestFirstName_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestFirstName_txtContent")).sendKeys("Osman");
        // Receiver last name
        driver.findElement(By.id("ctl00_activePage_txtDestLastName_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestLastName_txtContent")).sendKeys("Osman");
        // Source note
        driver.findElement(By.id("ctl00_activePage_txtSrcDesc_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtSrcDesc_txtContent")).sendKeys("1");
        // Destiniton note
        driver.findElement(By.id("ctl00_activePage_txtDestDesc_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestDesc_txtContent")).sendKeys("1");
        // Bill number
        driver.findElement(By.id("ctl00_activePage_txtPaymentId_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtPaymentId_txtContent")).sendKeys("1");
        // Amount
        driver.findElement(By.id("ctl00_activePage_txtAmount_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtAmount_txtContent")).sendKeys("1");
        // Licence Agreement
        driver.findElement(By.id("ctl00_activePage_chkAgreement")).click();
        // Select account
        driver.findElement(By.id("ctl00_activePage_uDMSourceDeposit_imgBtnShowHideCardDepositBookRecordListView")).click();
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody")).getText());
        // Select first account
        driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody/tr[2]/td/a")).click();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub")));
            wait.until(ExpectedConditions.textToBePresentInElementValue((By.id("ctl00_activePage_uDMSourceDeposit_txtSelectedPageData")), "224.8000.13249114.1"));
        } catch (Exception e) {
            System.out.println(e);
        }
        // Submit button
        driver.findElement(By.id("ctl00_activePage_addSatchelControl_btnNormalDoAction")).click();
        //sometimes this id for iban number validation
        try {
            if (driver.findElement(By.id("inpShomareShebaMaghsad_revTotal")).isEnabled()) {
                return "iban number " + driver.findElement(By.id("inpShomareShebaMaghsad_revTotal")).getText();
            }
        } catch (Exception e) {
        }
        //sometimes this id for iban validation
        try {
            if (driver.findElement(By.id("inpShomareShebaMaghsad_rfvTotal")).isEnabled()) {
                return "iban number " + driver.findElement(By.id("inpShomareShebaMaghsad_rfvTotal")).getText();
            }
        } catch (Exception e) {
        }

        try {
            if (driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).getText();
            }
        } catch (Exception e) {
        }
        // Confirm
        if (driver.findElement(By.id("ctl00_activePage_doTransfer")).isEnabled()) {
            driver.findElement(By.id("ctl00_activePage_doTransfer")).click();
        } else {
            return "There is invalid enterence.";
        }
        try {
            if (driver.findElement(By.id("ctl00_activePage_Page4")).isEnabled()) {
                return driver.findElement(By.id("info")).getText();
            }
        } catch (Exception e) {
        }
        return "Error";
    }

    // This subject is not finished
    @RequestMapping(value = "/Satna", method = RequestMethod.POST)
    public String pasargadBankSatna(@RequestBody EnBankRequest enBankRequest, HttpSession session) {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        WebDriver driver = firefoxDriver.newDriver(session);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("https://iben.bpi.ir/");
        js.executeScript("document.getElementById('StatemAgreementent').click();");
        driver.findElement(By.id("username_txtContent")).click();
        driver.findElement(By.id("username_txtContent")).sendKeys("baskanbey");
        js.executeScript("$('#password_placeHolderItem').click();");
        js.executeScript("$('#password_txtContent').val('" + "London123?" + "');");
        // Captcha image wrapper id
        //driver.findElement(By.id("captchaImg")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).click();
        driver.findElement(By.id("zcaptchaTxt_txtContent")).sendKeys("CPTCH");
        driver.findElement(By.id("btnLogin")).click();
        try {
            if (driver.findElement(By.id("lblMessage")).isEnabled()) {
                return driver.findElement(By.id("lblMessage")).getText();
            }
        } catch (Exception e) {
        }
        driver.get("https://iben.bpi.ir/SatchelForms/SatchelRequestSatna.aspx");
        // Open combobox
        driver.findElement(By.id("ctl00_activePage_uDMSourceDeposit_imgBtnShowHideCardDepositBookRecordListView")).click();
        StringBuilder accountlist = new StringBuilder();
        accountlist.append(driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody")).getText());
        // Select first account
        driver.findElement(By.xpath("//*[@id='ctl00_activePage_uDMSourceDeposit_divForCardDepositBookRecords_Sub']/table/tbody/tr[2]/td/a")).click();
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("ctl00_activePage_txtAmount_textBoxControl")), "224.8000.13249114.1"));
        } catch (Exception e) {
        }
        // Bill number
        driver.findElement(By.id("ctl00_activePage_txtInstructionId_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtInstructionId_txtContent")).sendKeys("1");
        // Iban
        js.executeScript("$('#txtValue1inpShomareShebayeMaghsad').click();");
        js.executeScript("$('#txtValue1inpShomareShebayeMaghsad').val('" + "123456123456123456123456" + "');");
        // Receiver first name
        driver.findElement(By.id("ctl00_activePage_txtDestFirstName_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestFirstName_txtContent")).sendKeys("1");
        // Receiver last name
        driver.findElement(By.id("ctl00_activePage_txtDestLastName_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtDestLastName_txtContent")).sendKeys("1");
        // Amount
        driver.findElement(By.id("ctl00_activePage_txtAmount_txtContent")).click();
        driver.findElement(By.id("ctl00_activePage_txtAmount_txtContent")).sendKeys("1");
        // Licence agreement
        driver.findElement(By.id("ctl00_activePage_chkAgreement")).click();
        // Send button
        driver.findElement(By.id("ctl00_activePage_addSatchelControl_btnNormalDoAction")).click();

        try {
            if (driver.findElement(By.id("inpShomareShebaMaghsad_revTotal")).isEnabled()) {
                return "iban number " + driver.findElement(By.id("inpShomareShebaMaghsad_revTotal")).getText();
            }
        } catch (Exception e) {
        }
        //sometimes this id for iban validation
        try {
            if (driver.findElement(By.id("inpShomareShebaMaghsad_rfvTotal")).isEnabled()) {
                return "iban number " + driver.findElement(By.id("inpShomareShebaMaghsad_rfvTotal")).getText();
            }
        } catch (Exception e) {
        }

        try {
            if (driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).isEnabled()) {
                return driver.findElement(By.xpath("//*[@id='ctl00_activePage_CustomValidator1']/ul")).getText();
            }
        } catch (Exception e) {
        }
        return accountlist.toString();
    }
}
