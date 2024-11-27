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

  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleMask = (e) => {
    const { name, value } = e.target;

    if (name === "cpf" || name === "cnpj") {
      // Adicionando máscara para CPF e CNPJ
      e.target.value = value.replace(/\D/g, "");
      if (name === "cpf" && value.length > 3 && value.length <= 6) {
        e.target.value = value.replace(/(\d{3})(\d{1,3})/, "$1.$2");
      } else if (name === "cpf" && value.length > 6 && value.length <= 9) {
        e.target.value = value.replace(/(\d{3})(\d{3})(\d{1,3})/, "$1.$2.$3");
      } else if (name === "cnpj" && value.length > 2 && value.length <= 5) {
        e.target.value = value.replace(/(\d{2})(\d{1,3})/, "$1.$2");
      }
    }

    // Máscara de DDD e número de telefone
    if (name === "ddd") {
      e.target.value = value.replace(/\D/g, "");
    }
    if (name === "numero") {
      e.target.value = value.replace(/\D/g, "");
    }

    handleChange(e);
  };

  const validateForm = () => {
    let formErrors = {};
    if (!formData.nome) formErrors.nome = "Nome é obrigatório";
    if (!formData.email) formErrors.email = "Email é obrigatório";
    if (!formData.senha) formErrors.senha = "Senha é obrigatória";
    if (formData.tipo === "u" && !formData.cpf) formErrors.cpf = "CPF é obrigatório";
    if (formData.tipo === "a" && !formData.cnpj) formErrors.cnpj = "CNPJ é obrigatório";
    if (!formData.ddd) formErrors.ddd = "DDD é obrigatório";
    if (!formData.numero) formErrors.numero = "Número é obrigatório";
    return formErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formErrors = validateForm();
    setErrors(formErrors);

    if (Object.keys(formErrors).length === 0) {
      setLoading(true);
      onSignup(formData);
      setLoading(false);
      onClose();
    }
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
            {errors.nome && <span style={styles.error}>{errors.nome}</span>}
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
            {errors.email && <span style={styles.error}>{errors.email}</span>}
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
            {errors.senha && <span style={styles.error}>{errors.senha}</span>}
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
              onChange={handleMask}
              required
              style={styles.input}
              placeholder="DDD"
            />
            {errors.ddd && <span style={styles.error}>{errors.ddd}</span>}
          </div>
          <div style={styles.inputGroup}>
            <label htmlFor="numero" style={styles.label}>Número</label>
            <input
              type="text"
              id="numero"
              name="numero"
              value={formData.numero}
              onChange={handleMask}
              required
              style={styles.input}
              placeholder="Número de telefone"
            />
            {errors.numero && <span style={styles.error}>{errors.numero}</span>}
          </div>
          {formData.tipo === "a" ? (
            <div style={styles.inputGroup}>
              <label htmlFor="cnpj" style={styles.label}>CNPJ</label>
              <input
                type="text"
                id="cnpj"
                name="cnpj"
                value={formData.cnpj}
                onChange={handleMask}
                required
                style={styles.input}
                placeholder="CNPJ"
              />
              {errors.cnpj && <span style={styles.error}>{errors.cnpj}</span>}
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
                  onChange={handleMask}
                  required
                  style={styles.input}
                  placeholder="CPF"
                />
                {errors.cpf && <span style={styles.error}>{errors.cpf}</span>}
              </div>
              <div style={styles.inputGroup}>
                <label htmlFor="dtNascimento" style={styles.label}>Data de Nascimento</label>
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
          <button type="submit" style={styles.button} disabled={loading}>
            {loading ? "Cadastrando..." : "Cadastrar"}
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
