import { useState } from "react";
import { GlobalStyle } from "./styles/global";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Map from "./components/Map";
import Events from "./components/pages/Eventos";
import Explore from "./components/pages/Explorar";
import AddEventos from "./components/pages/AddEvent";
import MyEventos from "./components/pages/MyEvents";
import LoginModal from "./components/Login";
import SignupModal from "./components/cadastro";

function App() {
  const [currentPage, setCurrentPage] = useState("home"); // Estado para a página
  const [modalState, setModalState] = useState({ login: false, signup: false }); // Estado dos modais

  // Alternar páginas
  const handlePageChange = (page) => setCurrentPage(page);

  // Alternar entre modais
  const showLoginModal = () => setModalState({ login: true, signup: false });
  const showSignupModal = () => setModalState({ login: false, signup: true });
  const closeModals = () => setModalState({ login: false, signup: false });

  const handleLogin = (credentials) => {
    console.log("Credenciais enviadas:", credentials);
    // Lógica de login (ex.: enviar ao backend)
    closeModals();
  };

  const handleSignup = (formData) => {
    console.log("Dados de cadastro enviados:", formData);
    // Lógica de cadastro (ex.: enviar ao backend)
    closeModals();
  };

  const renderContent = () => {
    switch (currentPage) {
      case "home":
        return <Map />;
      case "events":
        return <Events />;
      case "explore":
        return <Explore />;
      case "addEvent":
        return <AddEventos />;
      case "myEvents":
        return <MyEventos />;
      default:
        return <Map />;
    }
  };

  return (
    <div>
      <GlobalStyle />
      <Header onLoginClick={showLoginModal} />
      {renderContent()}
      <Footer profileType="advertiser" onPageChange={handlePageChange} />
      {/* Modal de Login */}
      <LoginModal
        isVisible={modalState.login}
        onClose={closeModals}
        onLogin={handleLogin}
        onSignup={showSignupModal} // Abrir modal de cadastro
      />
      {/* Modal de Cadastro */}
      <SignupModal
        isVisible={modalState.signup}
        onClose={closeModals}
        onSignup={handleSignup} // Enviar dados do formulário de cadastro
      />
    </div>
  );
}

export default App;
