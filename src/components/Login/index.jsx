import { useState } from "react";
import PropTypes from "prop-types";
import styles from "./styles"; // Importando os estilos

const LoginModal = ({ isVisible, onClose, onLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    onLogin({ email, password });
    onClose(); // Fecha o modal após o login
  };

  if (!isVisible) return null; // Não renderiza o modal se ele não estiver visível

  return (
    <div style={styles.overlay}>
      <div style={styles.modal}>
        <h2 style={styles.title}>Login</h2>
        <form onSubmit={handleSubmit} style={styles.form}>
          <div style={styles.inputGroup}>
            <label htmlFor="email" style={styles.label}>
              Email
            </label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Digite seu email"
              required
              style={styles.input}
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="password" style={styles.label}>
              Senha
            </label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Digite sua senha"
              required
              style={styles.input}
            />
          </div>
          <button type="submit" style={styles.button}>
            Entrar
          </button>
          <button type="button" onClick={onClose} style={styles.closeButton}>
            Fechar
          </button>
        </form>
      </div>
    </div>
  );
};
LoginModal.propTypes = {
  isVisible: PropTypes.bool.isRequired,
  onClose: PropTypes.func.isRequired,
  onLogin: PropTypes.func.isRequired,
};

export default LoginModal;

