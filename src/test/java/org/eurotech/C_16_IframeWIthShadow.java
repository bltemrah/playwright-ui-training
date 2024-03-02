package org.eurotech;

import com.microsoft.playwright.*;

public class C_16_IframeWIthShadow {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");

        page.waitForTimeout(3000);

        page.frameLocator("#pact").locator("div#snacktime #tea").fill("Evet");

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
