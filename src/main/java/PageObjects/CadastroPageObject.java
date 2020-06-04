package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CadastroPageObject extends PageObjectBase {

    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement bntCadastrar;
    private MobileElement mensagemErro;

    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void BuscarElementos() {
        campoUsuario = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']"));
        campoSenha = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Senha']"));
        campoConfirmarSenha = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@text='Confirmar senha']"));
        bntCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public LoginPageObject Cadastar(String usuario, String senha, String confirmacao) {
        PreencherCampos(usuario, senha, confirmacao);
        bntCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro(){
        mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        return mensagemErro.getText();
    }

    private void PreencherCampos(String usuario, String senha, String confirmacao) {
        campoUsuario.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

}
