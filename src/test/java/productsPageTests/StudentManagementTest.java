package productsPageTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.products.StudentManagementPage;

public class StudentManagementTest extends BaseTest {
    HeaderBasePage headerBasePage;
    StudentManagementPage studentManagementPage;


    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        studentManagementPage = new StudentManagementPage(getDriver());
        headerBasePage.goToStudentManagement();

        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(studentManagementPage.isSupportGrowthTitlePresent());
        Assert.assertTrue(studentManagementPage.isStudentsManagementTitlePresent());
        Assert.assertTrue(studentManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(studentManagementPage.isManchesterUniversityTitlePresent());
        Assert.assertTrue(studentManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(studentManagementPage.getMainTitleText(), "Unit4 Student Management");
        Assert.assertEquals(studentManagementPage.getSupportGrowthInLearningTitleText(), "Support Growth in Learning");
        Assert.assertEquals(studentManagementPage.getStudentsManagementDeliversTitleText(), "Unit4 Student Management Delivers");
        Assert.assertEquals(studentManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(studentManagementPage.getManchesterUniversityTitleText(), "Manchester Metropolitan University");
        Assert.assertEquals(studentManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve students");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(studentManagementPage.isAdmissionsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isAcademicsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isBillingSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isCommunicationSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isReportingSectionTitlePresent());
    }

}

