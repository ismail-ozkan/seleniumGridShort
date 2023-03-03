package com.seleniumgrid.pages;

import com.seleniumgrid.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this );
    }

    @FindBy(id= "prependedInput")
    public WebElement loginUser;

    @FindBy(id= "prependedInput2")
    public WebElement loginPassword;

     @FindBy(id= "_submit")
    public WebElement loginButton;

     public void login(String username, String password){
         loginUser.sendKeys(username);
         loginPassword.sendKeys(password);
         loginButton.click();
     }


}
