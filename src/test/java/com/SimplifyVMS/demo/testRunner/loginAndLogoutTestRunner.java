package com.SimplifyVMS.demo.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/login.feature",
        glue = {"demo/stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports/simplifyvms.html","json:target/cucumber-reports/simplifyvms.json", "junit:target/cucumber-reports/simplifyvms.xml" },
        tags="@SimplifyVMS_Login",
        monochrome = true)

public class loginAndLogoutTestRunner {
}
