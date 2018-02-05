package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {
        System.out.println("Opening the browser: Chrome");
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        base.Driver= new ChromeDriver();
        base.Driver.navigate().to("https://www.phptravels.net/");
    }

    @After
    public void TearDownTest(Scenario scenario)
    {
        System.out.println("Closing the browser");
    }
}
