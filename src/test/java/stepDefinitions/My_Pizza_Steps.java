package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.sql.Timestamp;


public class My_Pizza_Steps {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }

    }

    @After
    public void tearDown() {

        driver.quit();

    }


    @Given("I access the My Pizza Page")
    public void i_access_the_my_pizza_page() throws InterruptedException {
        driver.get("https://c0.avaamo.com/web_channels/cce5f713-c1f4-4666-8976-b091299cda81/demo.html?");
        Thread.sleep(4000) ;

    }

    @When("I click on Bot icon")
    public void i_click_on_bot_icon() throws InterruptedException {
        driver.findElement(By.cssSelector("[class=\"avm-bot-avatar\"]")).click();
        Thread.sleep(2000);


    }

    @And("Bot window should open")
    public void bot_window_should_open() throws InterruptedException {
        String textMessage = driver.findElement(By.cssSelector("[class=\"welcome-message\"]")).getText();
        Assert.assertEquals(textMessage, "Welcome to Pizza Shoppe");
        Thread.sleep(2000);
    }

    @And("I click on Get Started Button")
    public void i_click_on_get_started_button() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class =\"get-started-link\"]")).click();
        Thread.sleep(2000);

    }

    @And("I click on enter First Name {word}")
    public void i_click_on_enter_first_name(String username) {
        driver.switchTo().frame("avaamoIframe");
        driver.findElement(By.id("first_name")).sendKeys(username);
    }

    @And("I click on enter Email {}")
    public void i_click_on_enter_email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }




    @And("I click on Next Button")
    public void i_click_on_next_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[class=\"send btn\"]")).click();
        Thread.sleep(5000);

    }

    @Then("Enter text in commentBox {}")
    public void enter_text_in_comment_box_validation_pass(String textinput) throws InterruptedException {
        driver.findElement(By.id("queryTextbox")).sendKeys(textinput, Keys.ENTER);
        Thread.sleep(4000);
    }


    @And("I want to Order Pizza")
    public void i_want_to_order_pizza() throws InterruptedException {
        driver.findElement(By.id("queryTextbox")).sendKeys("I want to Order Pizza", Keys.ENTER);
        Thread.sleep(4000);
    }



    @And("I select Veg Pizza")
    public void i_select_veg_pizza() throws InterruptedException {
        driver.findElement((By.cssSelector("[aria-label=\"veg\"]"))).click();
        Thread.sleep(2000);
    }

    @And("I select Cheese Toppings")
    public void i_select_cheese_toppings() throws InterruptedException {
        driver.findElement((By.cssSelector("[value=\"cheese_id\"]"))).click();
        Thread.sleep(2000);
    }

    @And("I select Tomato Toppings")
    public void i_select_tomato_toppings() throws InterruptedException {
        driver.findElement((By.cssSelector("[value=\"tomato_id\"]"))).click();
        Thread.sleep(6000);

    }
    @And("I click on Submit Toppings Button")
    public void i_click_on_submit_toppings_button() throws InterruptedException {
       driver.findElement((By.cssSelector("[class=\"btn default_card_submit\"]"))).click();
        Thread.sleep(6000);
    }
    @And("I click on Thick Crust")
    public void i_click_on_thick_crust() throws InterruptedException {
        driver.findElement((By.cssSelector("[title=\"Thick Crust\"]"))).click();
        Thread.sleep(6000);
    }
    @And("I select Large Pizza")
    public void i_select_large_pizza() throws InterruptedException {
        driver.findElement((By.cssSelector(("[aria-label=\"Large\"]")))).click();
        Thread.sleep(6000);

    }
    @And("I confirm Order by clicking on Yes Button")
    public void i_confirm_order_by_clicking_on_yes_button() throws InterruptedException {
        driver.findElement((By.cssSelector("[aria-label=\"Yes\"]"))).click();
        Thread.sleep(10000);
    }
    @Then("I submit positive feedback")
    public void i_submit_positive_feedback() throws InterruptedException {
        driver.findElement((By.cssSelector("[class=\"thumbs-up locale-trans\"]"))).click();
        Thread.sleep(3000);
    }

}
