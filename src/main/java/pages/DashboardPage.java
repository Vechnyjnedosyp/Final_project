package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DashboardPage extends PageMainLocators {

    public String title = "Dashboard";
    SelenideElement assignLeaveLink = $("#menu_leave_assignLeave");
    SelenideElement panelLink = $("#welcome");
    SelenideElement panelMenuSelect = $("#welcome-menu");
    SelenideElement logoutLink = $("#welcome-menu");
    SelenideElement dashboardBody = $("div[class= 'inner']");

    @Step("Go to the page 'Employee List'")
    public DashboardPage getEmployeeList() {
        PIMLink.click();
        return this;
    }

    @Step("Go to the page 'System Users'")
    public DashboardPage getSystemUsers() {
        adminLink.click();
        return this;
    }

    @Step("Go to the page 'Candidates'")
    public DashboardPage getCandidates() {
        candidatesLink.click();
        return this;
    }

    @Step("Go to the page 'Assign leave'")
    public DashboardPage getAssignLeave() {
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(leaveLink).click(assignLeaveLink);
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        return this;
    }

    @Step("Logout")
    public DashboardPage logout() {
        panelLink.click();
        panelMenuSelect.shouldBe(Condition.visible);
        logoutLink.click();
        return this;
    }

    @Step("Check the exist of elements")
    public DashboardPage checkElements() {
        ElementsCollection dashboard = dashboardBody.$$("div");
        for (SelenideElement selenideElement : dashboard) {
            selenideElement.shouldBe(Condition.exist); //exist // условия присутствия элемента
        }
        return this;
    }

}
