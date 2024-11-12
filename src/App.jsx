import { useState } from 'react';
import './App.css';

function App() {
  // States para armazenar o email, senha e a mensagem de erro
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [mensagem, setMensagem] = useState('');
  const [mensagemStyle, setMensagemStyle] = useState('');

  // Email e senha fixos para validação
  const emailValido = "teste@teste.com";
  const senhaValida = "senha123";

  // Função para validar o login
  const validarLogin = (event) => {
    event.preventDefault(); // Previne o envio do formulário padrão

    // Verificar se o email e senha são válidos
    if (email === emailValido && senha === senhaValida) {
      setMensagem("Login bem-sucedido!");
      setMensagemStyle('green');
    } else {
      setMensagem("Email ou senha inválidos!");
      setMensagemStyle('red');
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={validarLogin}>
        <div>
          <input
            type="email"
            placeholder="Email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)} // Atualiza o email no estado
            required
          />
        </div>
        <div>
          <input
            type="password"
            placeholder="Senha"
            id="password"
            value={senha}
            onChange={(e) => setSenha(e.target.value)} // Atualiza a senha no estado
            required
          />
        </div>
        <div>
          <input
            type="submit"
            value="Entrar"
            id="submit"
          />
        </div>
      </form>

      {/* Exibe a mensagem de sucesso ou erro */}
      {mensagem && <div style={{ color: mensagemStyle }}>{mensagem}</div>}
    </div>
  );
}

export default App;
