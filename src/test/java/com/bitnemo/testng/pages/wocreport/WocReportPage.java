package com.bitnemo.testng.pages.wocreport;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton Class
public class WocReportPage {
    private static WocReportPage instance;
    private WocReportPage() {}
    public static WocReportPage getInstance() {
        if (instance == null) {
            synchronized(WocReportPage.class) {
                if(null == instance) {
                    instance  = new WocReportPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement radioLabelThisWeek = $("label[for='timeframe-thisweek']");
    private final SelenideElement radioLabelLastWeek = $("label[for='timeframe-lastweek']");
    private final SelenideElement radioLabelThisMonth = $("label[for='timeframe-thismonth']");
    private final SelenideElement radioLabelLastMonth = $("label[for='timeframe-lastmonth']");
    private final SelenideElement radioLabelCustom = $("label[for='timeframe-custom']");
    private final SelenideElement radioLabelAll = $("label[for='timeframe-all']");
    private final SelenideElement showButton = $("button[class='button ok ng-binding']");

    public SelenideElement getRadioLabelThisWeek() {
        return radioLabelThisWeek;
    }

    public SelenideElement getRadioLabelLastWeek() {
        return radioLabelLastWeek;
    }

    public SelenideElement getRadioLabelThisMonth() {
        return radioLabelThisMonth;
    }

    public SelenideElement getRadioLabelLastMonth() {
        return radioLabelLastMonth;
    }

    public SelenideElement getRadioLabelCustom() {
        return radioLabelCustom;
    }

    public SelenideElement getRadioLabelAll() {
        return radioLabelAll;
    }

    public SelenideElement getShowButton() {
        return showButton;
    }
}
