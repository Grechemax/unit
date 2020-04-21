package homePageTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.External_URLs;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RequestDemoPopupPage;

public class RequestDemoTest extends BaseTest {
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());


    @Test
    public void submitEmptyRequestDemoForm() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isFirstNameErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isLastNameErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isEmailRequiredErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isJobErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isCompanyErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isCountryErrorPresent());
        Assert.assertTrue(requestDemoPopupPage.isPrivacyErrorPresent());
    }


    @Test
    public void submitWrongDataDemoForm() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("#$%^&", "$%^&*", "email", "$%^&*", "98");
        requestDemoPopupPage.selectCountry("Ukraine");
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isEmailInvalidErrorPresent());
    }

    @Test
    public void submitValidDataForm() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("firstName", "lastName", "email@i.ua", "AQA", "TestComp");
        requestDemoPopupPage.selectCountry("Ukraine");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isThankYouPopupPresent());
    }

    @Test
    public void submitValidDataWithoutCountry() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("firstName", "lastName", "email@i.ua", "AQA", "TestComp");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isCountryErrorPresent());
    }

    @Test
    public void submitValidDataAndSubscribe() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());

        requestDemoPopupPage.inputData("subscribe", "subscribe", "email@i.ua", "AQ", "TestComp2");
        requestDemoPopupPage.selectCountry("Ukraine");
        requestDemoPopupPage.acceptPrivacyPolicy();
        requestDemoPopupPage.confirmSubscriptionCheckbox();
        requestDemoPopupPage.clickSubmitForm();
        Assert.assertTrue(requestDemoPopupPage.isThankYouPopupPresent());
    }

    @Test
    public void privacyPolicyOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.clickPrivacyPolicy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("terms-and-conditions"));
    }

    @Test
    public void infoAboutPersonalDataOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.clickInfoAboutPersonalData();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.INFO_PERSONAL_DATA.URL()));
    }

    @Test
    public void clickHereOpensSubscriptionCenter() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.clickClickHere();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.MORE_INFO.URL()));
    }
}
