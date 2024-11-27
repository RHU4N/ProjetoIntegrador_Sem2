import React, { useState } from "react";
import styles from "./styles"; // Estilos atualizados
import SignupModal from "../cadastro";

const LoginModal = ({ isVisible, onClose, onLogin, onSignup }) => {
  const [isSignupVisible, setSignupVisible] = useState(false); // Estado para controlar o modal

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
 
  const handleSubmit = (e) => {
    e.preventDefault();
    onLogin({ email, password });
    onClose();
  };

  if (!isVisible) return null;

  return (
    <div style={styles.overlay}>
      <div style={styles.modal}>
        <h2 style={styles.title}>Bem-vindo de volta!</h2>
        <p style={styles.subtitle}>Por favor, faça login para continuar</p>
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
          <div style={styles.buttonGroup}>
            <button type="submit" style={styles.button}>
              Entrar
            </button>
            <button
              type="button"
              onClick={() => setSignupVisible(true)} // Corrigido para setSignupVisible
              style={styles.signupButton}
            >
              Cadastrar
            </button>
          </div>
          <button type="button" onClick={onClose} style={styles.closeButton}>
            Fechar
          </button>
        </form>
        <SignupModal
          isVisible={isSignupVisible}
          onClose={() => setSignupVisible(false)}
        />
      </div>
    </div>
  );
};

export default LoginModal;
