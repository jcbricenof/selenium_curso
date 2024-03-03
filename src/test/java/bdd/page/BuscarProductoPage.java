package bdd.page;

import bdd.webdriver.DOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.className;

public class BuscarProductoPage extends DOM {

    @FindBy(id = "testId-SearchBar-Input")
    protected WebElement txtBuscar;

    @FindBy(className = "SearchBar-module_searchBtnIcon__2L2s0")
    WebElement btnBuscar;

    @FindBy(id = "testId-SearchLandingContainer-totalResults")
    WebElement resultadoObtenido;

    public void hacerClickenBuscar(){
        onclick(txtBuscar);
    }

    public void iniciarNavegador(String url){
        iniciarNavegdor(url);
    }

    public void escribirProducto(String txtProducto){
        type(txtBuscar, txtProducto);
    }

    public void clickBucarProducto(){
        onclick(btnBuscar);
    }

    public String validarResultado(){
        return getText(resultadoObtenido);
    }

}
