package stepDefinitions;

import Base.BaseStepDefinitions;
import Ellithium.Utilities.ExcelHelper;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchStepDefinition extends BaseStepDefinitions {

    SearchPage searchPage;

    @Given("the user in the search page")
    public void the_user_in_the_search_page() {
        searchPage=new SearchPage(driver);
    }
    @And("the user types Monitor in the search bar")
    public void the_user_types_monitor_in_the_search_bar() {
            searchPage.searchForItem("Monitor");
    }
    @When("the user clicks the search button")
    public void the_user_clicks_the_search_button() {
        searchPage.clickSearchButton();
    }
    @Then("relevant items is returned")
    public void relevant_items_is_returned() {
        List<String>itemNames=searchPage.getResultsNames();
        List<String>itemPrices=searchPage.getResultsPrices();
        List<Map<String, String>> data=new ArrayList<>();
        for(int i=0; i<5; i++ ) {
            Map<String, String> h = new HashMap<String, String>();
            h.put("Item Name",itemNames.get(i));
            h.put("ItemPrice",itemPrices.get(i));
            data.add(h);
        }
        System.out.println(data);
        ExcelHelper.setExcelData("src/test/resources/TestData/Scope Assessment1","ItemsAndPrices", data);
    }
}
