package homePageTests;

import base.BasePage;
import base.BaseTest;
import data.URLs;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class LeaveMessageFormTest extends BaseTest {
    private HomePage homePage;


    @Test
    public void LeaveMessageFormTest() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        homePage.openLeaveMessageForm();
//        homePage.checkLeaveMessageFormText();
    }
}





