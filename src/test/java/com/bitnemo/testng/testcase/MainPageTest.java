package com.bitnemo.testng.testcase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.bitnemo.testng.base.CoreFunction;
import com.bitnemo.testng.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

public class MainPageTest {
    MainPage mainPage = MainPage.getInstance();
    CoreFunction coreFunction = CoreFunction.getInstance();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        coreFunction.login();
    }

    @Test(priority = 1)
    public void goToSetting() {
        mainPage.getSetting().click();
    }

    @Test(priority = 2)
    public void testUserMenu() {
        mainPage.getUserItem().click();
    }
}
