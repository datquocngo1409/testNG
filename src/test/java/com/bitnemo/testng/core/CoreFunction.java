package com.bitnemo.testng.core;

import com.bitnemo.testng.pages.LoginPage;
import com.bitnemo.testng.pages.MainPage;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

// Singleton Class
public class CoreFunction {
    private static CoreFunction instance;
    private CoreFunction() {}
    public static CoreFunction getInstance() {
        if (instance == null) {
            synchronized(CoreFunction.class) {
                if(null == instance) {
                    instance  = new CoreFunction();
                }
            }
        }
        return instance;
    }

    GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();
    ScreenRecorder screenRecorder;

    {
        try {
            screenRecorder = new ScreenRecorder(gc,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, (int) (15 * 60)),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
                            FrameRateKey, Rational.valueOf(30)),
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    LoginPage loginPage = LoginPage.getInstance();
    MainPage mainPage = MainPage.getInstance();
    public void login() {
        try {
            boolean isLoggedIn = mainPage.getUserItem().isDisplayed();
        } catch (Exception e) {
            String url = getUrl();
            open(url);
            loginPage.getInputUsername().sendKeys("linhht@bitnemo.vn");
            loginPage.getInputPassword().sendKeys("Admin19101");
            loginPage.getLoginButton().click();
            while (!mainPage.getUserItem().isDisplayed()) {
                sleep(500);
            }
            sessionStorage().setItem("userLoggedIn", "linhht@bitnemo.vn");
        }
    }

    private String getUrl() {
        if (System.getenv().get("URL") == null) return "https://int.logifleet360.ch";
        switch (System.getenv().get("URL")) {
            case "INT": {
                return "https://int.logifleet360.ch/";
            }
            case "PTA": {
                return "https://pta.logifleet360.ch/";
            }
            case "PRD": {
                return "https://logifleet360.ch/";
            }
            default: {
                return "https://int.logifleet360.ch/";
            }
        }
    }

    public void startRecord() {
        try {
            screenRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecord() {
        try {
            screenRecorder.stop();
            List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
            for(File movie : createdMovieFiles){
                System.out.println("New movie created: " + movie.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
