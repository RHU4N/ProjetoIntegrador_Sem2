import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css';

const Home = () => {
  const handleLoginClick = () => {
    alert('Login realizado com sucesso!');
  };

  return (
    <div className="home-container">
      {/* Cabeçalho */}
      <header className="home-header">
        <div className="home-logo">CM</div>
        <div className="home-login-icon">
          👤
        </div>
      </header>

      {/* Mapa */}
      <main className="home-map-container">
        <div className="home-map">
          <iframe
            title="Mapa"
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.477734104395!2d-46.650963825170504!3d-23.58808136397159!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce59e5433f4b77%3A0x3c191000f78a7e67!2sAv.%20Paulista%2C%20São%20Paulo%20-%20SP!5e0!3m2!1sen!2sbr!4v1698163498767!5m2!1sen!2sbr"
            width="100%"
            height="100%"
            style={{ border: 0, borderRadius: '10px' }}
            allowFullScreen=""
            loading="lazy"
          ></iframe>
        </div>
      </main>

      {/* Rodapé */}
      <footer className="home-footer">
        <Link to="/login">
          <button className="footer-button">LOGIN</button>
        </Link>
        <button className="footer-button">HOME</button>
        <button className="footer-button">EXPLORAR</button>
      </footer>
    </div>
  );
};

export default Home;
