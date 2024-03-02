package org.eurotech;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;

public class C_1_App {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch();

        Page page = browser.newPage();

        page.navigate("http://playwright.dev/java");

        String title = page.title();

        System.out.println("title = " + title);

        browser.close();

        playwright.close();

    }

}
