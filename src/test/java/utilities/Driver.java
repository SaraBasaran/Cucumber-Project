package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
public class Driver {
    //create a driver instance
    private static WebDriver driver;
    private static int timeout = 5;
    //What?=>It is just to create, initialize the driver instance.(Singleton driver)
    //Why?=>We don't want to create and initialize the driver when we don't need
    //We will create and initialize the driver when it is null
    //We can use Driver class with different browser(chrome,firefox,headless)
    private Driver() {
        //we don't want to create another abject. Singleton pattern
    }
    //to initialize the driver we create a static method
    public static WebDriver getDriver() {
        //create the driver if and only if it is null
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("ie".equals(browser)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("safari".equals(browser)) {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
            } else if ("chrome-headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver = null;//set it back to null to make sure driver is null
            // so I can initialize it again
            //This is important especially you do cross browser testing(testing with
            // multiple browser like chrome, firefox, ie etc.)
        }
    }
    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    //    Driver.waitANdSendText(Element , "TEXT");
    public static void waitAndSendText(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendTextWithDefaultTime(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }
    //Webdriver
    //ChromeDriver
    //Iedriver
    //FirefoxDriver
    public static void wait2(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //5 seconds
    public static void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                wait2(1);
            }
        }
    }
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }
    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param elements
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }
    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    //    Parameter1 : WebElement
//    Parameter2:  String
//    Driver.selectByVisibleText(dropdown element, "CHECKING-91303-116.98$")
    public static void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }
    //    Parameter1 : WebElement
//    Parameter2:  int
//    Driver.selectByIndex(dropdown element, 1)
    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }
    //    Parameter1 : WebElement
//    Parameter2:  String
//    Driver.selectByIndex(dropdown element, "91303")
    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: " + elementCount.size());
    }
    public static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitAndClickLocationText(WebElement element, String value) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + value + "']")).click();
    }
}

/*
- Tell me about yourself? -> MUST at least 1 minute
    -selenium, java, cucumber. Agile scrum team. We have 2 weeks of spring. Some of my responsibilities are smoke tesings, regression testing, integration tesiing.
    I have experience in API, Database tesitng, but In my current project, I do UI testing(IF COMPONY LOKKSING FOR API TESTING THEN I AM MAINLY DOIND API TESING).
    I am using cucumber-selenium as my automation framewrok, I use postman for manual api testing, I use rest library for my api automation testing, I also use JDBC for database automation testing.
    I am working on reserving car module in my cuurent project,...
    WHAT NOT TO SAY: age, marital status, kids,... persolan information,
    WHAT TO SAY : You skills
- Where are you working?
- How to rate yourself for java -> 3.5 - 4
- How do rate yourself for selenium -> enough experience
- Are you able to automate all of stories? -> cannot automate all
- What is your automation coverage -> more than 95 person
- What kind of testing are you doing ? -> Cucumber with API testing Cucumber
- How do you handle dropdown? -> Select object-> gave detail good.
- What kind of exceptions you are getting? -> No such element -> explained -> Stale element ->
- What is Page object model framework ? Why? -> Organized ?
- What could be the reasons for NoSuchElementException?
- Sysncronozition
- How do you handle sysncronization issue? -> thread.sleep | explicit wait
- What is singleton Driver
- Do you have any question for me? - WHat kind of project you are using? Am i going to join in a new team on an exuisting team? How is the compony culture? Are you providing KT sessions? WHAT NOT TO ASK : personal questions, money question,
+++++++++++++++++++++++++++++++++++++++++
-Can you introduce yourself? -English teacher-software interest- new information - 2 years of experience, testng, selenium, junit,
-Team structure? 3 testers 1 of them is lead 1 of them is manual tester. 4 devs. 1 of them if is lead. BA PO SM
-How many test cases do you right in a 2 week sprint? 500 test cases
-When do you start wrting test cases? ->
    -> 1.. Read the user story and AC. Do manual testing by following AC to understand the functionality. Then start writing the automation test script.
    -> 2. 4 user story you have. Write 5 test case for each story. Total 20 test case in a sprint. BUT IT DEPENDS.
-How many automation script do you write in a sprint. -> Around 20 on average
-How do you make sure you have enough test case ? - manual, scenarios, test script, tracibility matrics. positive, negative, boundry-edge cases
-How many locators? 8 locators
-How do you handle dynamic elements? -> I use dynamic xpath. It has start-with, ends-with, contains in the xpath
-What is dynamic element? -> chage the value of the attributes
- How do you get screenshot? -> reusable methods. getScreenShotAs method that comes from selenium
- How do you maintain your automation scripts? -> if any thing change. I go back to teh story and mody the existing code so it can cover teh new acceptance criteria.
- What is an iframe and how do you handle?. -> Iframe is used to add new elements such as maps, videos, pages,...We switch to ufrae when there is any iframe
- Any question for me? -
- How many test cases do you write each day. -> It depends on teh comlexity of the functionality, but on averate I wrte 3-4 automation test cases. My application is a little bit complex, so I usually write about 15 automation test case in a 2 week sprint using cucumber framewrok. OR I can write 8-10 manual test cases
- 4 story per week -> 12 points -> based on the number of available reusable test cases, i can write more test case or test cases. If there is no reusable automation test cases available then I spent more time on each test case. then it may take 1 day to complete 1 test case. If there are already reusable automation test cases, then I can write 3-4 automation test cases per day

#Scenario: Test Case = Test Scenario
#Each scenario has Gherkin keyword : Given, And, When, Then, But, *
#Given: should be used at the beginning as preconditions
#Then: should be used for verification steps
#When: should be used in the middle steps
#And: should be used in the middle steps
#I can use more than one Scenario in a feature file.

 */










