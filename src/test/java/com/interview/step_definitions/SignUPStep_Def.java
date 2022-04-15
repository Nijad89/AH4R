package com.interview.step_definitions;

import com.interview.pages.SignUpPage;
import com.interview.utils.ConfigurationReader;
import com.interview.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPStep_Def {

    WebDriver driver;
    SignUpPage page = new SignUpPage();

    @Given("User in AH4R  homepage")
    public void user_in_ah4r_homepage() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("ah4r.url"));
        Assert.assertEquals("Home | American Homes 4 Rent", driver.getTitle());

    }


    @When("User clicks on signUp button")
    public void user_clicks_on_sign_up_button() {
        page.signUP.click();
    }


    @And("User enters sigUp credentials and hits create button")
    public void userEntersSigUpCredentialsAndHitsCreateButton() {
        page.setSignUP();
    }

    @Then("User should see congratulations confirmation message")
    public void userShouldSeeCongratulationsConfirmationMessage() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(page.confirmMsg));
        Assert.assertTrue(page.confirmMsg.isDisplayed());


    }


}
