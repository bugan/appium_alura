package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListaProdutosPageObject extends PageObjectBase {

    private final By barraSuperiorId;
    private final By listaProdutosId;
    private MobileElement barraSuperior;
    private MobileElement listaProdutos;


    public ListaProdutosPageObject(AppiumDriver driver) {
        super(driver);
        barraSuperiorId = By.id("br.com.alura.aluraesporte:id/action_bar");
        listaProdutosId = By.id("br.com.alura.aluraesporte:id/produtos");
    }

    @Override
    public void BuscarElementos() {
        barraSuperior = (MobileElement) driver.findElement(barraSuperiorId);
        listaProdutos = (MobileElement) driver.findElement(listaProdutosId);
    }

    public Boolean TelaCarregada() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(barraSuperiorId));
            wait.until(ExpectedConditions.presenceOfElementLocated(listaProdutosId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
