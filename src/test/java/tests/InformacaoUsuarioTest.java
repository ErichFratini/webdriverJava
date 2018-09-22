/** Esse projeto é fruto do curso de Selenium WebDriver em Java do Julio de Lima.*/
package tests;
//todos os imports necessarios para o bom funcionamento dos scripts esãto aqui consequentemente nas outras classes tambem
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Screenshot;
import suporte.Web;
import suporte.generator;

import static junit.framework.TestCase.assertEquals;
// os @ ababaixo servem para conseguirmos importar um arquivo .csv com as informações a ser testadas
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacaoUsuarioTest.csv")

public class InformacaoUsuarioTest {
	//aqui instaciamos uma variavel do tipo WebDriver com nome de navegador, o tipo web driver é importado das bibliotecas selenium, ele é o que faz basicamente todo o processo de percorrer a tela, buscar elementos, clicar em botoes, ele detem essas funções.
	private WebDriver navegador;
	@Rule
	public TestName test = new TestName();
	//O @Before é responsavel por executar alguma função ou fazer uma preparação antes do teste de fato ser rodado
	@Before
	public void setUp(){
		//Aqui chamamos a variavel navegador que é do tipo WebDriver e instaciamos a clsse create chrome, para visualizar os codigos contido na classe, clique sobre ela e aperte f3
		navegador = Web.createChrome();
		
		//Clicar no link que o texto sign in
		/**WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();
		*/
		//Podemos usar os dois, mas como queremos um codigo limpo, utilizaremos essa função nao comentada abaixo
		//como o navegador ja está aberto(instaciado)utilizamos a função findElement que tem como parametro um pelo (By.) seguido de um click(evento de click)
		navegador.findElement(By.linkText("Sign in")).click();
		//Obs. para char tal elemento é necesario inspecionar a pagina no qual voce quer testar e procurar por tal, procure por id's, names que sejam unicos, caracteristicas que sejam unicos do elemento que quer testar
		//não da pra explicar muito via comentario porem existem aulas no youtube e foruns sobre esses scripts, garanto que com uma pesquisa voce pode entendermelhor sobre o que eu disse
		
		//logo apos clicar nesse kintTExt sign in é aberto um formulario, então criamos uma variavel para ela, ja que vamos fazer mais funcoes dentro dela, esse formulario esta contido dentro do navegador e ele tem um id, ou seja é unico e é chamado por signbox
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		
		//ainda dentro do formulario procuramos pelo nome da tag name e usamos a função sendkeys que digita no campo o especificado
		//Digitar no campo com name "login" que esta dentro do formulario de id "signinbox" o texto "julio0001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		
		//Digitar no campo com name "password" que esta dentro do formulario de id "signinbox" o texto "123456"	
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		//Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		/**
		 *
		 *Validar que dentro elemento com class "me" possui o texto "Hi,Julio"
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementome = me.getText();
		assertEquals("Hi, Julio",textoNoElementome);
		*/
		//clicar em um link que possui a class me
		navegador.findElement(By.className("me")).click();
		
		//clicar em um link que possu um texo MORE DATA ABOUT YOU
		navegador .findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}
	@Test
	public void testAdicionarUmaInformacaoDoUsuario(@Param(name ="tipo")String tipo,@Param(name ="contato") String contato,@Param(name ="mensagem")String mensagemEsperada) {

		//clicar no botão +ADD MORE DATA atravez do xpath
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		//idetntificar o popup de formulario com id addmoredata
		WebElement addMoreData = navegador.findElement(By.id("addmoredata"));
		
		//na combo box de nome type escolher a opção phone
		WebElement campoType =addMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		
		//colocar no campo de name contact digitar o telefone +5511999991111
		addMoreData.findElement(By.name("contact")).sendKeys(contato);
		
		//clicar no link de text "save" que esta no pop up
		addMoreData.findElement(By.linkText("SAVE")).click();
		
		//na mensgem de id"toast-container"vailidar que o texto é "Your contact has been added"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals(mensagemEsperada, mensagem);
	}
	//@Test
	public void removeroContatoDeUmUsuario() {
		//clicar no elemento pelo seu xpath //span[text()="+5511444443333"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+5511999991111\"]/following-sibling::a")).click();
		
		//confirmar a janela javascript
		navegador.switchTo().alert().accept();
		
		//validar que a exclusao foi feita pelo Rest in peace, dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
		String screenshotArquivo = "C:\\Users\\Inmetrics\\Desktop\\webdriverJava\\Evidencias\\" + generator.dataHoraParaArquivo() + test.getMethodName()+".png";
		Screenshot.tirar(navegador,screenshotArquivo);
		
		//aguardar 10 segundoa te que a janela deapareça
		WebDriverWait aguardar = new WebDriverWait(navegador,10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		//clicar nolink co texto logout
		navegador.findElement(By.linkText("Logout")).click();
		
	}
	@After
	public void tearDown() {
		//Fechar o navegador
		//navegador.quit();	
	}
}
