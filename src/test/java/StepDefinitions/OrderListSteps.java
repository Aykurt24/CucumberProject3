package StepDefinitions;

import PageObjectModel.BaseClass;
import PageObjectModel.WebOrderListLocators;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderListSteps extends BaseClass {

    WebOrderListLocators webOrders = new WebOrderListLocators();
    WebDriver driver;

    @Given("^Navigate to smartbearsoftware$")
    public void navigate_to_basqar() {

        /*
            Set property - open browser and navigate to website
         */

        driver = Driver.getDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples" +
                "%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        driver.manage().window().maximize();

    }

    @When("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button() {

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

      //  driver.switchTo().alert().accept();

    }

    @Then("^Verify Number Of Items On the Order List$")
    public void verifyNumberOfItemsOnTheOrderList() {

        webOrders.VerifyNumberOfItem(8);
    }

    @Then("^Delete All items on The Order List and Verify no Items on the order List$")
    public void deleteAllItemsOnTheOrderList() {

        webOrders.FindElementAndClick("CheckAllItemsButton");
        webOrders.FindElementAndClick("DeleteItemButton");
        webOrders.VerifyNumberOfItem(0);
    }
}

