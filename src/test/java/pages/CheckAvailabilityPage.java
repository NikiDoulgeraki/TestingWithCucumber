package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckAvailabilityPage {

    public CheckAvailabilityPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, id = "txtsearch")
    public WebElement txtLocation;

    @FindBy(how = How.NAME, using = "CheckIn")
    public WebElement txtCheckIn;

    @FindBy(how = How.NAME, using = "CheckOut")
    public WebElement txtCheckOut;

    @FindBy(how = How.NAME, using = "NrAdults")
    public WebElement txtnrAdults;

    @FindBy(how = How.NAME, using = "Search")
    public WebElement btnSearch;


    //Page Navigation Concept
    public void Search(String location, String checkin, String checkout, String nrAdults)
    {
        txtLocation.sendKeys(location);
        txtCheckIn.sendKeys(checkin);
        txtCheckOut.sendKeys(checkout);
        txtnrAdults.sendKeys(nrAdults);
    }

    public void ClickSearch()
    {
        btnSearch.submit();
    }
}
