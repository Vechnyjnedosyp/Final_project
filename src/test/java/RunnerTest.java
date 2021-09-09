import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.*;
import utils.TestsSetups;

import java.io.IOException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RunnerTest extends TestsSetups {

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will login with correct credentials. When we logged we see Dashboard page.")
    @Story(value = "Test for login with correct credentials")
    @Step
    @Test
    @Order(1)
    @DisplayName("User login on website.")
    public void testUserLogin() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getAssertEquals(dashboardPage.title, dashboardPage.tableTitle.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Add new user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add new user. When we added him, we should get a message of successful operation.")
    @Story(value = "Test opportunity to add new user")
    @Step
    @Test
    @Order(2)
    @DisplayName("Add new user.")
    public void testAddNewUser() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AddUserPage addUserPage = new AddUserPage();
        AdminPage adminPage = new AdminPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getSystemUsers()
                .getAssertEquals(adminPage.systemUsersTitle, adminPage.tableTitle.getText());
        adminPage.addNewObject();
        addUserPage.fillFields();
        addUserPage.saveObject();
        addUserPage.getAssertEquals(adminPage.saveText, adminPage.messageInfo.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Add new employee")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add a new employee. When we added him, we should get a message of successful operation.")
    @Story(value = "Test opportunity to add new employee")
    @Step
    @Order(3)
    @Test
    @DisplayName("Add new employee.")
    public void testAddEmployee() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PIMPage pimPage = new PIMPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getEmployeeList()
                .getAssertEquals(pimPage.PIMTitle, pimPage.tableTitle.getText());
        pimPage.addNewObject();
        pimPage.fillFields();
        pimPage.saveObject();
        pimPage.getAssertEquals(pimPage.expectedValue, pimPage.tableTitle.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Add new job")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add a new job. When we added, we should get a message of successful operation.")
    @Story(value = "Test opportunity to add new job")
    @Step
    @Order(4)
    @RepeatedTest(3)
    @DisplayName("Add three jobs.")
    public void testAddJob() throws IOException {
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        AddJobPage addJobPage = new AddJobPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        adminPage.getJobTitleList()
                .getAssertEquals(adminPage.jobTitle, adminPage.tableTitle.getText());
        adminPage.addNewObject();
        addJobPage.fillFields().saveObject();
        addJobPage.getAssertEquals(addJobPage.saveText, addJobPage.messageInfo.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Delete a job")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will delete a job. When we delete a job, we should get a message of successful operation.")
    @Story(value = "Test opportunity to delete a job")
    @Step
    @Order(5)
    @RepeatedTest(3)
    @DisplayName("Delete three jobs.")
    public void testDeleteJob() throws IOException {
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        AddJobPage addJobPage = new AddJobPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        adminPage.getJobTitleList()
                .getAssertEquals(adminPage.jobTitle, adminPage.tableTitle.getText());
        adminPage.deleteJob();
        adminPage.clickDelete();
        addJobPage.getAssertEquals(addJobPage.deleteText, addJobPage.messageInfo.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Add new candidate")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add a new candidate. When we added him, we should get a message of successful operation.")
    @Story(value = "Test opportunity to add new candidate")
    @Step
    @Order(6)
    @Test
    @DisplayName("Add new candidate.")
    public void testAddCandidate() throws IOException {
        LoginPage loginPage = new LoginPage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        AddCandidatePage addCandidatePage = new AddCandidatePage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getCandidates()
                .getAssertEquals(recruitmentPage.candidatesTitle, recruitmentPage.tableTitle.getText());
        recruitmentPage.addNewObject();
        addCandidatePage.fillFields();
        addCandidatePage.saveObject();
        addCandidatePage.getAssertEquals(addCandidatePage.saveText, addCandidatePage.messageInfo.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Make assign leave")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will assign leave. When we made it, we should get a message of successful operation.")
    @Story(value = "Test opportunity to make assign leave")
    @Step
    @Order(7)
    @Test
    @DisplayName("Make assign leave.")
    public void testAssignLeave() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AssignLeavePage assignLeavePage = new AssignLeavePage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getAssignLeave()
                .getAssertEquals(assignLeavePage.title, assignLeavePage.tableTitle.getText());
        assignLeavePage.fillFields();
        assignLeavePage.getAssertEquals(assignLeavePage.successText, assignLeavePage.messageInfo.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Check elements on dashboard page")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will check elements on the dashboard.")
    @Story(value = "Test to exist all elements on the dashboard")
    @Step
    @Order(8)
    @Test
    @DisplayName("Check elements on dashboard page.")
    public void testElementsDashboard() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.checkElements();
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Check form of salesperson")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will check form of the salesperson.")
    @Story(value = "Test to exist some fields in form of the salesperson")
    @Step
    @Order(9)
    @Test
    @DisplayName("Check some fields on the salesperson form.")
    public void testPIM() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PIMPage pimPage = new PIMPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getEmployeeList()
                .getAssertEquals(pimPage.PIMTitle, pimPage.tableTitle.getText());
        pimPage.searchSales().checkForm();
        pimPage.getAssertEquals(pimPage.expectedValue, pimPage.tableTitle.getText());
    }

    @Epic("TESTING FOR https://opensource-demo.orangehrmlive.com/index.php/auth/login tasks")
    @Feature(value = "Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test a user will logout. When he logout, he should see the Login page.")
    @Story(value = "Test of logout")
    @Step
    @Test
    @Order(10)
    @DisplayName("User logout on website.")
    public void testUserLogout() throws IOException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.openLoginPage().logInPanelHeading.shouldBe(Condition.visible);
        loginPage.login();
        dashboardPage.getAssertEquals(dashboardPage.title, dashboardPage.tableTitle.getText());
        dashboardPage.logout();
    }
}
