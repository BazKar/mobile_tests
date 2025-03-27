package tests.android;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackmodileDriver;
import helpers.Attach;
//import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


public class TestBase {
    @BeforeAll
    public static void setup(){
        Configuration.browser = BrowserstackmodileDriver.class.getName();
        Configuration.browserSize = null;


    }
    @BeforeEach
    void startDriver(){
        //addListener("AllureSelenide", new AllureSelenide());
        open();
    }
    @AfterEach
    public void tearDown(){
        String sessionId = sessionId().toString();
        System.out.println(sessionId);
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        //attach

    }
}
