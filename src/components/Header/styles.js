// styles.js do Header
import styled from "styled-components";

export const header = styled.div`
    width: 100%;
    display: flex;
    justify-content: space-between; /* Garante que o logo e o ícone fiquem nas extremidades */
    align-items: center;
    padding: 15px 30px;
    background-color: #66bb6a;
    position: fixed; /* Fixa o cabeçalho no topo */
    top: 0;
    left: 0;
    z-index: 10; /* Garante que o header fique acima do mapa */
    height: 60px; /* Altura do cabeçalho */
`
export const headerLogo = styled.img`
    width: 50px;
    height: 50px;
`	
  

export const headerButton = styled.button`
    width: 40px;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: white;
    border-radius: 50%;
    cursor: pointer;
    font-size: 18px;
    margin-left: auto; 
` 