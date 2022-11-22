package com.bitnemo.testng.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton Class
public class MainPage {
    private static MainPage instance;
    private MainPage() {}
    public static MainPage getInstance() {
        if (instance == null) {
            synchronized(MainPage.class) {
                if(null == instance) {
                    instance  = new MainPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement liveTracking = $("li[id='trackingStep1']");
    private final SelenideElement report = $("li[id='reportStep1']");
    private final SelenideElement dashboard = $("li[id='dashboardStep1']");
    private final SelenideElement wocReport = $("li[id='wocStep1']");
    private final SelenideElement setting = $("[id='settingStep1']");
    private final SelenideElement userItem = $("[data-toggle='user-menu']");

    public SelenideElement getLiveTracking() {
        return liveTracking;
    }

    public SelenideElement getReport() {
        return report;
    }

    public SelenideElement getDashboard() {
        return dashboard;
    }

    public SelenideElement getWocReport() {
        return wocReport;
    }

    public SelenideElement getSetting() {
        return setting;
    }

    public SelenideElement getUserItem() {
        return userItem;
    }
}
