package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CustomerLoginPage {

    public CustomerLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement loginButton;

    @FindBy (xpath= "//input[@name='email']")

    public WebElement customer_email;

    @FindBy(xpath ="//input[@name='password']")
    public WebElement customer_pwd;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement continueReservationText;







}

