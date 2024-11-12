import { Builder, By, until } from 'selenium-webdriver';
import { Options } from 'selenium-webdriver/chrome';

// Criar uma nova instância do driver do Chrome
const driver = new Builder()
  .forBrowser('chrome')
  .setChromeOptions(new Options().headless())  // rodar o teste sem abrir o navegador
  .build();

// URL da sua aplicação React (certifique-se de que o Vite esteja rodando)
const url = 'http://localhost:5173';

// Função para testar o login
async function testarLogin() {
  try {
    // Acessar a página da aplicação
    await driver.get(url);

    // Preencher o campo de email
    const emailField = await driver.findElement(By.id('email'));
    await emailField.sendKeys('teste@teste.com');

    // Preencher o campo de senha
    const passwordField = await driver.findElement(By.id('password'));
    await passwordField.sendKeys('senha123');

    // Clicar no botão de submit
    const submitButton = await driver.findElement(By.id('submit'));
    await submitButton.click();

    // Esperar pela mensagem de sucesso ou erro
    const messageDiv = await driver.wait(until.elementLocated(By.css('div')), 5000);

    // Verificar se a mensagem contém o texto esperado
    const messageText = await messageDiv.getText();
    if (messageText === "Login bem-sucedido!") {
      console.log("Test Passed: Login bem-sucedido!");
    } else if (messageText === "Email ou senha inválidos!") {
      console.log("Test Failed: Email ou senha inválidos.");
    } else {
      console.log("Test Failed: Mensagem desconhecida.");
    }

  } catch (error) {
    console.error('Erro durante o teste:', error);
  } finally {
    // Fechar o navegador
    await driver.quit();
  }
}

// Rodar o teste de login
testarLogin();
