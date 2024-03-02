package org.eurotech;

import com.microsoft.playwright.*;

public class C_14_Iframe {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration");

        page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

        page.waitForTimeout(3000);

        page.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("#RESULT_TextField-1").fill("John");

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
