package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.RandomValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class AddUserPage extends PageMainLocators {

    SelenideElement userRoleSelect = $("#systemUser_userType");
    SelenideElement employeeNameField = $("#systemUser_employeeName_empName");
    SelenideElement usernameField = $("#systemUser_userName");
    SelenideElement statusSelect = $("#systemUser_status");
    SelenideElement passwordField = $("#systemUser_password");
    SelenideElement confirmPasswordField = $("#systemUser_confirmPassword");
    SelenideElement validError = $("span[class= 'validation-error']");
    SelenideElement resultTable = $("div[class= 'ac_results']");
    SelenideElement statusPass = $("#systemUser_password_strength_meter");

    @Step("Fill information in fields")
    public AddUserPage fillFields() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/properties/newUser.properties"));
        RandomValue randomValue = new RandomValue();
        userRoleSelect.shouldBe(Condition.exist).selectOption(1);
        employeeNameField.shouldBe(Condition.enabled).sendKeys("a");
        ElementsCollection employees = resultTable.$$("li");
        employees.get(0).shouldBe(Condition.exist).click();
        usernameField.shouldBe(Condition.enabled).sendKeys(props.getProperty("newUser.usernameField")+ randomValue.generateString(2));
        SelenideElement s = validError.shouldBe(Condition.disappear);
        s.shouldHave(Condition.attribute("style", "display: none;"));
        statusSelect.shouldBe(Condition.exist).selectOption(0);
        String password = props.getProperty("newUser.passwordField");
        passwordField.shouldBe(Condition.enabled).sendKeys(password);
        confirmPasswordField.shouldBe(Condition.enabled).sendKeys(password);
        statusPass.shouldBe(Condition.appear);
        return this;
    }
}
