package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebOrderListLocators extends BaseClass {

    public WebOrderListLocators() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll({
            @FindBy(css ="#ctl00_MainContent_orderGrid>:first-child>tr>td:nth-of-type(2)" )
    }) private List<WebElement> OrderList;

    @FindBy (id = "ctl00_MainContent_btnCheckAll")
    private WebElement CheckAllItemsButton;

    @FindBy (id = "ctl00_MainContent_btnDelete")
    private WebElement DeleteItemButton;

      WebElement myElement;
    public void FindElementAndClick (String elementName){

        switch (elementName){

            case "CheckAllItemsButton":
                 myElement = CheckAllItemsButton;
                 break;
            case "DeleteItemButton":
                 myElement = DeleteItemButton;
                 break;
        }

        clickFunction(myElement);

    }

    public void VerifyNumberOfItem (int ExpectedNumberOfItem){

        Assert.assertEquals(OrderList.size(),ExpectedNumberOfItem);

    }

    }

