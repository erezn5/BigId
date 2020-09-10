package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class Utilities {

    private static Properties props;

    static{
        initProps();
    }

    public static WebDriver initWebDriver(String browser){

        switch (browser){
            case "chrome":
                return createChromeInstance();
            case "firefox":
                return createFirefoxInstance();
            default:
                throw new IllegalArgumentException("'" + browser + "'no such browser type");
        }

    }

    private static DesiredCapabilities setCapabilities(){
        DesiredCapabilities d = new DesiredCapabilities();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return d;
    }

    private static WebDriver createFirefoxInstance(){
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities d = setCapabilities();
        return new FirefoxDriver(d);
    }

    private static WebDriver createChromeInstance(){
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities d = setCapabilities();
        return new ChromeDriver(d);
    }

    public static void initProps()  {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/java/org/example/resources/data.properties");
            props.load(fis);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static int getPropertyAsInteger(String property){
        return Integer.parseInt(props.getProperty(property));
    }

    public static String getProperty(String property){
        return props.getProperty(property);
    }
}
