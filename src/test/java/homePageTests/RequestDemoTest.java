package homePageTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RequestDemoPopupPage;

public class RequestDemoTest extends BaseTest {
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());


    @Test(priority = 1)
    public void submitEmptyRequestDemoForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.clickSubmitForm();
        requestDemoPopupPage.checkErrorsAfterEmptyFormSubmitted();
    }


    @Test(priority = 2)
    public void submitWrongDataDemoForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("#$%^&", "$%^&*", "email", "$%^&*", "98", "Ukraine");
        requestDemoPopupPage.clickSubmitForm();
        requestDemoPopupPage.checkErrorsAfterWronglyFormSubmitted();
    }

    @Test(priority = 3)
    public void submitValidDataForm() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("firstName", "lastName", "email@i.ua", "AQA", "TestComp", "Poland");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isThankYouPopupPresent());
    }

    @Test(priority = 4)
    public void submitValidDataAndSubscribe() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("subscribe", "subscribe", "email@i.ua", "AQ", "TestComp2", "Spain");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.confirmSubscriptionCheckbox();
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isThankYouPopupPresent());
    }
}
