package org.eurotech;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;
import java.util.List;

public class C_5_LaunchOptions {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        //LaunchOptions
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();

        List<BrowserType> browserTypes = new ArrayList<>();
        browserTypes.add(playwright.chromium());
        browserTypes.add(playwright.firefox());

        for (BrowserType browserType : browserTypes) {
            Browser browser = browserType.launch(lp);
            lp.setHeadless(false);
            Page page = browser.newPage();
            page.navigate("http://www.amazon.com");

            String title = page.title();
            System.out.println("title = " + title);

            String url = page.url();
            System.out.println("url = " + url);
        }
    }
}
