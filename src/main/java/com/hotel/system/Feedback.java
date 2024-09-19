package com.hotelaria.system.Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Feedback extends Menu {


    private static int contador = 1;

    //Colection de Quarto

    public static List<Feedback> listadefeedback = new ArrayList<Feedback>();

    //Atributos do objeto

    private int idFeedback;
    private String cliente;
    private String mensagem;
    
    //Construtor do objeto
    public Feedback(String cliente, String mensagem) {
        idFeedback = contador;
        this.cliente = cliente;
        this.mensagem = mensagem;
        contador++;
    }
     
    //Métodos do objeto

    public static void cadastrarFeedback(){
        try {
            Scanner scannerfeedback = new Scanner(System.in);
    
            System.out.println("Digite o nome do cliente:");
            String nomecliente = scannerfeedback.nextLine();
            System.out.println("Conte-nos um pouco sobre sua experiência em nosso hotel: ");
            String descricaofeedback = scannerfeedback.nextLine();
    
            Feedback feedback = new Feedback(nomecliente, descricaofeedback);
            listadefeedback.add(feedback);
        } catch (Exception e) {
            System.out.println(VERMELHO + "Erro ao cadastrar feedback: " + e.getMessage() + RESET);
        }
    }
    
    public static void listarFeedback(){
        try {
            for (Feedback f: Feedback.listadefeedback) {
                System.out.println("1- Id:" + f.getIdFeedback() + " Cliente :" + f.getCliente()+ " Mensagem: " + f.getMensagem());
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "Erro ao listar feedbacks: " + e.getMessage() + RESET);
        }
    }
}    