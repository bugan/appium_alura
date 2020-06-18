package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase {

    private final By campoUsuarioId;
    private final By campoSenhaId;
    private final By btnLogarId;
    private final By btnIrCadastrarId;
    private final By mensagemErroId;

    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement btnLogar;
    private MobileElement btnIrCadastrar;
    private MobileElement mensagemErro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        campoUsuarioId =  By.id("br.com.alura.aluraesporte:id/input_usuario");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        btnIrCadastrarId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        btnLogarId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        mensagemErroId = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
    }

    @Override
    public void BuscarElementos() {
        campoUsuario = (MobileElement) driver.findElement(campoUsuarioId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        btnLogar = (MobileElement) driver.findElement(btnLogarId);
        btnIrCadastrar = (MobileElement) driver.findElement(btnIrCadastrarId);
    }

    public ListaProdutosPageObject Logar(String usuario, String senha){
        campoUsuario.setValue(usuario);
        campoSenha.setValue(senha);
        btnLogar.click();
        return new ListaProdutosPageObject(this.driver);
    }

    public CadastroPageObject IrParaCadastro(){
        btnIrCadastrar.click();
        return  new CadastroPageObject(driver);
    }

    public String MensagemErro(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(mensagemErroId));

        mensagemErro = (MobileElement) driver.findElement(mensagemErroId);
        return mensagemErro.getText();
    }

}
