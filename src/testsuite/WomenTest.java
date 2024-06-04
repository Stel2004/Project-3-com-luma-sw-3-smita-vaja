package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 4. Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in
 * Low to High
 */
public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter(){
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));

        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));

        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name ");

        //Verify the products name display in alphabetical order
        List<WebElement> productElements = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement element : productElements) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));

        //Click on Jackets
        clickOnElement(By.id("ui-id-11"));

        //Select Short By Filter "Price"
        selectByValueFromDropDown(By.id("sorter"), "price");

        //Verify the products price display in Low to High
        List<WebElement> element1 = driver.findElements(By.xpath("//span[@data-price-type='finalPrice'] "));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }


    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

}
