package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    //public static WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
       // driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       // Thread.sleep(2000);
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() throws InterruptedException {
      //  WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
       // usernameTextField.sendKeys("admin");
      //  LoginPage login = new LoginPage();
       sendText(login.usernameTextField, ConfigReader.getPropertyValue("username"));

      //  WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
      //  passwordTextField.sendKeys("Hum@nhrm123");
        sendText(login.passwordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
       // WebElement loginButton = driver.findElement(By.id("btnLogin"));
      //  loginButton.click();
      //  Thread.sleep(2000);
       // LoginPage login = new LoginPage();
        click(login.loginButton);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        System.out.println("Test passed");
       // closeBrowser();
    }

    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
     //   WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        // usernameTextField.sendKeys("admin");
     //   LoginPage login = new LoginPage();
        sendText(login.usernameTextField, "admin");

      //  WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        //  passwordTextField.sendKeys("Hum@nhrm123");
        sendText(login.passwordTextField, "Hum@nhrm123");

    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        System.out.println("Test passed");
       // closeBrowser();
    }

    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
      //  WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        // usernameTextField.sendKeys("admin");
     //   LoginPage login = new LoginPage();
        sendText(login.usernameTextField, "admi");

    //    WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        //  passwordTextField.sendKeys("Hum@nhrm123");
        sendText(login.passwordTextField, "Hum");
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        System.out.println("Test failed");
       // closeBrowser();
    }

    @When("user enters different {string} and {string} and verify the {string}")
    public void user_enters_different_and_and_verify_the(String uname, String pwd, String error) {
        sendText(login.usernameTextField, uname);
        sendText(login.passwordTextField, pwd);
        click(login.loginButton);

        String errorActual = login.errorMessage.getText();
        Assert.assertEquals(errorActual, error);
    }

}
