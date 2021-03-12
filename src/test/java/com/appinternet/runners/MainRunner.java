package com.appinternet.runners;

import com.appinternet.base.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/java/resources/features/"}, glue= {
        "steps" }, monochrome = true, tags = {},
        plugin = {"pretty", "html:target/htmlreports"})

public class MainRunner extends AbstractTestNGCucumberTests {



}