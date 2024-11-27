import { useState, useEffect } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import styles from './styles'; // Importa os estilos

// Configuração do ícone do Leaflet
delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon-2x.png',
  iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-icon.png',
  shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/images/marker-shadow.png',
});

const Map = () => {
  const [position, setPosition] = useState(null); // Estado para armazenar a localização do usuário

  useEffect(() => {
    // Função para obter a localização do usuário
    const obterLocalizacao = () => {
      if ('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition(
          (posicao) => {
            const { latitude, longitude } = posicao.coords;
            setPosition([latitude, longitude]); // Atualiza a posição com as coordenadas do usuário
          },
          (erro) => {
            console.error('Erro ao obter localização:', erro);
            // Define uma posição padrão caso a geolocalização falhe
            setPosition([-23.55052, -46.633308]); // São Paulo
          }
        );
      } else {
        console.error('Geolocalização não é suportada pelo navegador.');
        setPosition([-23.55052, -46.633308]); // São Paulo como fallback
      }
    };

    obterLocalizacao();
  }, []); // Executa apenas na montagem do componente

  if (!position) {
    // Exibe um estado de carregamento enquanto a localização é obtida
    return <div>Carregando mapa...</div>;
  }

  return (
    <div style={styles.appContainer}>
      <div style={styles.mapContainer}>
        <MapContainer center={position} zoom={13} style={styles.mapStyle}>
          <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          />
          <Marker position={position}>
            <Popup>
              Você está aqui!
            </Popup>
          </Marker>
        </MapContainer>
      </div>
    </div>
  );
};

export default Map;