import PageObjects.ListaProdutosPageObject;
import PageObjects.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FeatureLogin {

    @Test
    public void nao_posso_logar_com_um_usuário_não_cadastrado(){
        var driver = AppiumDriverConfig.Instance().getDriver();
        var paginaLogin = new LoginPageObject(driver);
        paginaLogin.BuscarElementos();
        paginaLogin.Logar("naoCadastrado", "qualquer");

        assertEquals("Usuário ou senha inválidos", paginaLogin.MensagemErro());
    }

    @Test
    public void posso_logar_com_um_usuário_cadastrado() {
        var driver = AppiumDriverConfig.Instance().getDriver();
        var paginaLogin = new LoginPageObject(driver);
        paginaLogin.BuscarElementos();

        var paginaCadastro = paginaLogin.IrParaCadastro();
        paginaCadastro.BuscarElementos();
        paginaLogin = paginaCadastro.Cadastar("usuarionovo", "1234567","1234567");
        paginaLogin.BuscarElementos();
        var paginaProdutos = paginaLogin.Logar("usuarionovo", "1234567");
        Assert.assertTrue(paginaProdutos.TelaCarregada());
    }


    @Test
    public void se_estou_logado_abro_e_fecho_app_devo_ir_para_lista_de_produtos() throws InterruptedException {
        var driver = AppiumDriverConfig.Instance().getDriver();

        driver.closeApp();
        driver.launchApp();
        var paginaProdutos = new ListaProdutosPageObject(driver);
        paginaProdutos.BuscarElementos();
    }
}
