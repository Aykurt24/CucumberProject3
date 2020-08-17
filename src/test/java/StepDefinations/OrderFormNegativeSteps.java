package StepDefinations;

import PageObjectModel.BaseClass;
import PageObjectModel.OrderFormLocators;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OrderFormNegativeSteps extends BaseClass {

    OrderFormLocators orderFormLocators = new OrderFormLocators();
    WebDriver driver;

    @Then("^Verify the Error Message$")
    public void verifyTheErrorMessage(DataTable warningTable) {

        driver = Driver.getDriver();
        List<String> warningOrder = warningTable.asList(String.class);

        for (int i = 0; i < warningOrder.size(); i++) {

            if (i % 2 == 1) {
                Assert.assertTrue(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_RequiredFieldValidator" + warningOrder.get(i))).getText().contains("empty"));
                }
            }
//        System.out.println("#ctl00_MainContent_fmwOrder_RequiredFieldValidator"+warningOrder.get(i));
        }

    @Then("^Miss each part one by one \\(Customer Name, Street, City, State, Zip, Card NUmber, and Exp Date\\)$")
    public void missEachPartOneByOneCustomerNameStreetCityStateZipCardNUmberAndExpDate(DataTable inputData) {

        List<List<String>> AllElementsNameAndValue= inputData.asLists(String.class);


        for(int i =0 ; i <AllElementsNameAndValue.size() ; i++){


            orderFormLocators.findElementAndKeys(AllElementsNameAndValue.get(i).get(0) ,AllElementsNameAndValue.get(i).get(1));

        }
    }

    @Then("^Input invalid zipcode, date, card Number and verify warning message$")
    public void Input_invalid_zipcode_date_card_Number_and_verify_warning_message() {
        orderFormLocators.findElementAndKeys("zip","sadasd");
        orderFormLocators.findElementAndKeys("expireDate","090823");
        orderFormLocators.findElementAndKeys("cardNumber","adasdas");
        orderFormLocators.findElementAndClick("process");
        orderFormLocators.VerifyerrorMessage("invalidZip");
        orderFormLocators.VerifyerrorMessage("invalidDate");
        orderFormLocators.VerifyerrorMessage("invalidCardNumber");







    }

    @Then("^Clik on process Button$")
    public void clikOnProcessButton() {
        
        orderFormLocators.findElementAndClick("process");
        
    }

    @Then("^Verify error message for card type and quantity$")
    public void verifyErrorMessageForCardTypeAndQuantity() {
    }
}
