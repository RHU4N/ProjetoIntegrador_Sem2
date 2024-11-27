import { GlobalStyle } from "./styles/global"
import Header from "./components/Header"
import Footer from "./components/Footer"
import Map from "./components/Map"
function App() {
  return (
      <div>
          <GlobalStyle />
          <Header />
          <Map />
          <Footer profileType="anunciante" />
      </div>
  );
}

export default App;
