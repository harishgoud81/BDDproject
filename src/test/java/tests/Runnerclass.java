package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\Harish\\Desktop\\Selenium\\com.gmail_login.BDD\\src\\test\\resources\\proprtis\\feature3.feature",
		                     "C:\\Users\\Harish\\Desktop\\Selenium\\com.gmail_login.BDD\\src\\test\\resources\\proprtis\\4.feature"},
                  monochrome=true,plugin= {"pretty","html:target\\gmailresults"})


public class Runnerclass {

}
