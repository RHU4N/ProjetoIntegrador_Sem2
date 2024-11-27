// styles.js
const styles = {
    appContainer: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      justifyContent: 'center',
      height: '100vh', // Usa a altura total da janela
      margin: 0,
      padding: 0,
    },
    header: {
      height: '60px', // Altura fixa para o cabeçalho
      backgroundColor: '#4CAF50',
      color: '#fff',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      fontSize: '1.5em',
      width: '100%', // Largura total para cobrir o topo
    },
    footer: {
      height: '40px', // Altura fixa para o rodapé
      backgroundColor: '#4CAF50',
      color: '#fff',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      fontSize: '1em',
      width: '100%', // Largura total para cobrir o rodapé
    },
    mapContainer: {
      width: '80%', // Reduzido para 80% da largura da tela
      height: '60%', // Reduzido para 60% da altura da tela
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      border: '2px solid #4CAF50', // Adiciona uma borda para destacar o mapa
      borderRadius: '10px', // Bordas arredondadas
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.2)', // Sombra para destacar
    },
    mapStyle: {
      height: '100%',
      width: '100%',
      borderRadius: '10px', // Bordas arredondadas no próprio mapa
    },
  };
  
  export default styles;
  