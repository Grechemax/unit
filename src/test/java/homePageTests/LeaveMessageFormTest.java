package homePageTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class LeaveMessageFormTest extends BaseTest {
    private HomePage homePage;


    @Test
    public void LeaveMessageFormTest() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        homePage.openLeaveMessageForm();
        homePage.checkLeaveMessageFormText();
    }
}





