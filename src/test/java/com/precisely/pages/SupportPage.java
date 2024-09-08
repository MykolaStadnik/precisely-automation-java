package com.precisely.pages;

import com.precisely.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SupportPage {
    public SupportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateToSupportOption(String supportOption){
        Driver.getDriver().findElement(By.xpath("//div[@class='container mt-4 d-flex flex-wrap w-75 align-bottom']//a[.='"+supportOption+"']")).click();
    }




}
