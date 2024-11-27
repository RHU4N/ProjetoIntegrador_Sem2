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

  :root{
    /* Cores Neutras */
    /* Cinza */
        --gray-light: #D9E0DB;
        --gray-medium: #B8BEBA;
        --gray-dark: #767A77;
    /* Preto */
        --black: #000000;
        --coal: #1c1c1c;
    /* Branco */
        --white: #FFFFFF;

    /* Cor Primaria */
        --primary: #4caf50;
        --primary-light: #81c784;
        --primary-dark: #388e3c;

      /* Cor secundaria */
      --secondary: #00a79d;
      --secodary-light: #00ced1;
      --secodary-dark: #008b8b;

      /* Cor destaque */
      /* Laranja */
        --orange: #F57C00;
        --orange-light: #FFA726;
        --orange-dark: #ef6c00;
      /* Amarelo */
        --yellow: #FFC107;
        --yellow-light: #FFC107;
        --yellow-dark: #FFB300;
      /* roxo */
        --purple: #8E24AA;
        --purple-light: #BA68C8;
        --purple-dark: #6a1b9a;
  }
`