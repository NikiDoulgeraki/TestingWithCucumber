package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CheckIn_Steps extends BaseUtil {

    private BaseUtil base;
    WebElement element;

    public CheckIn_Steps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the website$")
    public void iNavigateToTheWebsite()  {
        System.out.println("Navigate to the website");
    }


    @And("^I click on location menu and enter \"([^\"]*)\"$")
    public void iClickOnLocationMenu(String Location) {
        //Location
        System.out.println("Clicking on location");
        element = base.Driver.findElement(By.id("txtsearch"));
        String js = "arguments[0].type='visible';";
        ((JavascriptExecutor) base.Driver).executeScript(js, element);
        element.sendKeys("Athens, Greece");
        System.out.println(element.getText());
    }

    @And("^I click on Check In and set date \"([^\"]*)\"$")
    public void iClickOnCheckInAndSetDate(String checkin) throws Throwable {
        //CheckIn Element
        System.out.println("Setting Check In date");
        element=base.Driver.findElement(By.xpath("//*[@id=\"dpd1\"]/input"));
        element.clear();
        element.sendKeys("3/11/2018");
        element = base.Driver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr[1]/td[7]"));
        element.click();
    }


    @And("^I click on Check Out and set date \"([^\"]*)\"$")
    public void iClickOnCheckOutAndSetDate(String checkout) throws Throwable {
        //CheckOut Element
        System.out.println("Setting Check Out date");
        element=base.Driver.findElement(By.xpath("//*[@id=\"dpd2\"]/input"));
        element.clear();
        element.sendKeys("10/11/2018");

    }

    @And("^I click on Adults and set \"([^\"]*)\"$")
    public void iClickOnAdultsAndSet(String adults) throws Throwable {
        //Set Adults Element
        System.out.println("Setting Number of Adults");
        Select elm = new Select(base.Driver.findElement(By.id("adults")));
        elm.selectByValue("1");
    }

    @And("^I click search button$")
    public void iClickSearchButton() {
        //Clicking Search Button
        System.out.println("Clicking Search Button");
        element=base.Driver.findElement(By.xpath("//*[@id=\"HOTELS\"]/form/div[3]/div[3]/button"));
        Actions actions = new Actions(base.Driver);
        actions.moveToElement(element).click().perform();
    }

    @Then("^I should see the page$")
    public void iShouldSeeThePage() {
        System.out.println("We should see page");
        org.junit.Assert.assertEquals("It's not displayed", base.Driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/div/div")).isDisplayed(), true);
    }
}
