package bdd.stepdefinition;

import bdd.step.BuscarProductoStep;
import bdd.webdriver.DOM;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;

public class BuscarProductoStepDefinition {

    private BuscarProductoStep buscarProductoStep;
    private DOM dom;
    private Scenario scenario;
    @Before
    private void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    @After
    public void afterScenario() {
        dom.quitDriver();
    }

    @Given("ingreso a la pagina web de Linio {string}")
    public void ingresoALaPaginaWebDeLinio(String url) {
        buscarProductoStep.stepiniciarNavegador(url);
    }

    @When("Ingreso el texto {string}")
    public void ingresoElTexto(String txtProducto) {
        buscarProductoStep.stephacerClickenBuscar();
        buscarProductoStep.stepescribirProducto(txtProducto);
    }

    @And("le doy clic al boton buscar")
    public void leDoyClicAlBotonBuscar() {
        buscarProductoStep.stepclickBucarProducto();
    }

    @Then("valido que me muestre el valor {string}")
    public void validoQueMeMuestreElValor(String txtResultadoEsperado) {
        Assertions.assertEquals(txtResultadoEsperado, buscarProductoStep.stepvalidarResultado());
    }
}
