package com.itc.imforms;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
            "json:target_json/cucumber.json",
            "pretty"
        }
)

public class MyFormsRunner {
    
     @AfterClass
    public static void tearDown() {

    }
}
