package com.bitnemo.testng.pages.settings;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton Class
public class SettingPage {
    private static SettingPage instance;
    private SettingPage() {}
    public static SettingPage getInstance() {
        if (instance == null) {
            synchronized(SettingPage.class) {
                if(null == instance) {
                    instance  = new SettingPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement goToPersons = $("div[class='settings-button']");
    private final SelenideElement goToGroups = $("a[id='settings-groups-icon']");
    private final SelenideElement goToWOCSetting = $("a[id='settings-woc-icon']");

    public SelenideElement getGoToPersons() {
        return goToPersons;
    }

    public SelenideElement getGoToGroups() {
        return goToGroups;
    }

    public SelenideElement getGoToWOCSetting() {
        return goToWOCSetting;
    }
}
