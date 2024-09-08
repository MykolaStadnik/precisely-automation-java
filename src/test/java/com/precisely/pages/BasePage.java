package com.precisely.pages;

import com.precisely.utilities.ConfigurationReader;
import com.precisely.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement acceptAllCookiesBtn;

    public void navigateToHomePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    public void navigateToMenuOption(String menuName){
        Driver.getDriver().findElement(By.xpath("//ul[@id='menu-main-navigation']//a[.='"+menuName+"']")).click();
    }









}
