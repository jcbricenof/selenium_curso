import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.lang.InterruptedException;
import static java.lang.Thread.sleep;

public class EjemploSimpleSelenium {
        public static void main(String[] args) throws InterruptedException {

            //Indicar la ubicación de tu controlador de Chrome
            System.setProperty("webdriver.chrome.driver", "D:\\MiPrimerScripWeb\\src\\test\\resources\\webdriver\\chromedriver.exe");

            //Instanciar el controlador de Chrome
            WebDriver driver = new ChromeDriver();

            //Ruta donde se almacena las capturas de pantalla
            String screenshotDir = "D:\\MiPrimerScripWeb\\src\\test\\resources\\evidencias";

            //Abre url en el navegador
            driver.get("https://linio.falabella.com/linio-cl");

            //Maximizar el navegador
            driver.manage().window().maximize();

            //Realiza acciones y toma captura de pantalla
            takeScreenshot(driver, screenshotDir, "screenshot-1.png");

            //Espera un momento para que puedas ver que se ha abierto el navegador

                try {
                        sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

            //Forma de buscar y almacenar los elementos Web de una página.
            WebElement txtBuscar = driver.findElement(By.id("testId-SearchBar-Input")); //Para validar el ID ctrl+F pegar //*[@id='testId-SearchBar-Input'] por class //*[@class='id a buscar']
            WebElement btnBuscar = driver.findElement(By.className("SearchBar-module_searchBtnIcon__2L2s0"));

            //Automatizando la página web de Amazon
            //Usando la acción click
            //Paso 1 hacer click en la caja de texto para buscar
            txtBuscar.click();
            sleep(5000);

            //Paso 2 escribir el texto a buscar
            txtBuscar.sendKeys("laptop gamer");
            takeScreenshot(driver, screenshotDir, "screenshot-2.png");
            sleep(5000);

            //Paso 3 hacer click en el botón de búsqueda (imagen de lupa)
            btnBuscar.click();
            sleep(5000);

            //Buscar un texto y almacenar el valor de la página web (resultados)
            WebElement lblResultado = driver.findElement(By.id("testId-SearchLandingContainer-totalResults"));
            String resultado = lblResultado.getText();
            String resultadoEsperado = "Resultados (292)";

            //Validación de resultado esperado vs resultado encontrado
            Assertions.assertEquals(resultadoEsperado, resultado);
            takeScreenshot(driver, screenshotDir, "screenshot-3.png");
            System.out.println(resultado);
            sleep(5000);

            //Cerrar el navegador
            sleep(5000);
            driver.quit();

        }

        public static void takeScreenshot(WebDriver driver, String screenshotDir, String fileName) {
            //Toma la captura de pantalla de la página web
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //Define la ruta de almacenamiento de la imagen
            String destinationPath = screenshotDir + fileName;

            //Copiar el archivo a la ruta de almacenamiento
            try {
                FileUtils.copyFile(screenshotFile, new  File(destinationPath));
                System.out.println("Captura de la imagen exitosa");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al copiar la imagen");
                throw new RuntimeException(e);

            }
        }

    }
