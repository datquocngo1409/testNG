package com.bitnemo.testng.testcase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.bitnemo.testng.base.CoreFunction;
import com.bitnemo.testng.pages.MainPage;
import com.bitnemo.testng.pages.settings.SettingPage;
import com.bitnemo.testng.pages.settings.woc.SettingWocPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingTest {
    CoreFunction coreFunction = CoreFunction.getInstance();
    MainPage mainPage = MainPage.getInstance();
    SettingPage settingPage = SettingPage.getInstance();
    SettingWocPage settingWocPage = SettingWocPage.getInstance();

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
        settingPage.getGoToPersons().click();
    }

    @Test(priority = 2)
    public void goToWOCSetting() {
        // coreFunction.startRecord();
        mainPage.getSetting().click();
        settingPage.getGoToWOCSetting().click();
        settingWocPage.getGoToLicense().click();
        settingWocPage.getGoToWorker().click();
        settingWocPage.getGoToTeam().click();
        // String screenshot = screenshot("screenshot");
        // it will be saved in build/reports/tests/screenshot.png
        settingWocPage.getGoToSet().click();
        settingWocPage.getGoToMaterial().click();
        settingWocPage.getGoToMaterialSet().click();
        settingWocPage.getGoToProject().click();
        settingWocPage.getGoToActive().click();
        // coreFunction.stopRecord();
        // file location will show in log
    }
}
