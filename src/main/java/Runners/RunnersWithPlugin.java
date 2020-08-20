package Runners;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions(

        plugin = {
                "html:target/cucumber-Html-Report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportSmokeTest.html" // to generate a extend report we need this plugin
        },

        tags = {"@SmokeTest"},
        features = {"src/test/java/Featurefiles"},
        glue = {"StepDefinitions"},
        dryRun = false

)


public class RunnersWithPlugin extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass(){

        Reporter.loadXMLConfig(new File("src/test/java/FeatureFiles/extentReport.xml"));
        Reporter.setSystemInfo("User Name" , "Dogan");
        Reporter.setSystemInfo("Application Name", "smartbearsoftware");
        Reporter.setSystemInfo("Operating System Type" , System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber report");
    }
}

