package org.eurotech;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class C_7_PWdebug {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://demo.guru99.com/test/newtours/register.php");
        page.locator("#gdpr-consent-tool-wrapper").click();
        page.frameLocator("internal:role=dialog[name=\"Privacy Manager window\"i]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Accept All")).click();
        page.locator("input[name=\"firstName\"]").click();
        page.locator("input[name=\"firstName\"]").fill("Emrah");
        page.locator("input[name=\"lastName\"]").click();
        page.locator("input[name=\"lastName\"]").fill("Bulut");
        page.locator("#userName").fill("bltemrah@gmail.com");
        page.locator("input[name=\"city\"]").fill("Reading");
        page.locator("input[name=\"postalCode\"]").fill("RG48XH");
    }
}
