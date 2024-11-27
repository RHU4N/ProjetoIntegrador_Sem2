import { useState } from "react";
import { GlobalStyle } from "./styles/global";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Map from "./components/Map";
import Events from "./components/pages/Eventos"; // Novo componente para "Eventos"
import Explore from "./components/pages/Explorar"; // Novo componente para "Explorar"
import AddEventos from "./components/pages/AddEvent"; // Novo componente para "Adicionar Evento"
import MyEventos from "./components/pages/MyEvents";
import LoginModal from "./components/Login"; // Importando o componente LoginModal

function App() {
  const [isLoginVisible, setLoginVisible] = useState(false); // Estado para o modal de login

  const handleLogin = (credentials) => {
    console.log("Credenciais enviadas:", credentials);
    // Aqui você pode enviar os dados para o backend
  };

  const [currentPage, setCurrentPage] = useState("home"); // Estado para controlar a página atual

  // Função para alterar a página
  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  // Renderizar o conteúdo dinamicamente
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
      <Header onLoginClick={() => setLoginVisible(true)} />
      {renderContent()}
      <Footer profileType="advertiser" onPageChange={handlePageChange} />
            {/* Modal de Login */}
      <LoginModal
        isVisible={isLoginVisible}
        onClose={() => setLoginVisible(false)}
        onLogin={handleLogin}
      />
    </div>
  );
}

export default App;