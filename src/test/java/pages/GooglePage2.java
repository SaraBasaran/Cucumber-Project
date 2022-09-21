package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class GooglePage2 {
        public GooglePage2(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(name="q")
        public WebElement searchBox;
    }


