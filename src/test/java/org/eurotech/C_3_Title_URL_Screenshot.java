package org.eurotech;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class C_3_Title_URL_Screenshot {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch();

        Page page = browser.newPage();

        page.navigate("http://www.amazon.com");

//        page.waitForTimeout(3000);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));

//        page.waitForTimeout(3000);

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
