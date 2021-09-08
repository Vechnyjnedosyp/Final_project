package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.RandomValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class AddCandidatePage extends PageMainLocators {

    SelenideElement firstNameField = $("#addCandidate_firstName");
    SelenideElement middleNameField = $("#addCandidate_middleName");
    SelenideElement lastNameField = $("#addCandidate_lastName");
    SelenideElement emailField = $("#addCandidate_email");
    SelenideElement contactNoField = $("#addCandidate_contactNo");
    SelenideElement vacancySelect = $("#addCandidate_vacancy");
    SelenideElement resumeField = $("#addCandidate_resume");
    SelenideElement keyWordField = $("#addCandidate_keyWords");
    SelenideElement commentField = $("#addCandidate_comment");
    SelenideElement dateField = $("#addCandidate_appliedDate");
    SelenideElement keepDataField = $("#addCandidate_consentToKeepData");

    @Step("Fill information in fields")
    public AddCandidatePage fillFields() throws IOException {
        Properties props = new Properties();
        RandomValue randomValue = new RandomValue();
        props.load(new FileInputStream("src/main/resources/properties/newCandidate.properties"));
        firstNameField.sendKeys(props.getProperty("newCandidate.firstName")+ randomValue.generateString(2));
        middleNameField.sendKeys(props.getProperty("newCandidate.middleName")+ randomValue.generateString(2));
        lastNameField.sendKeys(props.getProperty("newCandidate.lastName")+ randomValue.generateString(2));
        emailField.sendKeys(props.getProperty("newCandidate.email"));
        contactNoField.sendKeys(props.getProperty("newCandidate.contactNoField"));
        vacancySelect.selectOption(1);
        keyWordField.sendKeys(props.getProperty("newCandidate.info"));
        commentField.sendKeys(props.getProperty("newCandidate.info"));
        return this;
    }
}
