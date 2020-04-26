package base;

import com.google.common.base.Function;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage extends BaseTest {

    private WebDriver driver;
    private By footerLogo = By.xpath("//h2[contains(@class, 'sitefooter-logo')]");
    private By showMoreButton = By.xpath("//*[contains(text(), 'Show more')]");

    public BasePage() {
        driver = getDriver();
    }



    public WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    /**
     * Method returns List of webElements from locator
     * @param locator - locator of the element
     * @return
     */
    public List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    /**
     * Method performs click on webElement if element present on page
     * @param locator - locator of the element
     */
    public void clickElementIfPresent(By locator)  {
        if(isElementPresent(locator)){
            getDriver().findElement(locator).click();
        }
    }

    /**
     * Method performs click on webElement if element present on page
     * @param locator - locator of the element
     */
    public void clickElementIfVisible(By locator)  {
        if(isElementVisible(locator)){
            clickOnElement(locator);
        }
    }

    /**
     * Method performs click on webElement if element present on page
     * @param locator - locator of the element
     */
    public void clickElementIfPresent(By locator, int howMuchTimeToWait)  {
        if(isElementPresent(locator, howMuchTimeToWait)){
            waitUntilElementToBeClickable(locator,15);
            getDriver().findElement(locator).click();
        }
    }

    /**
     * Method performs click on webElement if element present on page and wait invisibility
     * @param locator - locator of the element
     */
    public void clickElementIfPresentAndWaitInvisibility(By locator, int howMuchWaitForVisibility, int howMuchWaitForInVisibility)  {
        if(isElementVisible(locator,howMuchWaitForVisibility)) {
            clickOnElementUsingJS(locator);
            waitInVisibilityOfElement(locator, howMuchWaitForInVisibility);
        }
    }

    /**
     * Method performs click on webElement if element clickable on page
     * @param locator - locator of the element
     */
    public void clickElementIfClickable(By locator, int howMuchTimeToWait)  {
        if(isElementClickable(locator, howMuchTimeToWait)){
            getDriver().findElement(locator).click();
        }
    }

    /**
     * Returns true if element present on page
     * @param locator - locator of the element
     * @return
     */
    public boolean isElementPresent(By locator){
        return findElements(locator).size()>0;
    }

    /**
     * Performs click on element
     * @param locator - locator of the element
     */
    public void clickOnElement(By locator) {
        findElement(locator).click();
    }


    /**
     * Performs move to element if element present ignoring stale element reference exception one time with pause
     * @param locator
     */
    public void clickOnPresentedElementUsingJSThroughStaleElementReference(By locator, int howMuchWait) {
        waitPresenceOfElement(locator, howMuchWait);
        try {
            clickOnElementUsingJS(locator);
        } catch (StaleElementReferenceException e){
            sleepTightInSeconds(5);
            clickOnElementUsingJS(locator);
        }
    }


    /**
     * Method waits for element visibility status and clicks after that
     * @param locator - locator of the element
     * @param timeWait - how much time to wait
     */
    public void clickOnVisibleElement(By locator, int timeWait) {
        waitVisibilityOfElement(locator, timeWait);
        clickOnElement(locator);
    }

    /**
     * Method for navigate to url
     * @param URL
     */
    public static void openURL(String URL){
        Reporter reporter = new Reporter();
        reporter.log("Opening url '"+URL+"'", true);
        getDriver().get(URL);
    }

    /**
     * Performs maximize action of browser
     */
    public void maximizeWindow(){
        getDriver().manage().window().maximize();
    }

    /**
     * Performs full screen action of browser
     */
    public void fullScreenWindow(){
        getDriver().manage().window().fullscreen();
    }


    public void waitUntilElementToBeClickable(By locator, int howMuchTimeToWait){
        WebDriverWait wait = new WebDriverWait(getDriver(), howMuchTimeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementToBeClickable(WebElement element, int howMuchTimeToWait){
        WebDriverWait wait = new WebDriverWait(getDriver(), howMuchTimeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementContainsAnyText(By locator, int howMuchTimeToWait) {
        WebDriverWait wait = new WebDriverWait(getDriver(), howMuchTimeToWait);
        wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(".")));
    }

    public void waitVisibilityOfElement(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitInVisibilityOfElement(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitPresenceOfElement(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator, int waitTime) {
        try {
            WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public boolean isElementContainsAnyText(By locator, int waitTime) {
        try {
            WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
            wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(".")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(By locator, int waitTime) {
        try {
            WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), 1));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isFrameReadyToSwitch(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Performs text setting with text clearing, ignoring StaleElementReference
     * @param locator
     * @param text
     */
    public void setTextInElementWithTextClearing(By locator, String text) {
        waitUntilElementToBeClickable(locator, 15);
        try {
            findElement(locator).clear();
            Actions actions = new Actions(getDriver());
            actions.moveToElement(findElement(locator)).click().build().perform();
            findElement(locator).sendKeys(text);
        } catch (Exception e){
            sleepTightInSeconds(3);
            findElement(locator).clear();
            findElement(locator).sendKeys(text);
        }
    }

    /**
     * Fro switching to frame
     * @param locator
     */
    public void switchToFrame(By locator) {
        getDriver().switchTo().frame(findElement(locator));
    }

    /**
     * Fro switching to frame
     * @param locator
     */
    public void switchToFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    /**
     * For switching to default content
     */
    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    /**
     * Returns value of element as String , ignoring staleelement reference exception one time with pause
     * @param element
     * @param attributeName
     * @return
     */
    public String getAttributeValueByName(WebElement element, String attributeName){
        String attributeValue;
        try {
            moveToElement(element);
            attributeValue = element.getAttribute(attributeName);
        } catch (Exception e){
            sleepTightInSeconds(10);
            moveToElement(element);
            attributeValue= element.getAttribute(attributeName);
        }

        return attributeValue;
    }

    /**
     * Returns value of element as String , ignoring staleelement reference exception one time with pause
     * @param locator
     * @param attributeName
     * @return
     */
    public String getAttributeValueByName(By locator, String attributeName){
        String attributeValue;
        WebElement element = findElement(locator);
        try {
            moveToElement(element);
            attributeValue = element.getAttribute(attributeName);
        } catch (StaleElementReferenceException e){
            sleepTightInSeconds(10);
            moveToElement(element);
            attributeValue= element.getAttribute(attributeName);
        }

        return attributeValue;
    }

    /**
     * Return text value of element
     * @param locator
     * @return
     */
    public String getTextValue(By locator){
        String textValue;
        try {
            textValue= getDriver().findElement(locator).getText();
        } catch (StaleElementReferenceException e){
            sleepTightInSeconds(4);
            textValue= getDriver().findElement(locator).getText();
        }
        return textValue;
    }

    public String getTextValueIfElementPresent(By locator){
        if(isElementPresent(locator,3)){
            return getTextValue(locator);
        } else {
            return "";
        }
    }

    /**
     * Returns list of certain attribute values as list of strings that fetched from list of web elements
     * @param webElements - list to get values
     * @param attributeName - attribute that we want to return
     * @return
     */
    public List<String> getAttributesListFromWebElementList(List<WebElement> webElements, String attributeName){
        List<String> attributes = new ArrayList<>();
        webElements.forEach(webElement
                -> attributes.add(getAttributeValueByName(webElement,attributeName)));
        return attributes;
    }

    /**
     * Returns list of text values as list of strings that fetched from list of web elements
     * @param webElements - list to get text values
     * @return
     */
    public List<String> getTextListFromWebElementList(By locatorOfList){
        List<String> attributes = new ArrayList<>();
        findElements(locatorOfList).forEach(webElement -> attributes.add(webElement.getText()));
        return attributes;
    }

    /**
     * Performs scroll to bottom action
     */
    public void scrollToBottom() {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("scroll(0, 10000)"); // if the element is at bottom.
    }

    /**
     * Returns web element list size as int
     * @param locator
     * @return
     */
    public int quantityOfElements(By locator){
        int size;
        try {
            size = findElements(locator).size();
        } catch (StaleElementReferenceException e){
            sleepTightInSeconds(3);
            size = findElements(locator).size();
        }
        return size;
    }

    public boolean isEnvironmentStage(){
        return getDriver().getCurrentUrl().contains("stage");
    }

    /**
     * Performs scroll into view
     * @param scrolledElement
     */
    public void scrollIntoView(By scrolledElement){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", findElement(scrolledElement));
    }

    /**
     * Performs move to element (mouse hover)
     * @param element
     */
    public void moveToElement(By locator) {
        Actions actions = new Actions(getDriver());
        WebElement element = findElement(locator);
        Action mouseOver = actions.moveToElement(element).build();
        mouseOver.perform();
    }

    /**
     * Performs move to element (mouse hover)
     * @param element
     */
    public void moveToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        Action mouseOver = actions.moveToElement(element).build();
        mouseOver.perform();
    }

    /**
     * Performs move to element if element present ignoring stale element reference exception one time with pause
     * @param locator
     */
    public void moveToElementIfPresentThroughStaleElementReference(By locator) {
        if (isElementPresent(locator)) {
            try {
                moveToElement(locator);
            } catch (StaleElementReferenceException e){
                sleepTightInSeconds(2);
                moveToElement(locator);
            }

        }
    }

    /**
     * Method returns height of element in pixels at page
     * @param locator - locator of element
     * @return
     */
    public int getElementHeight(By locator){
        int height;
        try {
            height = Integer.parseInt(findElement(locator).getCssValue("height").replace("px",""));
        } catch (StaleElementReferenceException e) {
            sleepTightInSeconds(2);
            height = Integer.parseInt(findElement(locator).getCssValue("height").replace("px",""));
        }
        return  height;
    }

    /**
     * Performs click on element from list by relative number
     * @param locatorOfElementsList - locator of list
     * @param relativeNumber - index of element
     */
    public void clickOnTheElementByIndex(By locatorOfElementsList, int relativeNumber) {
        List<WebElement> elements = findElements(locatorOfElementsList);
        moveToElement(elements.get(relativeNumber));
        sleepTightInSeconds(2);
        waitUntilElementToBeClickable(elements.get(relativeNumber),30);
        clickOnElementUsingJS(elements.get(relativeNumber));
    }



    /**
     * Methods for wait that element present and after that wait when element disappears (generally for spinners etc)
     * @param locator - locator of the element
     * @param howMuchWaitForVisibility - time in sec how much time to wait for visibility of element
     * @param howMuchWaitForInVisibility - if element present how much time to wait for invisibility of element
     */

    public void waitForElementVisibilityAndInvisibilityAfterIt(By locator, int howMuchWaitForVisibility, int howMuchWaitForInVisibility ){
        if(isElementVisible(locator,howMuchWaitForVisibility)) {
            waitInVisibilityOfElement(locator, howMuchWaitForInVisibility);
        }

    }

    /**
     * Return text value of element
     *
     * @param locator
     * @return
     */
    public String getElementText(By locator) {
        String textValue;
        try {
            textValue = getDriver().findElement(locator).getText();
        } catch (StaleElementReferenceException e) {
            goSleep(5);
            textValue = getDriver().findElement(locator).getText();
        }
        return textValue;
    }

    /**
     * Return text value of element
     *
     * @param element
     * @return
     */
    public String getElementText(WebElement element) {
        String textValue;
        try {
            textValue = element.getText();
        } catch (StaleElementReferenceException e) {
            goSleep(4);
            textValue = element.getText();
        }
        return textValue;
    }


    public String getElementHref(By element) {
        Reporter.log("Getting element href - " + findElement(element).getAttribute("href"));
        return findElement(element).getAttribute("href");
    }

    public String getElementHref(WebElement element) {
        Reporter.log("Getting element href - " + element.getAttribute("href"));
        return element.getAttribute("href");
    }

    public String getElementTextValue(By element) {
        Reporter.log("Getting element text - " + findElement(element).getText());
        return findElement(element).getAttribute("value");
    }

    public void typeTextToField(String message, String text, By field) {
        Reporter.log(message + " With data - " + text);
        findElement(field).sendKeys(text);
    }

    public void overwriteTextToField(String message, String text, By field) {
        Reporter.log(message + " With data - " + text);
        findElement(field).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), text);
    }

    public void tapENTER(By element) {
        getDriver().findElement(element).sendKeys(Keys.ENTER);
    }

    public void tapARROW_DOWN(By element) {
        getDriver().findElement(element).sendKeys(Keys.ARROW_DOWN);
    }

    public void typeSimulation(String message, String keys, By field) {
        clickOnElement(field);
        Reporter.log(message);
        Robot robot;
        try {
            robot = new Robot();
            for (int i = 0; i < keys.length(); i++) {
                final char ch = keys.charAt(i);
                final boolean upperCase = Character.isUpperCase(ch);
                final int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
                robot.delay(10);
                if (upperCase) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                if (upperCase) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
            }
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void switchToFrame(int index) {
        getDriver().switchTo().frame(index);
    }

    public void switchToFrame(WebElement element) {
        waitForPresenceOfElement(element);
        getDriver().switchTo().frame(element);
    }



    public void switchToPopUp() {
        switchToDefaultContent();
        switchToFrame(0);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
        scrollToTop();
    }

    public void goToPreviousPage() {
        getDriver().navigate().back();
    }


    public void clickOnElementFromList(String message, By elements, int elementIndex) {
        Reporter.log(message);
        getDriver().findElements(elements).get(elementIndex - 1).click();
    }



    public void clickOnElement(WebElement element) {

        try {
            waitForElementClickable(element, 40);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
        } catch (WebDriverException e) {
            goSleep(2);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
        }

    }


    public void uploadFile(WebElement element, String path) {
        try {
            element.sendKeys(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void fixElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'position: static!important;')", element);
    }

    public void hideElement(WebElement element) {
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

        js1.executeScript("arguments[0].setAttribute('style', 'display:none;')", element);
        Reporter.log("Hiding element");

    }

    public void displayElement(WebElement element) {

        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        js1.executeScript("arguments[0].setAttribute('style', 'display: block;')", element);
        Reporter.log("Displaying element");

    }


    public void clickOnElementWithWait(String message, By element, int timeWaitSeconds) {
        Reporter.log(message);
        getDriver().manage().timeouts().implicitlyWait(timeWaitSeconds, TimeUnit.SECONDS);
        try {
            clickOnElement(element);
        } catch (Exception e) {
            Reporter.log("Element is not visible, it might be present in other tab.");
        } finally {
            getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
    }


    public void clickButton(String xPathExpression) {
        getDriver().findElement(By.xpath(xPathExpression)).click();
    }


    public boolean isCheckedByClass(By element, String textToContain) {
        return findElement(element).getAttribute("class").contains(textToContain);
    }

    public boolean isCheckedByClass(By element, String attributeName, String textToContain) {
        return findElement(element).getAttribute(attributeName).contains(textToContain);
    }


    public static void scrollToBottom(int end) {
        Reporter.log("Scrolling down");
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("scroll(0, " + end + ")"); // if the element is at bottom.
    }

    public static void scrollToTop() {Reporter.log("Scrolling up");
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("scroll(1000, 0)"); // if the element is on top.
    }

    public void refreshPageUntilElementContainsText(By element, List<String> successList, int tries) {
        for (int i = 1; i <= tries; i++) {
            if (successList.contains(getElementText(element).toLowerCase())) {
                break;
            } else {
                Reporter.log("Page refreshing...");
                goSleep(10);
                getDriver().navigate().refresh();
            }
        }
    }

    public void chooseSelectOptionByName(String message, By selectElement, String optionText) {
        Reporter.log(message + optionText);
        Select dropdown = new Select(findElement(selectElement));
        dropdown.selectByVisibleText(optionText);
    }

    public void clearTextField(By textField) {
        Reporter.log("Clearing text field");
        getDriver().findElement(textField).clear();
    }

    public void selectCheckboxIfNotSelected(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            clickOnElement(checkbox);
            Reporter.log("Selecting checkbox");
        }
    }

    public void unSelectCheckboxIfSelected(WebElement checkbox) {
        if (checkbox.isSelected()) {
            clickOnElement(checkbox);
            Reporter.log("Deselecting checkbox");
        }
    }

    public String getElementValue(By element) {
        return getDriver().findElement(element).getAttribute("value");
    }

    public String getElementAttributeValue(WebElement element, String attrName) {
        waitForPresenceOfElement(element, 40);
        return element.getAttribute(attrName);
    }

    public String getElementAttributeValueNonPresence(WebElement element, String attrName) {

        return element.getAttribute(attrName);
    }

    public String getAttributeValue(WebElement element, String attrName) {
        return element.getAttribute(attrName);
    }

    public String getAttributeValueVisibleElement(WebElement element, String attrName) {
        waitForPresenceOfElement(element);
        return element.getAttribute(attrName);
    }


    public void useHotKey(String message, String hotKey) {
        Reporter.log(message);
        findElement(new By.ById("txtChatScenarioText")).sendKeys(hotKey);
    }

    public void scrollToElement(By elem) {
        base.Reporter.log("Scrolling to element");
        WebElement element = findElement(elem);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectCheckBox(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }


    public void moveToElement(String xpath) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(xpath));
        action.moveToElement(element);
        action.build().perform();
        goSleep(2);
    }


    public void hoverOverElement(By element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(findElement(element)).perform();
//        goSleep(2);
    }



    public void chooseDropdownItem(String itemName, WebElement element) {
        waitForPresenceOfElement(element);
        Select selectTitle = new Select(element);
        selectTitle.selectByVisibleText(itemName);
    }

    public void chooseDropdownItem(int index, WebElement element) {
        waitForPresenceOfElement(element);
        Select selectTitle = new Select(element);
        selectTitle.selectByIndex(index);
    }

    public void setTextEl(WebElement element, String text) {
        waitForPresenceOfElement(element);
        element.clear();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        element.sendKeys(text);

    }

    public void setTextEl(By element, String text) {
        waitForPresenceOfElement(findElement(element));
        findElement(element).clear();
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element)).click().build().perform();
        findElement(element).sendKeys(text);
    }

    public void switchToTab(int i) {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(i)));
        Reporter.log("Switching to tab #" + i);
    }

    public void switchToFirstTab() {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(0)));
        Reporter.log("Switching to first tab");
    }

    public static void switchToLastTab() {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(tabs2.size() - 1)));
        Reporter.log("Switching to last tab");
    }

    public static boolean isCurrentUrlContains(String bit) {
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl.contains(bit);
    }

    public String backgroundColorElement(WebElement element) {
        try {
            waitForPresenceOfElement(element, 10);
        } catch (org.openqa.selenium.TimeoutException e) {
            Reporter.log("Element not found: " + e);
        }
        return element.getCssValue("background-color");
    }

    //Regexp


    public boolean isCountIsCorrect(String s) {
//1234
        Reporter.log("Verifying of " + s + " count format");
        return s.matches("\\d+$");
    }


    public boolean isDateFormatIsCorrect(String s) {
//MM/dd/yyyy
        Reporter.log("Verifying of " + s + " date format");
        return s.matches("((0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d)$");
    }

    public boolean isMoneyFormatIsCorrect(String s) {

//"$123,546,423.50"
        Reporter.log("Verifying of " + s + " money format");
        return s.matches("(([$]\\d{1,3})[.](\\d{2}))$|(([$]\\d{1,3}[,]\\d{3})[.](\\d{2}))$|(([$]\\d{1,3}[,]\\d{1,3}[,]\\d{3})[.](\\d{2}))$");
    }

    public boolean isMoneyFormatIsCorrectRefunds(String s) {

//"$-123,546,423.50"
        Reporter.log("Verifying of " + s + " money format");
        return s.matches("(([-][$]\\d{1,3})[.](\\d\\d))$|(([-][$]\\d{1,3}[,]\\d{3})[.](\\d\\d))$|(([-][$]\\d{1,3}[,]\\d{1,3}[,]\\d{3})[.](\\d\\d))$");
    }


    public boolean isElementPresentWithTimer(By locator, int waitTime) {
        try {
            WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisibleWithTimer(By locator, int waitTime) {
        try {
            WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        waitForPresenceOfElement(element);

        try {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.ofSeconds(1));
            wait.until(visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isElementPresented(By element) {
        Boolean elementCondition = false;
        try {
            elementCondition = getDriver().findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }

    public Boolean isElementPresented(WebElement element) {
        Boolean elementCondition = false;
        try {
            elementCondition = element.isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }

    public Boolean isPresent(WebElement element, int timeWait) {
        Boolean isPresent;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), timeWait);
            webDriverWait.until(visibilityOf(element));
            isPresent = element.isDisplayed();
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }




    public void waitForElement(By locator) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), 20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  // visibilityOfElementLocated: Checks to see if the element is present and also visible.
    }

    public void waitForElementWithWaitTime(By locator, int timeWait) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), timeWait));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  // visibilityOfElementLocated: Checks to see if the element is present and also visible.
    }



    public void waitForElement(WebElement webElement) {

        FluentWait<WebDriver> wait4 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver arg0) {
                if (webElement != null) {
                }
                return webElement;
            }
        };
        wait4.until(function);
    }

    public static void goSleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void waitForPresenceOfElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw e;
        }
    }


    public void waitForPresenceOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), time);
            wait.until(visibilityOf(element));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public void waitForElementClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

            throw e;
        }
    }

    public void waitForElementClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {

            throw e;
        }
    }

    public void waitForElementClickable(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

            throw e;
        }
    }



    /**
     * Performs click on element
     *
     * @param locator - locator of the element
     */
    public void clickOnElementUsingJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", findElement(locator));
    }

    /**
     * Performs click on element
     *
     * @param element - locator of the element
     */
    public void clickOnElementUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", element);
    }

    public static void checkLinks(String page) {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        getDriver().get(page);

        List<WebElement> links = getDriver().findElements(By.tagName("a"));

        Iterator<WebElement> iterator = links.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href");
            System.out.println(respCode);


            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if (!url.contains("unit4.com")) {
                System.out.println(url + " URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400 && respCode != 403) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void sleepTightInMiliSeconds(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickShowMoreUntilVisible() {
        while (isElementPresentWithTimer(showMoreButton, 5)) {
            scrollToElement(footerLogo);
            scrollToElement(footerLogo);

            moveToElement(showMoreButton);
            goSleep(2);
            clickOnElementUsingJS(showMoreButton);
            sleepTightInMiliSeconds(1222);
        }
    }

    public void sleepTightInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }
    }

    public void waitUntilElementAbsent(WebElement element) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (isElementPresented(element)) {
                    base.Reporter.log("Alert is present");
                    return false;
                }
                base.Reporter.log("Alert is closed");
                return true;
            }
        };
        wait2.until(function);
    }


}

