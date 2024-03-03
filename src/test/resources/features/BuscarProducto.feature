Feature: Buscar Producto
  Scenario: Buscar Producto de libros para Selenium
    Given ingreso a la pagina web de Linio "https://linio.falabella.com/linio-cl"
    When Ingreso el texto "Libros de Selenium"
    And le doy clic al boton buscar
    Then valido que me muestre el valor "Resultados (290)"

