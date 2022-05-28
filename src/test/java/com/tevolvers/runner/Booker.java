package com.tevolvers.runner;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/booker.feature",
        glue = "com.tevolvers.stepdefinitions",
        snippets = SnippetType.CAMELCASE)

public class Booker {
}
