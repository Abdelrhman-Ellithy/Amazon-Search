package Pages;

import Ellithium.Utilities.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private final String baseUrl="https://www.amazon.eg/-/en/";
    private final By searchField=By.id("twotabsearchtextbox");
    private final By itemTitle=By.cssSelector("span[class='a-size-base-plus a-color-base a-text-normal']");
    private final By itemPrice=By.className("a-price-whole");
    private final By searchBtn=By.id("nav-search-submit-button");
    public SearchPage(WebDriver driver){
        this.driver=driver;
        DriverActions.navigateToUrl(driver,baseUrl);
    }
    public void searchForItem(String item){
        DriverActions.sendData(driver, searchField, item, 4,300);
    }
    public void clickSearchButton(){
        DriverActions.clickOnElement(driver, searchBtn, 3,200);
    }
    public List<String> getResultsNames(){
        return DriverActions.getTextFromMultipleElements(driver,itemTitle,5,200 );
    }
    public List<String> getResultsPrices(){
        List<String>itemResultsAsString= DriverActions.getTextFromMultipleElements(driver,itemPrice,5,200 );
        return itemResultsAsString;
    }
}
