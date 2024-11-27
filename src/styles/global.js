import { createGlobalStyle } from "styled-components";

// Adicione um estilo global para redefinir as margens e preenchimentos
export const GlobalStyle = createGlobalStyle`
    html, body {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
    font-family: Arial, sans-serif;
    background-color: grey;
  }
`