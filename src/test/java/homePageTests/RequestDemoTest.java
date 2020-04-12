package homePageTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.RequestDemoPopupPage;

public class RequestDemoTest extends BaseTest {
    private RequestDemoPopupPage requestDemoPopupPage;



    @Test(priority = 1)
    public void submitEmptyRequestDemoForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
        requestDemoPopupPage.openRequestDemoForm();
        requestDemoPopupPage.checkRequestDemoFormText();
        requestDemoPopupPage.clickSubmitForm();
        requestDemoPopupPage.checkErrorsAfterEmptyFormSubmitted();
    }


    @Test(priority = 2)
    public void submitWrongDataDemoForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
        requestDemoPopupPage.openRequestDemoForm();
        requestDemoPopupPage.checkRequestDemoFormText();
        requestDemoPopupPage.inputData("#$%^&", "$%^&*", "email", "$%^&*", "98", "Ukraine");
        requestDemoPopupPage.clickSubmitForm();
        requestDemoPopupPage.checkErrorsAfterWronglyFormSubmitted();
    }

    @Test(priority = 3)
    public void submitValidDataForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
        requestDemoPopupPage.openRequestDemoForm();
        requestDemoPopupPage.checkRequestDemoFormText();
        requestDemoPopupPage.inputData("firstName", "lastName", "email@i.ua", "AQA", "TestComp", "Poland");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.clickSubmitForm();
        requestDemoPopupPage.isThankYouPopupPresent();
    }
}
