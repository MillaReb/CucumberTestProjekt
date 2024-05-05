package stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepDefs {
    WebDriver driver;
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String dob) {
        WebElement dobField = driver.findElement(By.id("dp"));
        dobField.sendKeys(dob);
    }

    @When("I have entered first name {string}")
    public void iHaveEnteredFirstName(String firstName) {
        WebElement firstNameField = driver.findElement(By.id("member_firstname"));
        firstNameField.sendKeys(firstName);
    }

    @When("I have entered last name {string}")
    public void iHaveEnteredLastName(String lastName) {

        WebElement lastNameField = driver.findElement(By.id("member_lastname"));
        lastNameField.sendKeys(lastName);
    }

    @When("I have entered my email {string}")
    public void iHaveEnteredMyEmail(String email) {
        WebElement emailField = driver.findElement(By.id("member_emailaddress"));
        emailField.sendKeys(email);
    }

    @When("I have repeated my email {string}")
    public void iHaveRepeatedMyEmail(String repeatEmail) {
        WebElement confirmEmailField = driver.findElement(By.id("member_confirmemailaddress"));
        confirmEmailField.sendKeys(repeatEmail);
    }

    @When("I have entered my pasword {string}")
    public void iHaveEnteredMyPasword(String password) {
        WebElement passwordField = driver.findElement(By.id("signupunlicenced_password"));
        passwordField.sendKeys(password);
    }

    @When("I have repeated my pasword {string}")
    public void iHaveRepeatedMyPasword(String repeatPassword) {
        WebElement confirmPasswordField = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        confirmPasswordField.sendKeys(repeatPassword);
    }

    @When("I have accepted the terms and conditions")
    public void iHaveAcceptedTheTermsAndConditions() {
        WebElement termsCheckbox = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label"));
        termsCheckbox.click();
    }

    @When("I have klicked over {string}")
    public void iHaveKlickedOver(String age) {
        WebElement ageCheckbox = driver.findElement(By.cssSelector("#signup_form > div > div > div > div > div > div.form-body > div:nth-child(26) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label > span.box"));
        ageCheckbox.sendKeys(age);
    }

    @When("I have klicked code of ethics")
    public void iHaveKlickedCodeOfEthics() {
        WebElement ethicsCheckbox = driver.findElement(By.cssSelector("#signup_form > div > div > div > div > div > div.form-body > div:nth-child(26) > div > div:nth-child(8) > label > span.box"));
        ethicsCheckbox.click();
    }

    @When("Press submmit button")
    public void pressSubmmitButton() {
        WebElement submitButton = driver.findElement(By.name("join"));
        submitButton.click();
    }

      @Then("Verify the {string} on the webside")
    public void verifyTheOnTheWebside(String expectedText) {
        WebElement actualTextElement;
        
        switch (expectedText) {
            case "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND":
                actualTextElement = driver.findElement(By.cssSelector("#class=bold  gray  text-center  margin-bottom-40"));
                break;
            case "Last Name is required":
                actualTextElement = driver.findElement(By.cssSelector("#member_lastname")); 
                break;
            case "Incorrect Password":
                actualTextElement = driver.findElement(By.cssSelector("#type=password")); 
                break;
            case "You must confirm that you have read and accepted our Terms and Conditions":
                actualTextElement = driver.findElement(By.cssSelector("#for=sign_up_25"));
                break;
            default:
                throw new IllegalArgumentException("Unknown expected text: " + expectedText);
        }
        
        String actualText = actualTextElement.getText();  
        
        if (!expectedText.equals(actualText)) {
            System.out.println("Förväntad text: " + expectedText); 
            System.out.println("Faktisk text: " + actualText);
        }

        //assert-fel om texten inte stämmer
        Assert.assertEquals(expectedText, actualText);
        
        driver.quit();

    }

}
