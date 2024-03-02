package org.eurotech;

import com.microsoft.playwright.*;

public class C_18_CommaSeparatedXpath {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

        page.locator("//a[text()='Login'] | //a[text()='Sigin']")
                .click();

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
