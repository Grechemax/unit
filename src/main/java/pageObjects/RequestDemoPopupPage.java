package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RequestDemoPopupPage extends BasePage {

    private By closeRequestDemoBtn = By.xpath("//*[@id='u4-modal-request-demo']/div/div/div[3]/button");
    private By submitFormButton = By.xpath("//input[contains(@value, 'Schedule a demo')]");
    private By requestDemoLongHeader = By.xpath("//*[contains(text(), 'See what a better People Experience can do for your organization.')]");
    private By requestDemoMainHeader = By.xpath("//*[contains(text(), 'Get a Unit4 demo customized 4U!')]");
    private By thankYouPopupHeader = By.xpath("//div[@id='u4-modal-thanks']//h3");

    private By firstNameRequiredError = By.xpath("//span[@id='edit-first-name-error']");
    private By lastNameRequiredError = By.xpath("//span[@id='edit-last-name-error']");
    private By emailRequiredError = By.xpath("//span[@id='edit-email-address-error']");
    private By emailInvalidError = By.xpath("//span[@id='edit-email-address-error' and contains(text(), 'does not contain a valid email')]");
    private By jobRequiredError = By.xpath("//span[@id='edit-job-title-error']");
    private By companyRequiredError = By.xpath("//span[@id='edit-company-error']");
    private By countryRequiredError = By.xpath("//span[@id ='edit-country-error']");
    private By privacyAgreementError = By.xpath("//span[@id ='confirm_privacy-error']");

    private By firstNameInput = By.xpath("//input[@id = 'edit-first-name']");
    private By lastNameInput = By.xpath("//input[@id = 'edit-last-name']");
    private By emailInput = By.xpath("//input[@id = 'edit-email-address']");
    private By jobInput = By.xpath("//input[@id = 'edit-job-title']");
    private By companyInput = By.xpath("//input[@id = 'edit-company']");
    private By countryDropdown = By.xpath("//select[@id = 'edit-country']");
    private By privacyCheckbox = By.xpath("//input[@id='request-demo-confirm-privacy']");
    private By confirmSubscribeCheckbox = By.xpath("//input[@id='request-demo-confirm-subscribe']");


    public RequestDemoPopupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closeRequestDemoForm() {
        clickOnElement(closeRequestDemoBtn);
        Reporter.log("closing request demo form");
    }

    public boolean isRequestDemoFormMainHeaderPresent() {
        Reporter.log("request form main header is present");
        return isElementPresent(requestDemoMainHeader);
    }

    public boolean isRequestDemoFormHeaderPresent() {
        Reporter.log("request form additional header is present");
        return isElementPresented(requestDemoLongHeader);
    }

    public boolean isFirstNameErrorPresent() {
        Reporter.log("checking if 'Required' error message is present for 'First Name'");
        return isElementPresented(firstNameRequiredError);
    }

    public boolean isLastNameErrorPresent() {
        Reporter.log("checking if 'Required' error message is present for 'Last Name'");
        return isElementPresented(lastNameRequiredError);
    }

    public boolean isEmailRequiredErrorPresent() {
        Reporter.log("checking if 'A valid email address is required' error message is present for 'Email'");
        return isElementPresented(emailRequiredError);
    }

    public boolean isEmailInvalidErrorPresent() {
        Reporter.log("checking if 'Email Address does not contain a valid email.' error message is present for 'Email'");
        return isElementPresented(emailRequiredError);
    }

    public boolean isJobErrorPresent() {
        Reporter.log("checking if 'Required' error message is present for 'Job Title'");
        return isElementPresented(jobRequiredError);
    }

    public boolean isCompanyErrorPresent() {
        Reporter.log("checking if 'Required' error message is present for 'Company'");
        return isElementPresented(companyRequiredError);
    }

    public boolean isCountryErrorPresent() {
        Reporter.log("checking if 'Required' error message is present for 'Select country'");
        return isElementPresented(countryRequiredError);
    }

    public boolean isPrivacyErrorPresent() {
        Reporter.log("checking if 'You must agree...' error message is present for privacy policy checkbox");
        return isElementPresented(privacyAgreementError);
    }


    public boolean isThankYouPopupPresent() {
        Reporter.log("'Thank you' popup after form have been submitted is present");
        waitForElement(thankYouPopupHeader);
        return isElementPresent(thankYouPopupHeader);
    }

    public void inputData(String firstName, String lastName, String email, String job, String company) {
        findElement(firstNameInput).sendKeys(firstName);
        findElement(lastNameInput).sendKeys(lastName);
        findElement(emailInput).sendKeys(email);
        findElement(jobInput).sendKeys(job);
        findElement(companyInput).sendKeys(company);
        Reporter.log("inputting data");
    }

    public void selectCountry(String country) {
        Select select = new Select(getDriver().findElement(countryDropdown));
        select.selectByVisibleText(country);
        Reporter.log("selecting country");
    }


    public void acceptPrivacyPolicy() {
        clickOnElementUsingJS(privacyCheckbox);
        Reporter.log("ticking checkbox to accept privacy policy");
    }

    public void confirmSubscriptionCheckbox() {
        clickOnElementUsingJS(confirmSubscribeCheckbox);
        Reporter.log("ticking checkbox to subscribe for news");
    }

    public void clickSubmitForm() {
        clickOnElementUsingJS(submitFormButton);
        Reporter.log("submitting form");
    }


}