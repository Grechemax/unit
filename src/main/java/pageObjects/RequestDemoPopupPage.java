package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RequestDemoPopupPage extends BasePage {
    private By requestDemoCTA = By.xpath("//a[contains(@class, 'button cta cta-default button_global_demo')]");
    private By submitFormButton = By.xpath("//input[contains(@value, 'Schedule a demo')]");
    private By requestDemoFormLongHeader = By.xpath("//div[@class = 'u4-modal-body']//h3");
    private By requestDemoHeader = By.xpath("//form//h4");
    private By thankYouPopupHeader = By.xpath("//div[@id='u4-modal-thanks']//h3");

    private By firstNameRequiredError = By.xpath("//span[@id='edit-first-name-error']");
    private By lastNameRequiredError = By.xpath("//span[@id='edit-last-name-error']");
    private By emailRequiredError = By.xpath("//span[@id='edit-email-address-error']");
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


    public RequestDemoPopupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openRequestDemoForm() {
        clickOnElement(requestDemoCTA);
    }

    public void checkRequestDemoFormText() {
        String displayedRequestDemoFormHeader = getElementText(requestDemoHeader);
        String displayedRequestDemoFormLongHeader = getElementText(requestDemoFormLongHeader);


        Assert.assertEquals(displayedRequestDemoFormHeader, "Get a Unit4 demo customized 4U!");
        Assert.assertEquals(displayedRequestDemoFormLongHeader, "See what a better People Experience can do for your organization.");
    }

    public void checkErrorsAfterEmptyFormSubmitted() {
        String displayedFirstNameError = getElementText(firstNameRequiredError);
        String displayedLastNameError = getElementText(lastNameRequiredError);
        String displayedEmailError = getElementText(emailRequiredError);
        String displayedJobError = getElementText(jobRequiredError);
        String displayedCompanyError = getElementText(companyRequiredError);
        String displayedCountryError = getElementText(countryRequiredError);
        String displayedPrivacyPolicyError = getElementText(privacyAgreementError);

        Assert.assertEquals(displayedFirstNameError, "Required");
        Assert.assertEquals(displayedLastNameError, "Required");
        Assert.assertEquals(displayedCountryError, "Required");
        Assert.assertEquals(displayedEmailError, "A valid email address is required");
        Assert.assertEquals(displayedJobError, "Required");
        Assert.assertEquals(displayedCompanyError, "Required");
        Assert.assertEquals(displayedPrivacyPolicyError, "You must agree to this in order for us to proceed with your request");
    }

    public void checkErrorsAfterWronglyFormSubmitted() {

    }

    public boolean isThankYouPopupPresent() {
        Reporter.log("'Thank you' popup after form have been submitted is present");
        goSleep(3);
        return isElementPresent(thankYouPopupHeader);
    }

    public void inputData(String firstName, String lastName, String email, String job, String company, String country) {
        findElement(firstNameInput).sendKeys(firstName);
        findElement(lastNameInput).sendKeys(lastName);
        findElement(emailInput).sendKeys(email);
        findElement(jobInput).sendKeys(job);
        findElement(companyInput).sendKeys(company);
        Select select = new Select(getDriver().findElement(countryDropdown));
        select.selectByVisibleText(country);
    }

    public void acceptPrivacyPolicy() {
        clickOnElementUsingJS(privacyCheckbox);
    }

    public void clickSubmitForm() {
        clickOnElementUsingJS(submitFormButton);
    }



}