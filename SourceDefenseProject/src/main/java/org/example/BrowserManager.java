package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.FileUtils;
import org.example.utils.MetricsCollector;
import org.example.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import java.io.File;
import java.util.List;

public class BrowserManager {

    public static WebDriver driver;
    private static String URL = Utilities.getProperty("url");
    private static String BROWSER = Utilities.getProperty("ui.browser.type");
    private static String OUTPUT_FOLDER = Utilities.getProperty("output.folder");
    private static int TIMEOUT = Utilities.getPropertyAsInteger("timeout");
    private static int LOOP_SIZE = Utilities.getPropertyAsInteger("loop.size");
    public static Logger log = LogManager.getLogger(BrowserManager.class.getName());

    public static void main(String[] args) throws InterruptedException {

        setup();
        log.info("Number of loops are: " + LOOP_SIZE);
        for(int i=0; i<LOOP_SIZE; i++) {
            driver.get(URL);

            //part of requirement to wait 30 seconds after launching the page
            Thread.sleep(TIMEOUT);
            log.info("Timeout is over!! Now let's get the requested metrics...");

            //Create output folder to store assignment files
            FileUtils.createFolder(new File(OUTPUT_FOLDER), false);

            //create lists to store both console logs metrics & network metrics
            List<String> networkMessagesList = MetricsCollector.interceptRequests(driver, LogType.PERFORMANCE);
            List<String> consoleLogMessagesList = MetricsCollector.interceptRequests(driver, LogType.BROWSER);

            //Write to files the metrics inside output folder
            FileUtils.writeToFile(OUTPUT_FOLDER.concat("/" + randSuffix("network") + ".json"), networkMessagesList);
            FileUtils.writeToFile(OUTPUT_FOLDER.concat("/" + randSuffix("console_log") + ".txt"), consoleLogMessagesList);
        }

        teardown();
    }

    private static void teardown() {
        driver.close();
    }

    private static void setup() {
        //get browser type
        log.info(String.format("The requested browser is: %s", BROWSER));

        //get url for the program
        log.info(String.format("The requested url is: %s", URL));

        //init webdriver to start browsing the net
        driver = Utilities.initWebDriver(BROWSER);
    }

    protected static String randSuffix(String prefix){
        return prefix + "_" + System.nanoTime();
    }

}
