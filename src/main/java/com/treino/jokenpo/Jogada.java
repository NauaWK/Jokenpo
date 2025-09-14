
package com.treino.jokenpo;

import java.util.Map;

public enum Jogada {
    
    TESOURA, PAPEL, PEDRA;
    
    private static final Map<Jogada, Jogada> venceDe = Map.of(
    
        PEDRA, TESOURA,
        TESOURA, PAPEL,
        PAPEL, PEDRA
                   
    );
    
    public Resultado compararCom(Jogada outra){
        
        if(this == outra) return Resultado.EMPATE;
        if(venceDe.get(this) == outra) return Resultado.VITORIA;
        return Resultado.DERROTA;
        
    }
    
    public static Jogada converterParaJogada(String entrada){
        
        Jogada jogada = null;       
        entrada = entrada.toLowerCase();
        
        switch(entrada){
            
            case "pedra" -> jogada = PEDRA;
                
            case "papel" -> jogada = PAPEL;
                
            case "tesoura" -> jogada = TESOURA;
            
            default -> throw new IllegalArgumentException();
        }      
        
        return jogada;
    }          
    
    
}
