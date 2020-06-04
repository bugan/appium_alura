import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {


    static private AppiumDriverConfig _instance;
    static AppiumDriverConfig Instance() {
        if (AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return  AppiumDriverConfig._instance;
    }

    private AppiumDriver driver;
    public AppiumDriver getDriver() {
        return driver;
    }

    private AppiumDriverConfig() {
        driver = init();
    }

    private AppiumDriver init() {
        var dotenv = loadDotEnv();
        File app = new File(dotenv.get("APK_PATH"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("DEVICE_NAME"));
        capabilities.setCapability(MobileCapabilityType.APP , app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME , "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AppiumDriver<>(
                    new URL("http://" + dotenv.get("IP") + ":" + dotenv.get("PORT") + "/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.resetApp();
        return driver;
    }

    private static Dotenv loadDotEnv() {
        return Dotenv.configure()
                .directory("./src/main/resources/.env")
                .load();

    }
}
