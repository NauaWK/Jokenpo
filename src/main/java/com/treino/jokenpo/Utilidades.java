
package com.treino.jokenpo;

import java.util.Map;
import java.util.Scanner;
  
public abstract class Utilidades {
     
    public static String perguntarNome(Scanner sc){
        
        String nomeInput;      
        do{
            System.out.println("Digite o seu nome:");
            nomeInput = sc.nextLine().trim();
            
        }while(nomeInput.isEmpty());
        
        return nomeInput;
    }
        
    public static void exibirPlacar(Map<String, Integer> map){
             
        System.out.println("===== Placar =====");
        map.entrySet().forEach(entrada -> {
            System.out.println(entrada.getKey() + " : " + entrada.getValue());
        });

    }   
}
