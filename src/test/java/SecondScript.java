import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondScript {

    public static String checkName;
    public static String checkPrice;
    public static String checkQuantity;
    public static String forSubstring;

    @Test(priority = 2)
    public static void main(String args[])throws NullPointerException{

        TestNG2.driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/ru/");
        verificationDisplayingNewProduct();
        checkingNameOfProduct();
        checkingPriceOfNewProduct();
        checkingQuantityOfNewProduct();
        TestNG2.driver.quit();

    }

    public static void verificationDisplayingNewProduct(){
        TestNG2.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > section > a")));
        WebElement allProducts =  TestNG2.driver.findElement(By.cssSelector("#content > section > a"));
        allProducts.click();
        TestNG2.wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(TestNG2.nameOfNewProduct)));
        WebElement addedProduct = TestNG2.driver.findElement(By.linkText(TestNG2.nameOfNewProduct));
        Assert.assertTrue(addedProduct.isDisplayed());
        addedProduct.click();
    }

    public static void checkingNameOfProduct(){
        TestNG2.wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("#wrapper > div > nav > ol > li:nth-child(2) > a > span")));
        WebElement addedNameOfNewProduct = TestNG2.driver.findElement(By
                .cssSelector("#wrapper > div > nav > ol > li:nth-child(2) > a > span"));
        checkName = addedNameOfNewProduct.getText();
        System.out.print(checkName);
        Assert.assertEquals(TestNG2.nameOfNewProduct,checkName);
    }

    public static void checkingPriceOfNewProduct(){
        TestNG2.wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[@itemprop='price']")));
        WebElement priceOfAddedProduct = TestNG2.driver.findElement(By
                .xpath("//span[@itemprop='price']"));
        checkPrice = priceOfAddedProduct.getAttribute("content");
        Assert.assertEquals(TestNG2.randomPrice,checkPrice);
    }

    public static void checkingQuantityOfNewProduct(){
        TestNG2.wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id=\"product-details\"]/div[1]/span")));
        WebElement quantityAddedProduct = TestNG2.driver.findElement(By
                .xpath("//*[@id=\"product-details\"]/div[1]/span"));
        forSubstring = quantityAddedProduct.getText();
        checkQuantity = forSubstring.substring(0, forSubstring.length()-6);
        Assert.assertEquals(TestNG2.randomQuantity,checkQuantity);
    }
}
