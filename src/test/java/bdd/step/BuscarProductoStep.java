package bdd.step;

import bdd.page.BuscarProductoPage;

public class BuscarProductoStep {

    public BuscarProductoPage buscarProductoPage(){
        return new BuscarProductoPage();
    }

        public void stepiniciarNavegador(String url){
        buscarProductoPage().iniciarNavegador(url);
    }
    public void stephacerClickenBuscar(){
        buscarProductoPage().hacerClickenBuscar();
    }

    public void stepescribirProducto(String txtProducto){
        buscarProductoPage().escribirProducto(txtProducto);
    }

    public void stepclickBucarProducto(){
        buscarProductoPage().clickBucarProducto();
    }

    public String stepvalidarResultado(){
        return buscarProductoPage().validarResultado();
    }
}
