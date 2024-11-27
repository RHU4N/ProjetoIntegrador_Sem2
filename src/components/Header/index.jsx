import * as h from "./styles";

function Header() {
  return (
    <h.header>
      {/* Logo */}
      <h.headerLogo src="../public/LogoCultmap.png" alt="Logo CultMap" />

      {/* Campo de busca e botão de filtro */}
      <h.searchWrapper>
        <h.searchInput type="text" placeholder="Buscar locais culturais..." />
      </h.searchWrapper>

      {/* Botão de perfil */}
      <h.profileButton>
        <img src="../public/perfil.png" alt="Perfil" />
      </h.profileButton>

    </h.header>
  );
}

export default Header;
