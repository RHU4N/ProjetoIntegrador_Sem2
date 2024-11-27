import React, { useState } from "react";
import { GlobalStyle } from "./styles/global";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Map from "./components/Map";
import LoginModal from "./components/Login"; // Importe o LoginModal

function App() {
  const [isLoginVisible, setLoginVisible] = useState(false); // Estado para o modal de login

  const handleLogin = (credentials) => {
    console.log("Credenciais enviadas:", credentials);
    // Aqui você pode enviar os dados para o backend
  };

  return (
    <div>
      <GlobalStyle />
      {/* Passe a função para abrir o modal no Header */}
      <Header onLoginClick={() => setLoginVisible(true)} />
      <Map />
      <Footer profileType="anunciante" />
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
