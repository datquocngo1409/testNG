package com.bitnemo.testng.testcase;

import com.bitnemo.testng.base.CoreFunction;
import com.bitnemo.testng.pages.MainPage;
import com.bitnemo.testng.pages.wocreport.WocReportPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WocReportTest {
    CoreFunction coreFunction = CoreFunction.getInstance();
    MainPage mainPage = MainPage.getInstance();
    WocReportPage wocReportPage = WocReportPage.getInstance();

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
    public void showWOCReport() {
        mainPage.getWocReport().click();
        wocReportPage.getRadioLabelThisMonth().click();
        wocReportPage.getShowButton().click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
