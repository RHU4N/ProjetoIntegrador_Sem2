import * as f from "./styles";
import PropTypes from 'prop-types';

function Footer({ profileType, onPageChange }) {
  // Configuração dos botões com base no tipo de perfil
  const buttons = profileType === "advertiser"
    ? [
        { label: "Meus Eventos", page: "myEvents" },
        { label: "Home", page: "home" },
        { label: "Adicionar", page: "addEvent" }
      ]
    : [
        { label: "Eventos", page: "events" },
        { label: "Home", page: "home" },
        { label: "Explorar", page: "explore" }
      ];

  return (
    <f.footer>
      {buttons.map((button, index) => (
        <f.footerButton key={index} onClick={() => onPageChange(button.page)}>
          {button.label}
        </f.footerButton>
      ))}
    </f.footer>
  );
}
Footer.propTypes = {
  profileType: PropTypes.string.isRequired,
  onPageChange: PropTypes.func.isRequired,
};

export default Footer;
