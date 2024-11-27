import React, { useState } from "react";
import styles from "./styles";

const SignupModal = ({ isVisible, onClose, onSignup }) => {
  const [formData, setFormData] = useState({
    nome: "",
    email: "",
    senha: "",
    tipo: "u", // "u" para usuário, "a" para anunciante
    ddd: "",
    numero: "",
    cnpj: "",
    cpf: "",
    dtNascimento: "",
  });

  // Atualiza os campos do formulário
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  // Envia os dados do formulário
  const handleSubmit = (e) => {
    e.preventDefault();
    onSignup(formData); // Chama a função onSignup passada como prop
    onClose(); // Fecha o modal
  };

  if (!isVisible) return null;

  return (
    <div style={styles.overlay}>
      <div style={styles.modal}>
        <h2 style={styles.title}>Crie sua conta</h2>
        <form onSubmit={handleSubmit} style={styles.form}>
          <div style={styles.inputGroup}>
            <label htmlFor="nome" style={styles.label}>Nome</label>
            <input
              type="text"
              id="nome"
              name="nome"
              value={formData.nome}
              onChange={handleChange}
              required
              style={styles.input}
              placeholder="Seu nome"
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="email" style={styles.label}>Email</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
              style={styles.input}
              placeholder="Seu email"
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="senha" style={styles.label}>Senha</label>
            <input
              type="password"
              id="senha"
              name="senha"
              value={formData.senha}
              onChange={handleChange}
              required
              style={styles.input}
              placeholder="Sua senha"
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="tipo" style={styles.label}>Tipo de Conta</label>
            <select
              id="tipo"
              name="tipo"
              value={formData.tipo}
              onChange={handleChange}
              style={styles.input}
            >
              <option value="u">Usuário</option>
              <option value="a">Anunciante</option>
            </select>
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="ddd" style={styles.label}>DDD</label>
            <input
              type="text"
              id="ddd"
              name="ddd"
              value={formData.ddd}
              onChange={handleChange}
              required
              style={styles.input}
              placeholder="DDD"
            />
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="numero" style={styles.label}>Número</label>
            <input
              type="text"
              id="numero"
              name="numero"
              value={formData.numero}
              onChange={handleChange}
              required
              style={styles.input}
              placeholder="Número de telefone"
            />
          </div>
          {formData.tipo === "a" ? (
            <div style={styles.inputGroup}>
              <label htmlFor="cnpj" style={styles.label}>CNPJ</label>
              <input
                type="text"
                id="cnpj"
                name="cnpj"
                value={formData.cnpj}
                onChange={handleChange}
                required
                style={styles.input}
                placeholder="CNPJ"
              />
            </div>
          ) : (
            <>
              <div style={styles.inputGroup}>
                <label htmlFor="cpf" style={styles.label}>CPF</label>
                <input
                  type="text"
                  id="cpf"
                  name="cpf"
                  value={formData.cpf}
                  onChange={handleChange}
                  required
                  style={styles.input}
                  placeholder="CPF"
                />
              </div>
              <div style={styles.inputGroup}>
                <label htmlFor="dtNascimento" style={styles.label}>
                  Data de Nascimento
                </label>
                <input
                  type="date"
                  id="dtNascimento"
                  name="dtNascimento"
                  value={formData.dtNascimento}
                  onChange={handleChange}
                  required
                  style={styles.input}
                />
              </div>
            </>
          )}
          <button type="submit" style={styles.button}>
            Cadastrar
          </button>
          <button type="button" onClick={onClose} style={styles.closeButton}>
            Fechar
          </button>
        </form>
      </div>
    </div>
  );
};

export default SignupModal;

