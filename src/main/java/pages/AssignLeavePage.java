package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AssignLeavePage extends PageMainLocators {

    public String title = "Assign Leave";
    SelenideElement assignNameField = $("#assignleave_txtEmployee_empName");
    SelenideElement leaveTypeSelect = $("#assignleave_txtLeaveType");
    SelenideElement leaveBalanceField = $("#assignleave_leaveBalance");
    SelenideElement fromField = $("#assignleave_txtFromDate");
    SelenideElement toField = $("#assignleave_txtToDate");
    SelenideElement commentField = $("#assignleave_txtComment");
    SelenideElement imgFromLink = $("img[class= 'ui-datepicker-trigger']");
    SelenideElement assignButton = $("#assignBtn");
    SelenideElement resultTable = $("div[class= 'ac_results']");
    SelenideElement confirmOkButton = $("#confirmOkButton");
    public String successText = "Successfully Assigned";

    @Step("Fill information in fields")
    public AssignLeavePage fillFields() throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();  // Текущая дата
        String formattedDate = df.format(currentDate);
        assignNameField.shouldBe(Condition.exist).sendKeys("d");
        ElementsCollection employeesName = resultTable.$$("li");
        ((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].click();", employeesName.first());
        leaveTypeSelect.shouldBe(Condition.enabled).selectOption(10);
        fromField.clear();
        fromField.shouldBe(Condition.exist).sendKeys(formattedDate);
        fromField.sendKeys(Keys.ENTER);
        toField.clear();
        toField.shouldBe(Condition.exist).sendKeys(formattedDate);
        toField.sendKeys(Keys.ENTER);
        commentField.shouldBe(Condition.exist).sendKeys("Test");
        assignButton.shouldBe(Condition.visible).click();
        confirmOkButton.shouldBe(Condition.visible).click();
        return this;
    }
}
