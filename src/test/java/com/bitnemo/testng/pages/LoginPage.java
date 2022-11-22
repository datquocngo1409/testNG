package com.bitnemo.testng.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Singleton Class
public class LoginPage {
    private static LoginPage instance;
    private LoginPage() {}
    public static LoginPage getInstance() {
        if (instance == null) {
            synchronized(LoginPage.class) {
                if(null == instance) {
                    instance  = new LoginPage();
                }
            }
        }
        return instance;
    }

    private final SelenideElement inputUsername = $("input[id='user-input']");
    private final SelenideElement inputPassword = $("input[id='password-input']");
    private final SelenideElement loginButton = $("button[class='button secondary login-button large-header']");

    public SelenideElement getInputUsername() {
        return inputUsername;
    }

    public SelenideElement getInputPassword() {
        return inputPassword;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }
}
