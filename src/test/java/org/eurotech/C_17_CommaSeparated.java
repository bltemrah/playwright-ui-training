package org.eurotech;

import com.microsoft.playwright.*;
import org.xml.sax.Locator;

public class C_17_CommaSeparated {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://aws.amazon.com/");

        page.locator("a:has-text('Contact Us'),"
                + "a:has-text('Contact'), "
                + "a:has-text('Contact Us'), "
                + "a:has-text('Call Us'), "
                + "a:has-text('Support'), "
        );

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
