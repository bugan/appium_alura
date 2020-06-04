import PageObjects.LoginPageObject;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class FeatureCadastro {
    @Test
    public void posso_cadastrar_novo_usuario() throws NoSuchElementException {
        var driver = AppiumDriverConfig.Instance().getDriver();
        var paginaLogin = new LoginPageObject(driver);
        paginaLogin.BuscarElementos();
        var paginaCadastro = paginaLogin.IrParaCadastro();
        paginaCadastro.BuscarElementos();
        paginaLogin = paginaCadastro.Cadastar("Bugan", "123", "123");
        paginaLogin.BuscarElementos();

    }

    @Test
    public void nao_posso_cadastrar_o_mesmo_usuario_duas_vezes() {
        var driver = AppiumDriverConfig.Instance().getDriver();
        var paginaLogin = new LoginPageObject(driver);
        paginaLogin.BuscarElementos();
        var paginaCadastro = paginaLogin.IrParaCadastro();
        paginaCadastro.BuscarElementos();

        paginaLogin = paginaCadastro.Cadastar("TesteDuplicado", "123", "123");
        paginaLogin.BuscarElementos();
        paginaLogin.IrParaCadastro();
        paginaCadastro.Cadastar("TesteDuplicado", "123", "123");
        assertEquals("Usuario já Cadastrado", paginaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void nao_posso_cadastrar_um_usuario_com_senhas_que_nao_conferem() {
        var driver = AppiumDriverConfig.Instance().getDriver();
        var paginaLogin = new LoginPageObject(driver);
        paginaLogin.BuscarElementos();
        var paginaCadastro = paginaLogin.IrParaCadastro();
        paginaCadastro.BuscarElementos();
        paginaCadastro.Cadastar("TesteConferenciaSenhas", "123", "1234");
        assertEquals("Senhas não conferem", paginaCadastro.MensagemErro());
        driver.navigate().back();
    }
}
