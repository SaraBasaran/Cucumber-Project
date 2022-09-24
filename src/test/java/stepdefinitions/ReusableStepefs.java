package stepdefinitions;

import io.cucumber.java.en.Then;

public class ReusableStepefs {

    @Then("capture the screenshot")
    public void capture_the_screenshot() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

//    DataTables are user to pass test data
//    We especially use DataTables for passing multiple data
//    DataTables are similar to Scenario Outline
//    Difference between DataTables and Scenario Outline?
//    In DataTables No Examples keyword
//    DataTables can be use in ANY STEP to provide data, but Examples keyword can ONLY be used at the end of the scenario to provide data
//    In DataTables, use Scenario:
//    In Scenario Outline: use Scenario Outline and Examples
//    DataTables returns DataTables object in the method, so we have to use Collections to use them in the step definitions
//    Scenario Outline returns a string in the method, so it is easier to get and use.
//    DataTables are not as popular as Scenario Outline.
///*
    /*
    What is collections in JAVA? -> list, set, queue
How did you use collections in your framework? -> I use collections when especially I need to store multiple test data . I use Collections when I try to get data form Excel, or DataTables. For example, I store the multiple login credentials in my excel sheet, and I use ExcelUtil class to get the data as a List. I actually have ExcelUtil class that has Java Codes to get the data from an excel sheet. And in that ExcelUtil we use collection, I can get the list of each column name, or I can get the list of data in different form.
I also use collections when I expect multiple elements. For example findElements() method returns a List of WebElement- List<WebElement>
getWindowHandles returns set of string- Set<String>
When I use Data Table in my cucumber framework, I use collections
I can store the data that comes from DataTables as List<Map<String,String>>
I can also store the data that comes from DataTables as List<List<String>> or Just List<String>
I have Utils classes. In the util classes I used collection a lot. For example, I have Excel Util class
When I get the column names of an excel sheet, I store column names in List<String>
When I the data list from excel, I put data list in List<Map<String, String>>
     */

}
