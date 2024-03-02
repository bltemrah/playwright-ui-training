package org.eurotech;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class C_9_Tracing {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = browser.newPage();

        page.navigate("https://demo.guru99.com/test/newtours/register.php");
        page.locator("#gdpr-consent-tool-wrapper").click();
        page.frameLocator("internal:role=dialog[name=\"Privacy Manager window\"i]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Accept All")).click();
        page.locator("input[name=\"firstName\"]").click();
        page.locator("input[name=\"firstName\"]").fill("Emrah");
        page.locator("input[name=\"lastName\"]").click();
        page.locator("input[name=\"lastName\"]").fill("Bulut");
        page.locator("#userName").click();
        page.locator("#userName").fill("bltemrah@gmail.com");
        page.locator("input[name=\"city\"]").click();
        page.locator("input[name=\"city\"]").fill("Reading");
        page.locator("input[name=\"postalCode\"]").click();
        page.locator("input[name=\"postalCode\"]").fill("RG48XH");

        // close the browser
        browser.close();

        // If we want to close interact the server, I mean Playwright, we need to run:
        playwright.close();

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }
}
