package org.eurotech;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class C_6_CodeGen {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.wikipedia.org/");
        page.getByLabel("Search Wikipedia").click();
        page.getByLabel("Search Wikipedia").fill("Playwright Automation Framework");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
        page.navigate("https://en.wikipedia.org/wiki/Special:Search?go=Go&search=Playwright+Automation+Framework&ns0=1&searchToken=3b3gwvxhc40y96n9slpyqhn4p");
        page.navigate("https://en.wikipedia.org/wiki/Playwright_(software)?wprov=srpw1_0");
        page.navigate("https://en.wikipedia.org/wiki/Playwright_(software)");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("\"Playwright, a Time-Saving")).click();

        // close the browser
        browser.close();

        // If we want to close interact the server, I mean Playwright, we need to run:
        playwright.close();

    }
}
