package org.eurotech;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class C_20_SkipLoginStep {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext =
                browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

        Page page = browserContext.newPage();
        page.navigate("https://www.lambdatest.com/");

        page.waitForTimeout(5000);

        page.close();
        browser.close();
        playwright.close();

    }
}
