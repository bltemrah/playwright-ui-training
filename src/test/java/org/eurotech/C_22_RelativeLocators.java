package org.eurotech;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C_22_RelativeLocators {

    static Page page;

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

        page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();

        page.waitForTimeout(9000);


        page.close();
        browser.close();
        playwright.close();

    }
}
