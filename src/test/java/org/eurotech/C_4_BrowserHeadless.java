package org.eurotech;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C_4_BrowserHeadless {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.ebay.co.uk/");

        String title = page.title();
        System.out.println("title = " + title);

        String url = page.url();
        System.out.println("url = " + url);

        // close the browser
        browser.close();

        // If we want to close interact the server, I mean Playwright, we need to run:
        playwright.close();

    }
}
