package org.fundacionjala.core.driver;

import org.fundacionjala.core.browser.Browser;
import org.fundacionjala.core.browser.BrowserStack;
import org.fundacionjala.core.browser.Chrome;
import org.fundacionjala.core.browser.ChromeHeadless;
import org.fundacionjala.core.browser.SauceLabs;
import org.openqa.selenium.WebDriver;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory() {
    }

    private static final Map<DriverType, Supplier<Browser>> BROWSERS = new EnumMap<>(DriverType.class);

    static {
        BROWSERS.put(DriverType.CHROME, Chrome::new);
        BROWSERS.put(DriverType.CHROME_HEADLESS, ChromeHeadless::new);
        BROWSERS.put(DriverType.BROWSER_STACK, BrowserStack::new);
        BROWSERS.put(DriverType.SAUCE_LABS, SauceLabs::new);
    }

    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSERS.getOrDefault(driverType, Chrome::new).get().getBrowser();
    }
}
