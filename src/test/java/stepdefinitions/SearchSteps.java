package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SearchPage;
import utility.BaseUtill;

public class SearchSteps extends BaseUtill {
	  
	    private BaseUtill base;
	    public SearchSteps(BaseUtill base) {
	    	this.base = base;
	    }
	    SearchPage searchPage;

	    @Before
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        base.driver = new ChromeDriver();
	        base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        base.driver.get("https://www.jobs.nhs.uk/candidate/search");
	        searchPage = new SearchPage(base);
	    }
	    
	    @Before
	    public void setup1() {
	        WebDriverManager.edgedriver().setup();
	        base.driver = new EdgeDriver();
	        base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        base.driver.get("https://www.jobs.nhs.uk/candidate/search");
	        searchPage = new SearchPage(base);
	    }

	    @Given("I am on the NHS Jobs Search page")
	    public void i_am_on_search_page() {
	        Assert.assertTrue(base.driver.getTitle().contains("Search"));
	    }

	    @When("I enter valid preferences in the search form")
	    public void enter_preferences() {
	        searchPage.enterKeyword("Analyst");
	        searchPage.enterLocation("London");
	    }

	    @When("I click the search button")
	    public void click_search() {
	        searchPage.clickSearch();
	    }

	    @Then("I should see a list of jobs matching my preferences")
	    public void verify_results() {
	        List<WebElement> results = base.driver.findElements(By.cssSelector("ul[class='nhsuk-list search-results'] > li"));
	        Assert.assertTrue(results.size() > 0);
	    }

	    @Then("the results should be sorted by newest date posted")
	    	public void sort_by_newest() {
	    	    searchPage.sortByDatePosted();
	    	}
	    public void verify_sorted_by_date() {
	        boolean isSorted = searchPage.isSortedByNewestDatePosted();
	        Assert.assertTrue("Results are not sorted by newest date posted", isSorted);
	    }
	    

	    @After
	    public void tearDown() {
	        base.driver.quit();
	    }
	}


