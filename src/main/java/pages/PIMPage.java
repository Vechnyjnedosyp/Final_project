package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.RandomValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class PIMPage extends PageMainLocators{

    SelenideElement firstNameField = $("#firstName");
    SelenideElement middleNameField = $("#middleName");
    SelenideElement lastNameField = $("#lastName");
    SelenideElement photofileField = $("#photofile");
    SelenideElement subUnitSelect = $("#empsearch_sub_unit");
    SelenideElement searchButton = $("#searchBtn");
    SelenideElement salesTable = $("#resultTable");
    SelenideElement personalNameField = $("#personal_txtEmpFirstName");
    SelenideElement personalLastNameField = $("#personal_txtEmpLastName");
    SelenideElement personalIDField = $("#personal_txtEmployeeId");
    SelenideElement personalDOBField = $("#personal_DOB");
    public String PIMTitle = "Employee Information";
    public String expectedValue = "Personal Details";

    @Step("Fill information in fields")
    public PIMPage fillFields() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/properties/newEmployee.properties"));
        RandomValue randomID = new RandomValue();
        firstNameField.sendKeys(props.getProperty("newEmployee.firstName")+ randomID.generateString(2));
        middleNameField.sendKeys(props.getProperty("newEmployee.middleName")+ randomID.generateString(2));
        lastNameField.sendKeys(props.getProperty("newEmployee.lastName")+ randomID.generateString(2));
        photofileField.sendKeys("D:\\AQA\\Final_project\\src\\main\\resources\\user.png");
        return this;
    }

    @Step("Create search")
    public PIMPage searchSales() {
        subUnitSelect.click();
        subUnitSelect.selectOption("  Sales");
        searchButton.click();
        return this;
    }

    @Step("Check the form")
    public PIMPage checkForm() {
        ElementsCollection salesList = salesTable.$$("tr");
        salesList.get(1).$(By.cssSelector("td[class= 'left']")).click();
        personalNameField.shouldNotBe(Condition.empty);
        personalLastNameField.shouldNotBe(Condition.empty);
        personalIDField.shouldNotBe(Condition.empty);
        personalDOBField.shouldNotBe(Condition.empty);
        return this;
    }
}
