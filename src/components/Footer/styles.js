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
    background-color: #1C1C1C;  
    color: var(--white);              
    border: 2px solid var(--coal); 
    width: 200px;
    border-radius: 5px;        
    padding: 10px 20px;      
    font-size: 25px;          
    font-weight: bold;         
    cursor: pointer;         
    transition: all 0.3s ease;

    @media (max-width: 768px) { /* Para telas menores, como celulares */
        width: auto;

    }

    &:hover{
        background-color: var(--white); 
        border-color: var(--primary-light);    
        color: var(--orange);   
    }
`