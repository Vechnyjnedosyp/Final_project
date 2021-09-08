package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdminPage extends PageMainLocators {

    public String systemUsersTitle = "System Users";
    public String jobTitle = "Job Titles";
    SelenideElement jobLink = $("#menu_admin_Job");
    SelenideElement jobTitleLink = $("#menu_admin_viewJobTitleList");
    SelenideElement resultTable = $("#resultTable");
    String radioButton = "input[type= 'checkbox']";

    @Step("Go to the page 'Job Titles'")
    public AdminPage getJobTitleList() {
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(adminLink).moveToElement(jobLink).click(jobTitleLink);
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        return this;
    }

    @Step("Select one job")
    public AdminPage deleteJob() {
        ElementsCollection jobsCollection = resultTable.$$("tr");
        jobsCollection.get(1).$(By.cssSelector(radioButton)).click();
        return this;
    }

}
