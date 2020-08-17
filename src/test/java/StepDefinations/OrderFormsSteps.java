package StepDefinations;

import PageObjectModel.BaseClass;
import PageObjectModel.OrderFormLocators;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class OrderFormsSteps extends BaseClass {

    OrderFormLocators orderFormLocators = new OrderFormLocators();

    @Then("^Navigate to Order page$")
    public void navigateToOrderPage() {

        orderFormLocators.findElementAndClick("orderButton");

    }

    @Then("^Fill the Quantity, Customer Name, Street, City, State, Zip, Card NUmber, and Exp Date$")
    public void fillTheQuantityCustomerNameStreetCityStateZipCardNUmberAndExpDate(DataTable inputData) {


        List<List<String>> AllElementsNameAndValue= inputData.asLists(String.class);


        for(int i =0 ; i <AllElementsNameAndValue.size() ; i++){


            orderFormLocators.findElementAndKeys(AllElementsNameAndValue.get(i).get(0) ,AllElementsNameAndValue.get(i).get(1));

        }
    }

    @Then("^Choose the product$")
    public void Choose_the_product(DataTable optionTable) {

        List<String> optionList = optionTable.asList(String.class);
        for (int i=0; i<optionList.size();i++){
            orderFormLocators.selectProduct(optionList.get(i));
        }

    }

    @Then("^Choose Type of Card and click on Process Button$")
    public void chooseTypeOfCardAndClickOnProcessButton() {

        orderFormLocators.selectCard("0");
        orderFormLocators.findElementAndClick("process");

    }

    @When("^Navigate to view all orders page$")
    public void navigateToViewAllOrdersPage() {

        orderFormLocators.findElementAndClick("viewAllOrdersButton");
        waiting(3000);

    }

    @Then("^Verify items count are increased$")
    public void verifyItemsCountAreIncreased() {
        orderFormLocators.VerifyItemsNumberIncreaseOntheOrderList();
    }
}
