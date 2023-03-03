package com.seleniumgrid.pages;

import com.seleniumgrid.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashBoardPage extends VyTrackLoginPage{
    public VyTrackDashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@id='user-menu']//a)[1]")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        logOutLink.click();
    }


}
