package finalExercise2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;


public class test {
    protected WebDriver driver;
    private Object FileUtils;


    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //wejdź na URL
        driver.get("https://prod-kurs.coderslab.pl/index.php");
        Thread.sleep(3000);
    }

    @Test
    public void test() throws InterruptedException {
        // Znajdź przycisk Sign in i wciśnij go
        WebElement signInButton1 = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span"));
        // Wyczyść teskst zapisany w elemencie
        signInButton1.click();
        Thread.sleep(3000);

        //Wpisz adres email
        WebElement email = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[1]/div[1]/input"));
        email.sendKeys("joanna_musialkowska@tlen.pl");

        //Wpisz hasło
        WebElement password = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[2]/div[1]/div/input"));
        password.sendKeys("123CodersLab");

        //Wciśnij przycisk SignIn2
        WebElement signInButton2 = driver.findElement(By.xpath("//*[@id='submit-login']"));
        signInButton2.click();

        Thread.sleep(2000);

        //Wejdź do sekcji CLOTHES
        WebElement clothesButton = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a"));
        clothesButton.click();

        //wybierz szukany sweter
        WebElement sweaterButton = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/a/img"));
        sweaterButton.click();
        Thread.sleep(5000);

        //sprawdź, czy trwa promocja
        WebElement save20percent = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
        if (save20percent.isDisplayed()) {
            System.out.println("Promocja na sweterek trwa");

            //Wybierz rozmiar M
            WebElement sizeOption = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
            sizeOption.click();
            sizeOption.sendKeys("m");
            sizeOption.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            //Wybierz ilość
            WebElement quantityUpArrow = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]/i"));
            quantityUpArrow.click();
            quantityUpArrow.click();
            quantityUpArrow.click();
            quantityUpArrow.click();

            Thread.sleep(2000);
            //Dodaj do koszyka
            WebElement addToCartButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
            addToCartButton.click();

            Thread.sleep(2000);

            //Przejdź do sprawdzenia zamówienia
            WebElement proceedToCheckoutButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
            proceedToCheckoutButton.click();
            Thread.sleep(2000);

            //Przejdź do adresu
            WebElement proceedToCheckoutButton2 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
            proceedToCheckoutButton2.click();

            Thread.sleep(2000);

            //Przejdź dalej - przycisk CONTINUE
            WebElement continueButton = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[2]/button"));
            continueButton.click();

            Thread.sleep(2000);

            //Potwierdź odbiór osobisty
            WebElement continueButton2 = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button"));
            continueButton2.click();

            Thread.sleep(2000);

            //Wybierz metodę płatności PAY BY CHECK
            WebElement payByCheckButton = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/label/span"));
            payByCheckButton.click();

            Thread.sleep(2000);

            //Zaznacz checkbox ze zgodami
            WebElement iAgreeButton = driver.findElement(By.xpath("//*[@id='conditions_to_approve[terms-and-conditions]']"));
            iAgreeButton.click();

            Thread.sleep(1000);

            //Zamów z obowiązkiem zapłaty
            WebElement orderWithObligation = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
            orderWithObligation.click();

            Thread.sleep(3000);

            //zrób screena
            TakesScreenshot ts=(TakesScreenshot)driver;

            try {
                FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("src/main/resources/screens/screenshot.png"));
            } catch (WebDriverException e) {

            } catch (IOException e) {

            }


        } else {
            System.out.println("Nie ma już promki na sweterek. Koniec zakupów");
        }




    }


    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}