import { GlobalStyle } from "./styles/global"
import Header from "./components/Header"
import Footer from "./components/Footer"

function App() {
  return (
      <div>
          <GlobalStyle />
          <Header />
          <Footer profileType="anunciante" />
      </div>
  );
}

export default App;
