package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class PageMainLocators {

    SelenideElement adminLink = $("#menu_admin_viewAdminModule");
    SelenideElement PIMLink = $("#menu_pim_viewPimModule");
    SelenideElement candidatesLink = $("#menu_recruitment_viewRecruitmentModule");
    SelenideElement leaveLink = $("#menu_leave_viewLeaveModule");
    public SelenideElement tableTitle = $("div[class= 'head'] h1");
    SelenideElement saveButton = $("#btnSave");
    SelenideElement addButton = $("#btnAdd");
    SelenideElement deleteButton = $("#btnDelete");
    SelenideElement alertButton = $("#dialogDeleteBtn");
    public SelenideElement messageInfo = $("div[class= 'message success fadable']");
    public String saveText = "Successfully Saved";
    public String deleteText = "Successfully Deleted";

    @Step("Add new object")
    public void addNewObject() {
        addButton.click();
    }

    @Step("Click on save button")
    public Object saveObject() {
        saveButton.click();
        return this;
    }

    @Step("Click on delete button")
    public void clickDelete() {
        deleteButton.click();
        alertButton.click();
    }

    @Step("Пet equality")
    public void getAssertEquals(String expected, String current) {
        Assertions.assertEquals(expected, current,
                "Your operation was unsuccessful.");
    }

}
