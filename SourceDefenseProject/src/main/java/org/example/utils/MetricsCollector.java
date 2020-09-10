package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class MetricsCollector {

    public static List<String> interceptRequests(WebDriver driver, String logType) {
        LogEntries les = driver.manage().logs().get(logType);
        List<String> metricsList = new ArrayList<>();
        for (LogEntry le : les) {
            if(logType.equalsIgnoreCase(LogType.BROWSER)) {
                metricsList.add(le.getLevel() + " " + le.getMessage());
            }else{
                metricsList.add(le.getMessage());
            }
        }
        return metricsList;
    }
}
