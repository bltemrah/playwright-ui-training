package org.eurotech;

import com.microsoft.playwright.*;

public class C_13_FrameLocate {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        String header = page.frameLocator("frame[name='void1']").locator("title").textContent();
        System.out.println("header = " + header);

        page.close();
        browser.close();
        playwright.close();

    }
}
