package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static base.BaseTest.getDriver;
import static java.lang.System.getProperty;

public class Ashot {
    public static String diffPath;
    public static String[] screenshotsOnFailure;


    public void setScreenshotsOnFailure(String imageName, String path, int x){
        screenshotsOnFailure[x]="screenshots"+File.separator+"diff"+File.separator+path+File.separator+imageName;
    }

    ExtentTest logger;

    public void screenShotElements(List<WebElement> elements, String path, String filename) throws IOException {


        Screenshot screenshot = new
                AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(500)).
                takeScreenshot(getDriver(),elements);
        File actualFile = new File(System.getProperty("user.dir")+ File.separator+
                "reports"+File.separator+"screenshots"+File.separator+"expected"+path+File.separator+filename+".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);
    }

    public boolean imagesComparison(List<WebElement> elements, String imageName,
                                    String pathName) throws IOException {


        Screenshot screenshot = new
                AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(500)).
                takeScreenshot(getDriver(),elements);
        File actualFile = new File(System.getProperty("user.dir")+File.separator+
                "reports"+File.separator+"screenshots"+File.separator+"actual"
                +File.separator+pathName+File.separator+imageName+".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);

        BufferedImage actualImage = ImageIO.read(actualFile);

        File expected = new File(getProperty("user.dir")
                +File.separator+ "reports"+ File.separator + "screenshots" + File.separator +
                "expected" + File.separator + pathName + File.separator + imageName + ".png");

        BufferedImage expectedImage = ImageIO.read(expected);
        ImageDiff diff = new ImageDiffer().makeDiff(actualImage, expectedImage);

        if (diff.getDiffSize()<150){
            Reporter.log("Verifying of '" + imageName+"' block in '" +pathName+"' page successful");
            return true;
        } else {
            String diffFileName = getProperty("user.dir")+File.separator + "reports"+ File.separator +"screenshots"
                    +File.separator+"diff"+File.separator+pathName+File.separator+imageName+".png";
            File diffFile = new File(diffFileName);
            ImageIO.write(diff.getMarkedImage(), "png", diffFile);
            Reporter.log("Verifying of '" + imageName+"' block in '" +pathName+"' page failed, images are different");
            Reporter.log("DiffSize is '" + diff.getDiffSize());
            setDiffPath(pathName, imageName);
//            setScreenshotsOnFailure(pathName, imageName);

            return  false;}

    }

    public static void setDiffPath(String pathName, String imageName){
        diffPath = "screenshots"+File.separator+
                "diff"+File.separator+pathName+File.separator+imageName+".png";
    }

    public static String getDiffPath(){
//        Reporter.log(diffPath);
        return diffPath;
    }

    public void screenShotPage(String path, String filename) throws IOException {

        Screenshot screenshot = new
                AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(3000)).
                takeScreenshot(getDriver());
        File actualFile = new File(getProperty("user.dir")
                +File.separator+ "reports"+ File.separator + "screenshots" + File.separator +
                "expected" + File.separator +path+File.separator+filename+".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);
    }

    public boolean pagesComparison(String imageName,
                                   String pathName) throws IOException {


        Screenshot screenshot = new
                AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(5000)).
                takeScreenshot(getDriver());
        File actualFile = new File(getProperty("user.dir")
                +File.separator+ "reports"+ File.separator + "screenshots" + File.separator +
                "actual" + File.separator+pathName+File.separator+imageName+".png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);

        BufferedImage actualImage = ImageIO.read(actualFile);

        File expected = new File(getProperty("user.dir")
                +File.separator+ "reports"+ File.separator + "screenshots" + File.separator +
                "expected" + File.separator + pathName + File.separator + imageName + ".png");

        BufferedImage expectedImage = ImageIO.read(expected);
        ImageDiff diff = new ImageDiffer().makeDiff(actualImage, expectedImage);

        if (diff.getDiffSize()<150){
            Reporter.log("Verifying of '" + imageName+"' block in '" +pathName+"' page successful");
            return true;
        } else {
            String diffFileName = getProperty("user.dir")+File.separator+"reports"+ File.separator +"screenshots"+File.separator+
                    "diff"+File.separator+pathName+File.separator+imageName+".png";
            File diffFile = new File(diffFileName);
            ImageIO.write(diff.getMarkedImage(), "png", diffFile);
            Reporter.log("Verifying of '" + imageName+"' block in '" +pathName+"' page failed, images are different");
            Reporter.log("DiffSize is '" + diff.getDiffSize());
            setDiffPath(pathName, imageName);

            return  false;}

    }
}
