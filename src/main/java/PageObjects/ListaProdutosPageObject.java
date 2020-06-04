package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ListaProdutosPageObject extends PageObjectBase {

    private MobileElement barraSuperior;
    private MobileElement listaProdutos;
    public ListaProdutosPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void BuscarElementos() {
        barraSuperior = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/action_bar");
        listaProdutos = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/produtos");
    }


}
