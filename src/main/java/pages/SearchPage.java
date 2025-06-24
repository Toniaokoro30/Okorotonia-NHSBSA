package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseUtill;

public class SearchPage extends BaseUtill {
	 private BaseUtill base;
	    public SearchPage(BaseUtill base) {
	    	this.base = base;
	    }
	 

	
	    

	   
	   
	    By keywordInput = By.id("keyword");
	    By locationInput = By.id("location");
	    By searchButton = By.id("search");
	    
//	    public SearchPage(WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	    }

	    public void enterKeyword(String keyword) {
	        base.driver.findElement(keywordInput).sendKeys(keyword);
	    }

	    public void enterLocation(String location) {
	        base.driver.findElement(locationInput).sendKeys(location);
	    }

	    public void clickSearch() {
	        base.driver.findElement(searchButton).click();
	    }
	    
	    public void sortByDatePosted() {
	        WebElement sortDropdown = base.driver.findElement(By.id("sort"));
	        Select dropdown = new Select(sortDropdown);
	        dropdown.selectByValue("publicationDateDesc");
	    }
	    
	    public boolean isSortedByNewestDatePosted() {
	        List<WebElement> dateElements =  base.driver.findElements(By.cssSelector("li[data-test='search-result-publicationDate'] strong"));

	        List<LocalDate> postedDates = new ArrayList<>();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);

	        for (WebElement dateElement : dateElements) {
	            String dateText = dateElement.getText().trim();  // e.g., "12 June 2025"
	            LocalDate date = LocalDate.parse(dateText, formatter);
	            postedDates.add(date);
	        }

	        // Check if list is sorted in descending order
	        List<LocalDate> sortedDates = new ArrayList<>(postedDates);
	        sortedDates.sort(Collections.reverseOrder());

	        return postedDates.equals(sortedDates);
	    }
	}


