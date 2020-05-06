package finalExcercise1.Cucumber.Features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class MyStepdefs {
    private WebDriver driver;


        @Given("open browser with https://prod-kurs.coderslab.pl page open")
        public void prepareDriver() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver");
            // Uruchom nowy egzemplarz przeglądarki Chrome
            driver = new ChromeDriver();

            // Zmaksymalizuj okno przeglądarki
            driver.manage().window().maximize();
            // Przejdź do Google
            driver.get("https://prod-kurs.coderslab.pl/index.php");
            Thread.sleep(3000);
        }

        @When("user clicks SIGN IN button")
        public void clickSignInButton() throws InterruptedException {
            WebElement signInButton = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span"));
            signInButton.click();
            Thread.sleep(2000);
        }

        @And("^user is logged as (.*)$")
        public void enterLogin(String username) throws InterruptedException  {
            WebElement emailWindow = driver.findElement(By.cssSelector("div.form-group:nth-child(2) > div:nth-child(2) > input:nth-child(1)"));
            emailWindow.sendKeys(username);

        }
    @And ("^with password (.*)$")
    public void enterPassword(String password) throws InterruptedException {
        WebElement passwordWindow = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[2]/div[1]/div/input"));
        passwordWindow.sendKeys(password);
        WebElement signInButton2 = driver.findElement(By.xpath("//*[@id='submit-login']"));
        signInButton2.click();
        Thread.sleep(2000);
    }

        @And("chooses addresses section")
        public void goIntoAddressSection() {
            WebElement addressSectionEntrance = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]/span"));
            addressSectionEntrance.click();

        }
        @And("clicks CREATE NEW ADDRESS button")
        public void clickCreateNewAddressButton() {
            WebElement createNewAddressButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a/span"));
            createNewAddressButton.click();
        }

        @And("^enters new alias (.*)$")
        public void enterNewAlias(String alias)  {
            WebElement enterNewAliasSpace = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[1]/div[1]/input"));
            enterNewAliasSpace.sendKeys(alias);
        }

        @And("^enters new address (.*)$")
        public void enterNewAddress(String address)  {
            WebElement enterNewAddressSpace = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[6]/div[1]/input"));
            enterNewAddressSpace.sendKeys(address);
        }

        @And("^enters new city (.*)$")
        public void enterNewCity(String city)  {
            WebElement enterNewCitySpace = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[8]/div[1]/input"));
            enterNewCitySpace.sendKeys(city);
        }

        @And("^enters new zip/postal code (.*)$")
        public void enterPostalCode(String postal)  {
            WebElement enterPostalSpace = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[9]/div[1]/input"));
            enterPostalSpace.sendKeys(postal);
                    }

        @And("^enters new phone (.*)$")
        public void enterPhone (String phone)  {
            WebElement enterPhoneSpace = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[11]/div[1]/input"));
            enterPhoneSpace.sendKeys(phone);

        }

        @And("clicks SAVE button")
        public void saveNewAddress() throws InterruptedException {
            WebElement saveNewAddressButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
            saveNewAddressButton.click();
            Thread.sleep(3000);
        }


        @Then("checks if entered data is appropriate")
        public void checkIfDataIsCorrect() {
            WebElement aliasInAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]/h4"));
            String aliasText = aliasInAddress.getText();
            Assert.assertEquals("Zuzek", aliasText);
        }

        @And("close browser")
        public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}

