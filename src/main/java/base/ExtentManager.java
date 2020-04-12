package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;


import java.io.File;
import java.text.SimpleDateFormat;

import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String suiteName) {
        if (extent == null)
            createInstance(suiteName);
        return extent;
    }

    public static ExtentReports createInstance(String suiteName) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM.dd.yyyy_hh.mm");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
                File.separator + "reports" + File.separator + suiteName + "-" + ft.format(dNow) + ".html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Acceptance Tests");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Givelify");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
