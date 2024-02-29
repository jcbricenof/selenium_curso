import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.InterruptedException;
import java.lang.Exception;

public class EjemploSimpleSelenium {
        public static void main(String[] args) {

            //Indicar la ubicación de tu controlador de Chrome
            System.setProperty("webdriver.chrome.driver", "D:\\MiPrimerScripWeb\\src\\test\\resources\\webdriver\\chromedriver.exe");

            //Instanciar el controlador de Chrome
            WebDriver driver = new ChromeDriver();

            //Abre url en el navegador
            driver.get("https://www.amazon.com");

            //Maximizar el navegador
            driver.manage().window().maximize();

            //Espera un momento para que puedas ver que se ha abierto el navegador

                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

            //Forma de buscar y almacenar los elementos Web de una página.
            WebElement txtBuscar = driver.findElement(By.id("twotabsearchtextbox")); //Para validar el ID ctrl+F pegar //*[@id='id a buscar'] por class //*[@class='id a buscar']
            WebElement btnBuscar = driver.findElement(By.id("nav-search-submit-button"));

            //Automatizando la página web de Amazon
            //Usando la acción click
            //Paso 1 hacer click en la caja de texto para buscar
            txtBuscar.click();

            //Paso 2 escribir el texto a buscar

            //Paso 3 hacer click en el botón de búsqueda (imagen de lupa)

            //Cerrar el navegador
            driver.quit();

        }

    }
