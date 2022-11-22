package com.bitnemo.testng.pages.settings.woc;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton class
public class SettingWocPage {
    private static SettingWocPage instance;
    private SettingWocPage() {}
    public static SettingWocPage getInstance() {
        if (instance == null) {
            synchronized(SettingWocPage.class) {
                if(null == instance) {
                    instance  = new SettingWocPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement goToLicense       = $("li[id='license-heading']");
    private final SelenideElement goToWorker        = $("li[id='worker-heading']");
    private final SelenideElement goToTeam          = $("li[id='team-heading']");
    private final SelenideElement goToSet           = $("li[id='set-heading']");
    private final SelenideElement goToMaterial      = $("li[id='materials-heading']");
    private final SelenideElement goToMaterialSet   = $("li[id='material-sets-heading']");
    private final SelenideElement goToProject       = $("li[id='project-heading']");
    private final SelenideElement goToActive        = $("li[id='activity-heading']");

    public SelenideElement getGoToLicense() {
        return goToLicense;
    }

    public SelenideElement getGoToWorker() {
        return goToWorker;
    }

    public SelenideElement getGoToTeam() {
        return goToTeam;
    }

    public SelenideElement getGoToSet() {
        return goToSet;
    }

    public SelenideElement getGoToMaterial() {
        return goToMaterial;
    }

    public SelenideElement getGoToMaterialSet() {
        return goToMaterialSet;
    }

    public SelenideElement getGoToProject() {
        return goToProject;
    }

    public SelenideElement getGoToActive() {
        return goToActive;
    }
}
