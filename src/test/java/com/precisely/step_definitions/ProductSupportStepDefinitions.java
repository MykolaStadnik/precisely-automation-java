package com.precisely.step_definitions;

import com.precisely.pages.HomePage;
import com.precisely.pages.ProductHelpPage;
import com.precisely.pages.SupportPage;
import com.precisely.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSupportStepDefinitions {
    HomePage homePage = new HomePage();

    @When("user is on the home page of Precisely")
    public void user_is_on_the_home_page_of_Precisely() {
        homePage.navigateToHomePage();
        BrowserUtils.waitForVisibility(homePage.acceptAllCookiesBtn,10);
        homePage.acceptAllCookiesBtn.click();
    }

    @Then("user should see title {string}")
    public void user_should_see_title(String title) {
        BrowserUtils.verifyTitle(title);
    }

    @Then("user clicks menu option {string}")
    public void user_clicks_menu_option(String menuOption) {
        homePage.navigateToMenuOption(menuOption);
        BrowserUtils.waitFor(2);
    }

    @Then("new browser window appears with title {string}")
    public void new_browser_window_appears_with_title(String expectedTitle) {
        BrowserUtils.switchToWindow(expectedTitle);
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @Then("user selects {string} support option")
    public void user_selects_support_option(String supportOption) {
        SupportPage supportPage = new SupportPage();
        supportPage.navigateToSupportOption(supportOption);
    }
    @Then("filter by name option is enabled")
    public void filter_by_name_option_is_enabled() {
        ProductHelpPage productHelpPage = new ProductHelpPage();
        boolean enabled = productHelpPage.filterByNameInput.isEnabled();
        Assert.assertTrue(enabled);
    }



}
