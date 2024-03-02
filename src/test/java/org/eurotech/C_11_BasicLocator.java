package org.eurotech;

import com.microsoft.playwright.*;

public class C_11_BasicLocator {

    public static void main(String[] args) {

        Playwright  playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context1 = browser.newContext();

        Page page = context1.newPage();
        page.navigate("https://www.orangehrm.com/");

        Locator contactSales = page.locator("text = Contact Sales");

        int totalNumberOfContactSales = contactSales.count();
        System.out.println("Total Number of Contact Sales: " + totalNumberOfContactSales);

        page.waitForTimeout(3000);

        contactSales.nth(1).click();

    }
}
