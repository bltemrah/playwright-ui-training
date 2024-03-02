package org.eurotech;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class C_2_ScreenShot {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.firefox().launch();

        Page page = browser.newPage();

        page.navigate("https://playwright.dev/");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        browser.close();

        playwright.close();

    }
}
