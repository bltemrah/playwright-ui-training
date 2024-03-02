package org.eurotech;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class C_19_LoginSave {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();

        page.navigate("https://www.lambdatest.com/");

        Locator login = page.locator("text='Login'");
        login.click();

        Locator email = page.locator("#email");
        email.fill("bltemrah@gmail.com");

        Locator password = page.locator("#password");
        password.fill("Test12345");

        page.waitForTimeout(3000);

        Locator loginButton = page.locator("#login-button");
        loginButton.click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

        page.waitForTimeout(5000);

        page.close();
        browser.close();
        playwright.close();

    }
}
