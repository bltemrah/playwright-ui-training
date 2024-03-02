package org.eurotech;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class C_10_BrowserContext {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context1 = browser.newContext();


        Page page1 = context1.newPage();
        page1.navigate("https://www.orangehrm.com/en/30-day-free-trial");

        System.out.println("page1.title() = " + page1.title());

        page1.waitForTimeout(3000);

        Page page2 = context1.newPage();
        page2.navigate("https://automationexercise.com/test_cases");

        System.out.println("page2.title() = " + page2.title());

        page2.waitForTimeout(3000);

        BrowserContext context2 = browser.newContext();
        Page page3 = context2.newPage();
        page3.navigate("https://demo.guru99.com/test/newtours/register.php");

        System.out.println("page3.title() = " + page3.title());

        // close the browser
        browser.close();

        // If we want to close interact the server, I mean Playwright, we need to run:
        playwright.close();
    }
}
