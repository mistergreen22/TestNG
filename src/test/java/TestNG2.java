import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class TestNG2 {

    public static WebDriver driver = DriversManager.getConfiguredDriver();
    public static WebDriverWait wait = new WebDriverWait(driver,10);
    public static Actions actions = new Actions(driver);
    @NotNull
    public static String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
    public static Random random = new  Random();
    public static String nameOfNewProduct;
    public static String randomQuantity;
    public static String randomPrice;


    @Test(priority = 1)
    public static void main(String args[]) throws IOException, UnsupportedFlavorException {

        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        userLogin();
        navigatingToProducts();
        addNewProduct();
        generateNewName();
        generateRandomQuantity();
        generateRandomPrice();
        productActivation();
        popUpClose();
        saveUpdates();
        popUpClose();
        driver.quit();

    }


    public static void userLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("webinar.test@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        WebElement passInput = driver.findElement(By.id("passwd"));
        passInput.sendKeys("Xcg7299bnSmMuRLp9ITw");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submitLogin")));
        WebElement enterButton = driver.findElement(By.name("submitLogin"));
        enterButton.click();
    }


    public static void navigatingToProducts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subtab-AdminCatalog")));
        WebElement catalog = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        catalog.click();
    }


    public static void addNewProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-header-desc-configuration-add")));
        WebElement newProduct = driver.findElement(By.id("page-header-desc-configuration-add"));
        newProduct.click();
    }

    public static void generateNewName() throws IOException, UnsupportedFlavorException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_step1_name_1")));
        WebElement newName = driver.findElement(By.id("form_step1_name_1"));
        newName.sendKeys(generateRandomString(10));
        newName.sendKeys(Keys.CONTROL + "a");
        newName.sendKeys(Keys.CONTROL + "c");
        nameOfNewProduct = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);

    }

    public static void generateRandomQuantity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_step3")));
        WebElement quantityTab = driver.findElement(By.id("tab_step3"));
        quantityTab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_step3_qty_0")));
        WebElement quantity = driver.findElement(By.id("form_step3_qty_0"));
        quantity.sendKeys(Keys.BACK_SPACE);
        randomQuantity = String.valueOf((random.nextInt(100) + 1));
        quantity.sendKeys(randomQuantity);
    }

    public static void generateRandomPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_step2")));
        WebElement priceTab = driver.findElement(By.id("tab_step2"));
        priceTab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_step2_price")));
        WebElement newPrice = driver.findElement(By.id("form_step2_price"));
        newPrice.sendKeys(Keys.CONTROL + "a");
        newPrice.sendKeys(Keys.DELETE);
        randomPrice = String.valueOf(new BigDecimal((random.nextDouble() * 100) + 0.1)
                .setScale(1, RoundingMode.UP));
        newPrice.sendKeys(randomPrice);
    }

    public static void productActivation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("switch-input ")));
        WebElement switchOn = driver.findElement(By.className("switch-input "));
        switchOn.click();
    }

    public static void saveUpdates(){
        driver.navigate().refresh();
        actions.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0073')).perform();
    }

    public static void popUpClose(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-close")));
        WebElement popUpSaveButton = driver.findElement(By.className("growl-close"));
        popUpSaveButton.click();
    }

}
