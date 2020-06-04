package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObjectBase {

    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement btnLogar;
    private MobileElement bntIrCadastrar;
    private MobileElement mensagemErro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void BuscarElementos() {
        campoUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        btnLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        bntIrCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    public ListaProdutosPageObject Logar(String usuario, String senha){
        campoUsuario.setValue(usuario);
        campoSenha.setValue(senha);
        btnLogar.click();
        return new ListaProdutosPageObject(driver);
    }

    public CadastroPageObject IrParaCadastro(){
        bntIrCadastrar.click();
        return  new CadastroPageObject(driver);
    }

    public String MensagemErro(){
        mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/mensagem_erro_login");
        return mensagemErro.getText();
    }

}
