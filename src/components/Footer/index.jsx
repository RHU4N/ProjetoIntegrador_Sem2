import * as f from "./styles";
import PropTypes from 'prop-types';

function Footer({ profileType }) {
  // Configuração dos botões com base no tipo de perfil
  const buttons = profileType === "anunciante"
    ? [
        { text: "Meus Eventos", path: "./pages/Meus Eventos" },
        { text: "Home", path: "/" },
        { text: "Adicionar", path: "./pages/Adicionar" },
      ]
    : [
        { text: "Eventos", path: "./pages/Eventos" },
        { text: "Home", path: "/" },
        { text: "Explorar", path: "./pages/Explorar" },
      ];

  return (
    <f.footer>
      {buttons.map((button, index) => (
        <f.footerButton key={index} onClick={() => (window.location.href = button.path)}>
          {button.text}
        </f.footerButton>
      ))}
    </f.footer>
  );
}
Footer.propTypes = {
  profileType: PropTypes.string.isRequired,
};

export default Footer;
