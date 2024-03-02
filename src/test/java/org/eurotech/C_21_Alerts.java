package org.eurotech;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class C_21_Alerts {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.click("text='Click for JS Alert'");

        page.waitForTimeout(5000);

        page.close();
        browser.close();
        playwright.close();

    }
}
