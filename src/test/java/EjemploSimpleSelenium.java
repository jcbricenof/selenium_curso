import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.InterruptedException;
import static java.lang.Thread.sleep;

public class EjemploSimpleSelenium {
        public static void main(String[] args) throws InterruptedException {

            //Indicar la ubicación de tu controlador de Chrome
            System.setProperty("webdriver.chrome.driver", "D:\\MiPrimerScripWeb\\src\\test\\resources\\webdriver\\chromedriver.exe");

            //Instanciar el controlador de Chrome
            WebDriver driver = new ChromeDriver();

            //Abre url en el navegador
            driver.get("https://linio.falabella.com/linio-cl");

            //Maximizar el navegador
            driver.manage().window().maximize();

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
            txtBuscar.sendKeys("Libro de Selenium en español");
            sleep(5000);

            //Paso 3 hacer click en el botón de búsqueda (imagen de lupa)
            btnBuscar.click();
            sleep(5000);

            //Cerrar el navegador
            sleep(5000);
            driver.quit();

        }

    }
