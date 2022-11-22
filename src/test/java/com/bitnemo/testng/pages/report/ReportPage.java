package com.bitnemo.testng.pages.report;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton Class
public class ReportPage {
    private static ReportPage instance;
    private ReportPage() {}
    public static ReportPage getInstance() {
        if (instance == null) {
            synchronized(ReportPage.class) {
                if(null == instance) {
                    instance  = new ReportPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement reportSubNavbar = $("a[id='reportLogo']");
    private final SelenideElement subscribeSubNavbar = $("a[id='subscribeLogo']");
    private final SelenideElement journeyReport = $("div[id='reportJourneyStep1']");
    private final SelenideElement machineReport = $("div[id='reportMachineStep1']");
    private final SelenideElement toolReport = $("div[id='reportToolStep1']");
    private final SelenideElement geozoneReport = $("div[id='reportGeozoneStep1']");
    private final SelenideElement temperatureReport = $("div[id='reportTemperatureStep1']");
    private final SelenideElement notificationReport = $("div[id='reportNotificationStep1']");
    private final SelenideElement workingTimeReport = $("div[id='reportWorkingTimeStep1']");
    private final SelenideElement equipmentReport = $("div[id='reportEquipmentStep1']");

    public SelenideElement getReportSubNavbar() {
        return reportSubNavbar;
    }

    public SelenideElement getSubscribeSubNavbar() {
        return subscribeSubNavbar;
    }

    public SelenideElement getJourneyReport() {
        return journeyReport;
    }

    public SelenideElement getMachineReport() {
        return machineReport;
    }

    public SelenideElement getToolReport() {
        return toolReport;
    }

    public SelenideElement getGeozoneReport() {
        return geozoneReport;
    }

    public SelenideElement getTemperatureReport() {
        return temperatureReport;
    }

    public SelenideElement getNotificationReport() {
        return notificationReport;
    }

    public SelenideElement getWorkingTimeReport() {
        return workingTimeReport;
    }

    public SelenideElement getEquipmentReport() {
        return equipmentReport;
    }
}
