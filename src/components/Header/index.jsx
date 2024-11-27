import * as h from "./styles";
import LoginModal from "../Login";
import { useState } from "react";

function Header() {
  const [isLoginVisible, setLoginVisible] = useState(false); // Estado para controlar o modal

  return (
    <>
      <h.header>
        {/* Logo */}
        <h.headerLogo src="../public/LogoCultmap.png" alt="Logo CultMap" />

        {/* Campo de busca e botão de filtro */}
        <h.searchWrapper>
          <h.searchInput type="text" placeholder="Buscar locais culturais..." />
        </h.searchWrapper>

        {/* Botão de perfil com ação para abrir o modal */}
        <h.profileButton onClick={() => setLoginVisible(true)}>
          <img src="../public/perfil.png" alt="Perfil" />
        </h.profileButton>
      </h.header>

      {/* Modal de Login */}
      <LoginModal
        isVisible={isLoginVisible}
        onClose={() => setLoginVisible(false)}
        onLogin={(credentials) => console.log("Login realizado:", credentials)}
      />
    </>
  );
}

export default Header;
