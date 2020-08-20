package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OrderFormLocators extends BaseClass {


    public OrderFormLocators (){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//a[text()='Order']")
    private WebElement orderButton;

    @FindBy (xpath = "//a[text()='View all orders']")
    private WebElement viewAllOrdersButton;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerName;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zip;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumber;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expireDate;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement process;

    @FindAll({
            @FindBy (css = "#ctl00_MainContent_orderGrid>tbody>tr>:nth-child(2)")
    })
    private List<WebElement> orderList;

    @FindAll({
            @FindBy(css = "select>option")
    })
    private List<WebElement> productList;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement cardList;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_rev1")
    private WebElement invalidZip;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_RegularExpressionValidator2")
    private WebElement invalidCardNumber;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_RegularExpressionValidator3")
    private WebElement invalidDate;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_RegularExpressionValidator1")
    private WebElement warningQuantity;

    @FindBy (css = "#ctl00_MainContent_fmwOrder_CustomValidator1")
    private WebElement warningCardType;





    WebElement myElement;

    public void findElementAndClick (String elementName){

        switch (elementName){

            case "orderButton":
                myElement = orderButton;
                break;

            case "viewAllOrdersButton":
                myElement = viewAllOrdersButton;
                break;

             case "process":
                myElement = process;
                break;



        }

        clickFunction(myElement);

    }

    public void findElementAndKeys (String elementName, String value){


        switch (elementName){

            case "quantity":
                myElement = quantity;
                break;

            case "customerName":
                myElement = customerName;
                break;

            case "street":
                myElement = street;
                break;

            case "city":
                myElement = city;
                break;

            case "state":
                myElement = state;
                break;

            case "zip":
                myElement = zip;
                break;

            case "cardNumber":
                myElement = cardNumber;
                break;

            case "expireDate":
                myElement = expireDate;
                break;

        }

       sendKeysFunction(myElement,value);


    }


    public void VerifyItemsNumberIncreaseOntheOrderList () {

        Assert.assertEquals(orderList.size(),orderList.size());

    }

    public void selectProduct (String option){

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")).click();

        for (WebElement element : productList) {

            if (element.getText().equalsIgnoreCase(option)) {
                clickFunction(element);
            }


        }

    }

    public void selectCard (String option) {

        clickFunction(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_"+option)));


        }

    public void VerifyerrorMessage (String elementName){

        switch (elementName){

            case "invalidZip":
                myElement = invalidZip;
                break;
            case "invalidCardNumber":
                myElement = invalidCardNumber;
                break;
            case "invalidDate":
                myElement = invalidDate;
                break;
            case "warningQuantity":
                myElement = warningQuantity;
                break;
            case "warningCardType":
                myElement = warningCardType;
                break;
        }

        if (myElement == warningQuantity){
            ElementContainsText(myElement,"zero");
        }else if (myElement == warningCardType){
            ElementContainsText(myElement,"Select");
        }else

       ElementContainsText(myElement,"Invalid");
    }


    }

