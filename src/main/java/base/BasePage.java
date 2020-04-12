package base;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import javax.xml.ws.Response;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage extends BaseTest {

    private WebDriver driver;

    public BasePage() {
        driver = getDriver();
    }

    public WebElement findElement(By element) {
        return getDriver().findElement(element);
    }

    public List<WebElement> findElements(By element) {
        return getDriver().findElements(element);
    }


    public String getElementText(By element) {
        WebElement wait = new WebDriverWait(getDriver(), 20).until(visibilityOf(findElement(element)));
        return findElement(element).getText();
    }

    public static String getElementText(WebElement element) {

        try {
            waitForPresenceOfElement(element);
            goSleep(1);
            return element.getText();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            goSleep(3);
            return element.getText();
        }
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

    public static void switchToFrame(String frameName) {
        getDriver().switchTo().frame(frameName);
    }

    public void switchToFrame(int index) {
        getDriver().switchTo().frame(index);
    }

    public static void switchToFrame(WebElement element) {
        waitForPresenceOfElement(element);
        getDriver().switchTo().frame(element);
    }

    public static void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
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

    public void clickOnElement(By element) {
        waitForPresenceOfElement(findElement(element));
        findElement(element).click();
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

    public void clickOnElementWithoutSpinnerDisapears(WebElement element) {

        try {
            waitForElementClickable(element, 45);


            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
        } catch (StaleElementReferenceException e) {
            clickThrowStaleException(element);
        } catch (WebDriverException e) {
            clickThrowStaleException(element);
        }

    }


    public void clickOnNotClickableElement(WebElement element) {

        try {
            waitForPresenceOfElement(element, 120);


            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
        } catch (StaleElementReferenceException e) {
            clickThrowStaleException(element);
        }

    }


    public void clickOnElementNotClickable(WebElement element) {
        waitForElementWithMouse(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void clickThrowStaleException(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(3000))
                .ignoring(StaleElementReferenceException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {

                try {
                    clickOnElement(element);
                    return true;
                } catch (WebDriverException e) {
                    return false;
                }
            }
        };
        wait.until(function);
    }

    public static void uploadFile(WebElement element, String path) {
        waitForPresenceOfElement(element);
        try {
            element.sendKeys(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadFileAppProfile(WebElement element, String path) {

        try {
            element.sendKeys(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void fixElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'position: static!important;')", element);
    }

    public static void hideElement(WebElement element) {
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

        js1.executeScript("arguments[0].setAttribute('style', 'display:none;')", element);
        Reporter.log("Hiding element");

    }

    public static void displayElement(WebElement element) {

        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        js1.executeScript("arguments[0].setAttribute('style', 'display: block;')", element);
        Reporter.log("Displaying element");

    }

    public void jsClickOnElement(WebElement element) {
        waitForPresenceOfElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
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


    public static void scrollToBottom() {
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("scroll(0, 1000)"); // if the element is at bottom.
    }

    public static void scrollToBottom(int end) {
        Reporter.log("Scrolling down");
        JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
        jse1.executeScript("scroll(0, " + end + ")"); // if the element is at bottom.
    }

    public static void scrollToTop() {
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


    public void choseElementByIndex(String messages, By element, String tagName, int answerNumber) {
        Reporter.log(messages);
        WebElement table = findElement(element);
        goSleep(5);
        table.findElements(By.tagName(tagName)).get(answerNumber - 1).click();
    }


    public void useHotKey(String message, String hotKey) {
        Reporter.log(message);
        findElement(new By.ById("txtChatScenarioText")).sendKeys(hotKey);
    }

    public void scrollToElement(By elem) {
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

    public static void openURL(String URL) {
        getDriver().get(URL);
    }


    public static void chooseDropdownItem(String itemName, WebElement element) {
        waitForPresenceOfElement(element);
        Select selectTitle = new Select(element);
        selectTitle.selectByVisibleText(itemName);
    }

    public static void chooseDropdownItem(int index, WebElement element) {
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

    public static void switchToTab(int i) {
        ArrayList tabs2 = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(i)));
        Reporter.log("Switching to tab #" + i);
    }

    public static void switchToFirstTab() {
        ArrayList tabs2 = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(0)));
        Reporter.log("Switching to first tab");
    }

    public static void switchToLastTab() {
        ArrayList tabs2 = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(tabs2.size() - 1)));
        Reporter.log("Switching to last tab");
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


    public static boolean isCountIsCorrect(String s) {
//1234
        Reporter.log("Verifying of " + s + " count format");
        return s.matches("\\d+$");
    }


    public static boolean isDateFormatIsCorrect(String s) {
//MM/dd/yyyy
        Reporter.log("Verifying of " + s + " date format");
        return s.matches("((0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d)$");
    }

    public static boolean isMoneyFormatIsCorrect(String s) {

//"$123,546,423.50"
        Reporter.log("Verifying of " + s + " money format");
        return s.matches("(([$]\\d{1,3})[.](\\d{2}))$|(([$]\\d{1,3}[,]\\d{3})[.](\\d{2}))$|(([$]\\d{1,3}[,]\\d{1,3}[,]\\d{3})[.](\\d{2}))$");
    }

    public static boolean isMoneyFormatIsCorrectRefunds(String s) {

//"$-123,546,423.50"
        Reporter.log("Verifying of " + s + " money format");
        return s.matches("(([-][$]\\d{1,3})[.](\\d\\d))$|(([-][$]\\d{1,3}[,]\\d{3})[.](\\d\\d))$|(([-][$]\\d{1,3}[,]\\d{1,3}[,]\\d{3})[.](\\d\\d))$");
    }

    public boolean isElementPresent(By locator) {
//        waitForElement(locator);
        if (getDriver().findElements(locator).size() > 0) {
            return true;
        } else {
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

    public static Boolean isElementPresented(By element) {
        Boolean elementCondition = false;
        try {
            elementCondition = getDriver().findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }

    public static Boolean isElementPresented(WebElement element) {
        Boolean elementCondition = false;
        try {
            elementCondition = element.isDisplayed();
        } catch (NoSuchElementException e) {
            return elementCondition;
        }
        return elementCondition;
    }

    public static Boolean isPresent(WebElement element, int timeWait) {
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

    public boolean baseImageComparison(WebElement element, String imageName,
                                       String pathName) throws IOException {
        Shutterbug.shootElement(getDriver(), element).withName("actual" + imageName).save(getProperty("user.dir") + "/reports/screenshots/actual/" + pathName);

        File actual = new File(getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots" + File.separator +
                "actual" + File.separator + pathName + File.separator + "actual" + imageName + ".png");
        BufferedImage actualImage = ImageIO.read(actual);
        File expected = new File(getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots" + File.separator +
                "expected" + File.separator + pathName + File.separator + imageName + ".png");

        BufferedImage expectedImage = ImageIO.read(expected);
        ImageDiff diff = new ImageDiffer().makeDiff(actualImage, expectedImage);

        if (diff.getDiffSize() < 400) {
            Reporter.log("Verifying of '" + imageName + "' block in '" + pathName + "' page successful");
            return true;
        } else {
            File diffFile = new File(getProperty("user.dir") + File.separator + "reports" + File.separator + "screenshots" + File.separator +
                    "diff" + File.separator + pathName + File.separator + "actual" + imageName + ".png");
            ImageIO.write(diff.getMarkedImage(), "png", diffFile);
            Reporter.log("Verifying of '" + imageName + "' block in '" + pathName + "' page failed");
            Reporter.log("DiffSize is '" + diff.getDiffSize());
            return false;
        }

    }


    public void firstTimeImageSaving(WebElement element, String imageName,
                                     String pathName) {
        Shutterbug.shootElement(getDriver(), element).withName(imageName).save(getProperty("user.dir") + "/reports/screenshots/expected/" + pathName);

    }

    //Waiters


    public void waitForElement(By by) {

        FluentWait<WebDriver> wait3 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        java.util.function.Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver arg0) {

                WebElement element = arg0.findElement(by);
                if (element != null) {
                    Reporter.log("Element found");
                }
                return element;
            }
        };
        wait3.until(function);
    }

    public static void waitUntilSpinnerAbsent(String xpathOfResult) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(4000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (isElementPresented(By.xpath(xpathOfResult))) {
                    Reporter.log("Spinner is present");
                    goSleep(4);
                    hideElement(getDriver().findElement(By.xpath(xpathOfResult)));
                    return false;
                }
                return true;
            }
        };
        wait2.until(function);
    }

    public static void waitUntilElementDissapears(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {

            throw e;
        }
    }


    public static void waitUntilElementAbsent(WebElement element) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (isElementPresented(element)) {
                    Reporter.log("Alert is present");
                    return false;
                }
                Reporter.log("Alert is closed");
                return true;
            }
        };
        wait2.until(function);
    }

    public static void waitUntilTextWitinElementEquals(WebElement element, String expectedText) {

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (getElementText(element).equals(expectedText)) {
                    Reporter.log("Text within element equals expected result (" + expectedText + ")");
                    return true;
                }
                Reporter.log("Waiting for expected text within element");
                return false;
            }
        };
        wait.until(function);
    }


    public static void waitUntilElementPresence(String xpathOfResult) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                goSleep(3);
                if (!isElementPresented(arg0.findElement(By.xpath(xpathOfResult)))) {

                    return false;
                } else {
                    return true;
                }
            }
        };
        wait2.until(function);
    }

    public static void waitUntilBlinkingElementPresence(WebElement element) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (isElementPresented(element)) {
                    JavascriptExecutor executor = (JavascriptExecutor) arg0;
                    executor.executeScript("arguments[0].click();", element);
                    Actions actions = new Actions(arg0);
                    actions.moveToElement(element).build().perform();
                    element.click();

                    return true;
                } else {
                    Actions actions = new Actions(arg0);

                    actions.moveToElement(element).build().perform();
                    Reporter.log("Element is absent");
                    JavascriptExecutor executor = (JavascriptExecutor) arg0;
                    executor.executeScript("arguments[0].click();", element);
                    return false;
                }
            }
        };
        wait2.until(function);
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

    public static void waitForElementDisplayed(WebElement element, String nameAttr, String expectedAttr) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                if (element.getAttribute(nameAttr).equals(expectedAttr)) {
                    Reporter.log("Givelithon is displayed");
                    return true;
                }
                Reporter.log("Givelithon isn't displayed");
                return false;
            }
        };
        wait2.until(function);
    }


    public void waitForElementWithMouse(WebElement element) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {

                getDriver().manage().window().setSize(new Dimension(1926, 840));

                if (isElementPresented(element)) {
                    return true;
                }
                return false;
            }
        };
        wait2.until(function);
    }

    public static void waitForPresenceOfElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {

            throw e;
        }
    }

    public static void waitForPresenceOfElement(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(visibilityOf(getDriver().findElement(By.xpath(xpath))));
        } catch (Exception e) {

            throw e;
        }
    }


    public static void waitForPresenceOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), time);
            wait.until(visibilityOf(element));
        } catch (NoSuchElementException e) {

            throw e;
        }
    }

    public static void waitForElementClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

            throw e;
        }
    }

    public static void waitForElementClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {

            throw e;
        }
    }

    public static void waitForElementClickable(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

            throw e;
        }
    }

    public static void waitForPresenceofElements(List<WebElement> elements) {
        List<WebElement> wait = (new WebDriverWait(getDriver(), 45)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitForStalenessOfElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.stalenessOf(element));
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
     * @param locator - locator of the element
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
}

