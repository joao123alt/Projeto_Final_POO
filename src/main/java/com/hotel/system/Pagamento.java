package com.hotelaria.system.Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hotelaria.system.SystemApplication;
import com.hotelaria.system.Sistema.Enums.MeiodePagamento;
import com.hotelaria.system.Sistema.Enums.StatusReserva;

public class Pagamento extends Menu {

    public static List<Pagamento> listadePagamento = new ArrayList<Pagamento>();
    private static int contador = 1;

    //Atributos do objeto
    
    private int id;
    private String cliente;
    private MeiodePagamento meiodePagamento;

    //Construtor

    public Pagamento(String cliente, MeiodePagamento meiodePagamento) {
        this.id = contador++;
        this.cliente = cliente;
        this.meiodePagamento = meiodePagamento;
    }
    
    //Métodos

    public void criarCobranca() {
        
    }

    public static void realizarPagamento() {


        Scanner scanner = new Scanner(System.in);

         String emailUsuarioLogado = SystemApplication.usuarioLogado.getEmail();
        boolean temReservas = false;
    
        for (Reserva r : Reserva.listadeReserva) {
            if (r.getEmailcliente().equals(emailUsuarioLogado)) {
                temReservas = true;
                break;
            }
        }

        if(temReservas){
            try {
                System.out.println("Digite o nome do cliente: ");
                String nomeCliente = scanner.nextLine();
    
                MeiodePagamento meiodePagamento = null;
    
                while (meiodePagamento == null) {
                    System.out.println("Escolha o meio de pagamento: ");
                    System.out.println("1- DINHEIRO ");
                    System.out.println("2- CARTÃO ");
                    System.out.println("3- PIX ");
                    int opcao = scanner.nextInt();
    
                    switch (opcao) {
                        case 1:
                            meiodePagamento = MeiodePagamento.DINHEIRO;
                            break;
                        case 2:
                            meiodePagamento = MeiodePagamento.CARTÃO;
                            break;
                        case 3:
                            meiodePagamento = MeiodePagamento.PIX;
                            break;
                        default:
                            System.out.println(VERMELHO + "Opção inválida. Por favor, escolha uma opção válida." + RESET);
                    }
                }
    
                System.out.println("Digite o ID da reserva que deseja pagar: ");
                int reservaId = scanner.nextInt();
    
                Reserva reserva = Reserva.listadeReserva.stream()
                        .filter(r -> r.getId() == reservaId)
                        .findFirst()
                        .orElse(null);
    
                if (reserva != null) {
                    Pagamento pagamento = new Pagamento(nomeCliente, meiodePagamento);
                    listadePagamento.add(pagamento);
    
                    reserva.setStatus(StatusReserva.CONCLUIDO);
                    System.out.println("Pagamento realizado com sucesso! Reserva concluída.");
                } else {
                    System.out.println(VERMELHO + "Reserva não encontrada." + RESET);
                }
    
            } catch (Exception e) {
                System.out.println(VERMELHO + "Erro ao processar o pagamento: " + e.getMessage() + RESET);
            }
        }
       
    }
}
