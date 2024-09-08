package com.precisely.pages;

import com.precisely.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHelpPage {
    public ProductHelpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input.search")
    public WebElement filterByNameInput;



}
