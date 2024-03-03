package bdd.webdriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class DOM {

    static String screenshotDir = "D:\\MiPrimerScripWeb\\src\\test\\resources\\evidencias";


    public static WebDriver WebDriver () {
        System.setProperty("webdriver.chrome.driver", "D:\\MiPrimerScripWeb\\src\\test\\resources\\webdriver\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        return driver;
    }

    public static void iniciarNavegdor(String url){
        WebDriver().get("");
        WebDriver().manage().window().maximize();
    }

    public static void takeScreenshot(String fileName) {
        //Toma la captura de pantalla de la página web
        File screenshotFile = ((TakesScreenshot)WebDriver()).getScreenshotAs(OutputType.FILE);
        //Define la ruta de almacenamiento de la imagen
        String destinationPath = screenshotDir + fileName + ".png";

        //Copiar el archivo a la ruta de almacenamiento
        try {
            FileUtils.copyFile(screenshotFile, new  File(destinationPath));
            System.out.println("Captura de la imagen exitosa");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al copiar la imagen");
            throw new RuntimeException(e);

        }
    }

    public void onclick(WebElement element){
        element.click();
    }

    public void type(WebElement element, String texto){
        element.sendKeys(texto);
    }

    public String getText(WebElement element){

        return element.getText();
    }

    public void quitDriver() {
        WebDriver().quit();
    }

}
