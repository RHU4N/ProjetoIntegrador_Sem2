import styled from "styled-components";

export const header = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px; /* Ajusta o espaço interno do cabeçalho */
  background-color: var(--primary);
  position: fixed;
  top: 0;
  left: 0;
  z-index: 10;
  height: 70px;

  @media (max-width: 768px) {
    flex-direction: column; /* Empilha os itens em telas pequenas */
    height: auto;
    padding: 15px;
  }
`;

export const headerLogo = styled.img`
  width: 75px;
  height: 75px;

  @media (max-width: 768px) {
    width: 50px;
    height: 50px;
  }
`;

export const searchWrapper = styled.div`
  display: flex;
  align-items: center;
  flex-grow: 1; /* Faz com que o campo de busca ocupe o espaço necessário */
  max-width: 600px; /* Limita a largura total do grupo */
  margin: 0 20px;

  @media (max-width: 768px) {
    margin: 10px 0;
    width: 100%; /* O campo de busca ocupa toda a largura */
  }
`;

export const searchInput = styled.input`
  flex-grow: 1; /* Faz o input expandir conforme o espaço disponível */
  padding: 8px 12px;
  border: 1px solid var(--gray-dark);
  border-radius: 5px;

  @media (max-width: 768px) {
    width: 100%; /* Ocupa toda a largura disponível em telas pequenas */
  }
`;


export const profileButton = styled.div`
  width: 40px;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--white);
  border-radius: 50%;
  cursor: pointer;
  margin-left: 30px; /* Garante alinhamento correto */
  margin-right: 50px; /* Evita que fique muito próximo do canto */

  img {
    width: 30px;
    height: 30px;
  }

  @media (max-width: 768px) {
    margin-right: 10px; /* Ajusta margem para telas pequenas */
  }
`;

