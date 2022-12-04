package com.bitnemo.testng.testcase;

import com.bitnemo.testng.base.CoreFunction;
import com.bitnemo.testng.pages.MainPage;
import com.bitnemo.testng.pages.report.ReportPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class ReportTest {
    CoreFunction coreFunction = CoreFunction.getInstance();
    MainPage mainPage = MainPage.getInstance();
    ReportPage reportPage = ReportPage.getInstance();

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
    public void showReport() {
        mainPage.getReport().click();
        reportPage.getJourneyReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getMachineReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getToolReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getGeozoneReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getTemperatureReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getNotificationReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getWorkingTimeReport().click();
        reportPage.getReportSubNavbar().click();
        reportPage.getEquipmentReport().click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
