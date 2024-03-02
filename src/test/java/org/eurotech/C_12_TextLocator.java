package org.eurotech;

import com.microsoft.playwright.*;

public class C_12_TextLocator {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

//        Locator orangeHrm = page.locator("text = Privacy Policy");

        Locator orangeHrm = page.locator("text=OrangeHRM");

        for (int i = 0; i < orangeHrm.count(); i++) {
            System.out.println(orangeHrm.nth(i).textContent());
        }

        for (int i = 0; i < orangeHrm.count(); i++) {
            String text = orangeHrm.nth(i).textContent();
            if (text.contains("OrangeHRM")) {
                orangeHrm.nth(i).click();
                break;
            }
        }

//        privacyPolicy.nth(1).click();

        page.waitForTimeout(3000);



        browser.close();
        playwright.close();

    }
}
