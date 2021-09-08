package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.RandomValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class AddJobPage extends PageMainLocators {

    SelenideElement jobTitleField = $("#jobTitle_jobTitle");
    SelenideElement jobDescriptionField = $("#jobTitle_jobDescription");
    SelenideElement jobSpecField = $("#jobTitle_jobSpec");
    SelenideElement noteField = $("#jobTitle_note");

    @Step("Fill information in fields")
    public AddJobPage fillFields() throws IOException {
        Properties props = new Properties();
        RandomValue randomID = new RandomValue();
        props.load(new FileInputStream("src/main/resources/properties/newJob.properties"));
        jobTitleField.sendKeys(props.getProperty("newJob.info")+ randomID.generateString(2));
        jobDescriptionField.sendKeys(props.getProperty("newJob.info"));
        noteField.sendKeys(props.getProperty("newJob.info"));
        return this;
    }
}
