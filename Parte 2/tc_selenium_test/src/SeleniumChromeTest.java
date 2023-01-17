import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumChromeTest {

    public static void tituloEsperado(String titulo, String esperado) {
        if (titulo.compareTo(esperado) == 0) {
            System.out.println("O titulo da pagina é " + titulo);
        } else {
            System.out.println("Titulo nao esperado");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        String url = "http://localhost:63342/tc_selenium_test/TC1_Imobiliaria_Web/index.html?_ijt=qlvis996j7gdt718hdbkvsjfcg&_ij_reload=RELOAD_ON_SAVE"; // TODO -> prencher com a URL desejada
        String titulo;
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath+"/lib/chrome/chromedriver");

//        Abrindo o google
        WebDriver driver = new ChromeDriver(capability);
        driver.get(url);
        driver.manage().window();

//        Pega titulo da página
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Curso");

//        Preenchendo página de Cadastro de professores
        Thread.sleep(5000);
        driver.findElement(By.linkText("Professores")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Cadastrar Professores"); // Verificando se é o titulo esperado
        driver.findElement(By.name("nome")).sendKeys("Natalia");
        driver.findElement(By.name("uf")).sendKeys("UFMG");
        driver.findElement(By.name("rf")).sendKeys("050.962.560-65");
        driver.findElement(By.name("data_nasc")).sendKeys("10/09/1990");
        WebElement webElement = driver.findElement(By.id("female"));
        if (webElement.isEnabled()) System.out.println("Radio Sexo Ativado"); //Está ativo
        if (webElement.isDisplayed()) System.out.println("Radio Sexo em Exibiçao"); //Está em exibição
        if (webElement.isSelected()) {System.out.println("Radio Sexo Selecionado");} else {System.out.println("não selecionado");} //Está selecionado
        webElement.click(); //Click no Feminino
        if (webElement.isSelected()) {System.out.println("Radio Sexo Selecionado");} else {System.out.println("não selecionado");} // Verifica se foi selecionado
        driver.findElement(By.name("areaP")).sendKeys("Nutrição");
        driver.findElement(By.name("telefone")).sendKeys("(81) 92345-6781");
        driver.findElement(By.name("email")).sendKeys("nat.nutri@gmail.com");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Cadastro ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Cadastro em Exibiçao");

//        Página de Alterar
        Thread.sleep(5000);
        driver.findElement(By.linkText("Alterar")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Alterar Professor");// Verificando se é o titulo esperado
        driver.findElement(By.name("rf")).sendKeys("050.962.560-65");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar em Exibiçao");

// Página de Listar um
        Thread.sleep(5000);
        driver.findElement(By.linkText("Listar Um")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Listar Professor"); // Verificando se é o titulo esperado
        driver.findElement(By.name("rf")).sendKeys("050.962.560-65");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar Exibiçao");

//   Página de Listar todos
        Thread.sleep(5000);
        driver.findElement(By.linkText("Listar Todos")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Listar Todos os Professores"); // Verificando se é o titulo esperado

// Página de Excluir
        Thread.sleep(5000);
        driver.findElement(By.linkText("Excluir")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Excluir Professor"); // Verificando se é o titulo esperado
        driver.findElement(By.name("rf")).sendKeys("050.962.560-65");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar em Exibiçao");

//        Voltar pra página de curso
        Thread.sleep(5000);
        driver.findElement(By.linkText("Professores")).click();
        titulo= driver.getTitle();
        tituloEsperado(titulo, "Curso"); // Verificando se é o titulo esperado

//        Prenchendo página de Disciplina
        Thread.sleep(5000);
        driver.findElement(By.linkText("Disciplinas")).click();
        titulo= driver.getTitle();
        tituloEsperado(titulo, "Cadastrar Disciplina"); // Verificando se é o titulo esperado
        driver.findElement(By.name("sigla")).sendKeys("TC1S5");
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys("Tópicos da computação");
        driver.findElement(By.name("ementa")).sendKeys("Casos de Teste");
        driver.findElement(By.name("lBibli")).sendKeys("Desconhecida");
        Select select = new Select(driver.findElement(By.name("nCred")));
        List<WebElement> optionList = select.getOptions();
        optionList.forEach(System.out::println);
        select.selectByValue("3");
        driver.findElement(By.name("ch")).sendKeys("50:00");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Cadastro ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Cadastro em Exibiçao");

//        Prenchendo página de Alterar Disciplina
        Thread.sleep(5000);
        driver.findElement(By.linkText("Alterar")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Alterar Disciplina"); // Verificando se é o titulo esperado
        driver.findElement(By.name("sigla")).sendKeys("TC1S5");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar em Exibiçao");

//        Prenchendo página de listar um
        Thread.sleep(5000);
        driver.findElement(By.linkText("Listar Um")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Listar Disciplina");  // Verificando se é o titulo esperado
        driver.findElement(By.name("sigla")).sendKeys("TC1S5");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar Exibiçao");

        //    Página de listar todos
        Thread.sleep(5000);
        driver.findElement(By.linkText("Listar Todos")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Listar Todas as Disciplinas");  // Verificando se é o titulo esperado

//        Página de Excluir
        Thread.sleep(5000);
        driver.findElement(By.linkText("Excluir")).click();
        titulo = driver.getTitle();
        tituloEsperado(titulo, "Excluir Disciplina"); // Verificando se é o titulo esperado
        driver.findElement(By.name("sigla")).sendKeys("TC1S5");
        webElement = driver.findElement(By.id("enviar"));
        if (webElement.isEnabled()) System.out.println("Botao Buscar ativado");
        if (webElement.isDisplayed()) System.out.println("Botao Buscar em Exibiçao");

//        Indo e voltando de página
        System.out.println("Titulo: " + driver.getTitle());
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println("Titulo: " + driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Titulo: " + driver.getTitle());

        Thread.sleep(10000);
        driver.close();


    }
}
