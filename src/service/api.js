import SignupModal from "../components/cadastro";
const handleSubmit = (e) => {
    e.preventDefault();
    // Monta o JSON de envio com base no tipo de conta
    const jsonData = formData.tipo === "a" ? {
      nome: formData.nome,
      email: formData.email,
      senha: formData.senha,
      tipo: formData.tipo,
      ddd: formData.ddd,
      numero: formData.numero,
      cnpj: formData.cnpj
    } : {
      nome: formData.nome,
      email: formData.email,
      senha: formData.senha,
      tipo: formData.tipo,
      ddd: formData.ddd,
      numero: formData.numero,
      cpf: formData.cpf,
      dtNascimento: formData.dtNascimento
    };
  
    // Envia o JSON para a API
    onSignup(jsonData);
    onClose(); // Fecha o modal
  };
  