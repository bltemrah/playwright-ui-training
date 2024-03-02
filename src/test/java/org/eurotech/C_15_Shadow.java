package org.eurotech;

import com.microsoft.playwright.*;

public class C_15_Shadow {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://books-pwakit.appspot.com");

//        page.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("#RESULT_TextField-1").fill("John");

        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
