
package com.treino.jokenpo;

import static com.treino.jokenpo.Utilidades.exibirPlacar;
import static com.treino.jokenpo.Utilidades.perguntarNome;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Jokenpo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Jogada[] jogadas = Jogada.values();
        
        Map<String, Integer> placar = new HashMap<>();
        placar.put("Voce", 0);
        placar.put("Computador", 0);
        placar.put("Empates", 0);
              
        System.out.println("===== Bem-vindo ao Jokenpo! ===== ");
        String nomeInput = perguntarNome(sc);
             
        while(true){
            System.out.println("\nFaca sua jogada, " + nomeInput);
            System.out.println("===== Opcoes =====\nPedra\nPapel\nTesoura\nSair\n");
            
            String jogadaInput = sc.nextLine().trim();

            if(jogadaInput.equalsIgnoreCase("sair")){
                System.out.println("\nTchau, "+ nomeInput +"!");
                break;
            }  
            
            try{             
                Jogada jogadaJogador = Jogada.converterParaJogada(jogadaInput);               
                Jogada jogadaComputador = jogadas[random.nextInt(0, jogadas.length)];               
                Resultado resultado = jogadaJogador.compararCom(jogadaComputador);
                
                System.out.println("\nSua jogada: " + jogadaJogador + "\nJogada do computador: " + jogadaComputador);
                
                switch(resultado){
                    
                    case VITORIA -> {
                        placar.put("Voce", placar.get("Voce")+ 1);
                        System.out.println("Voce venceu!");                                           
                        exibirPlacar(placar);
                    }                        
                    case DERROTA -> {
                        placar.put("Computador", placar.get("Computador")+ 1);
                        System.out.println("Voce perdeu!");
                        exibirPlacar(placar);
                    }                        
                    case EMPATE -> {
                        placar.put("Empates", placar.get("Empates")+ 1);
                        System.out.println("Empate!");
                        exibirPlacar(placar);
                    }                   
                }                               
            }
            catch(IllegalArgumentException ex){
                System.out.println("Sua jogada foi invalida " + nomeInput + ", tente novamente.");
            }       
        }              
        sc.close();
    }
}
