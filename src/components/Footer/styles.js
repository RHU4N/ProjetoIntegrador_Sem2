import styled from "styled-components";

export const footer = styled.div`
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 15px 0;
    background-color: #66bb6a;
    position: fixed; /* Fixa o rodapé na parte inferior */
    bottom: 0;
    left: 0;
    z-index: 10; /* Garante que o footer fique acima do conteúdo */
`
export const footerButton = styled.button`
    background-color: white;  
    color: #333;              
    border: 2px solid #66bb6a; 
    border-radius: 5px;        
    padding: 10px 20px;      
    font-size: 16px;          
    font-weight: bold;         
    cursor: pointer;         
    transition: all 0.3s ease;

    &:hover{
        background-color: #f0f0f0; 
        border-color: #4caf50;    
        color: #4caf50;   
    }
`