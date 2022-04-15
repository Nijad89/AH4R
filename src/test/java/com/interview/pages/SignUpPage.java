package com.interview.pages;

import com.github.javafaker.Faker;
import com.interview.utils.Driver;
import org.bouncycastle.cms.PasswordRecipientInfoGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class SignUpPage {

    Faker faker = new Faker();

    public SignUpPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//div[@class='flex items-center ml-0 lg:ml-auto']/button[.='Sign Up']")
    public WebElement signUP;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createAccountButton;


    @FindBy(xpath = "//h2[.='Congratulations!']")
    public WebElement confirmMsg;



    public void setSignUP() {
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        String str= faker.internet().password();
        str = str.substring(0,2).toUpperCase(Locale.ROOT) + str.substring(2);
        password.sendKeys(str);
        createAccountButton.click();
    }


}

