package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase {

    private final By campoUsuarioId;
    private final By campoSenhaId;
    private final By campoConfirmarSenhaId;
    private final By bntCadastrarId;
    private final By mensagemErroId;


    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement bntCadastrar;
    private MobileElement mensagemErro;

    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
        campoUsuarioId = By.xpath("//android.widget.EditText[@text='Nome']");
        campoSenhaId = By.xpath("//android.widget.EditText[@text='Senha']");
        campoConfirmarSenhaId = By.xpath("//android.widget.EditText[@text='Confirmar senha']");
        bntCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        mensagemErroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");

    }

    @Override
    public void BuscarElementos() {

        campoUsuario = (MobileElement) driver.findElement(campoUsuarioId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaId);
        bntCadastrar = (MobileElement) driver.findElement(bntCadastrarId);
    }



    public LoginPageObject Cadastar(String usuario, String senha, String confirmacao) {
        PreencherCampos(usuario, senha, confirmacao);
        bntCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro(){
        var wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(mensagemErroId));
        mensagemErro = (MobileElement) driver.findElement(mensagemErroId);
        return mensagemErro.getText();
    }

    private void PreencherCampos(String usuario, String senha, String confirmacao) {
        campoUsuario.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

}
