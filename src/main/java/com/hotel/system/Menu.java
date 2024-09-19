package com.hotelaria.system.Sistema;

import java.util.Scanner;

import com.hotelaria.system.SystemApplication;

public class Menu {

public static final String VERDE = "\u001B[32m";
public static final String RESET = "\u001B[0m";
public static final String VERMELHO = "\u001B[38;5;124m";
public static final String AMARELO = "\u001B[33m";
public static final String NEGRITO = "\033[1m";
public static final String VERDEES = "\u001B[38;5;22m";
public static final String AZUL = "\u001B[38;5;33m";


//Tela de Login
public static void exibirCabecalhoLogin(String titulo) {

    System.out.println("             ╔══════════════╗");

    System.out.println("             ║" + NEGRITO + AMARELO + "*** " + RESET + VERDE + NEGRITO +
                                      " HOTEL " + RESET + NEGRITO + AMARELO + "***" + RESET + "║");

    System.out.println("             ║" + NEGRITO + AZUL + " AMIGO DO MAR" + RESET + " ║");

    System.out.println(              "  ╔══════════╝══════════════╚══════════╗");

    System.out.println(               "  ║\"\"_\"\"_\"\"_\"\"||" + "==||==||==||" + "\"\"_\"\"_\"\"_\"\"║");

    System.out.println(               "  ║\"\"\"\"\"\"\"\"\"\"\"||" + "..||..||..||" + "\"\"\"\"\"\"\"\"\"\"\"║");

    System.out.println(               "  ║" + AMARELO + "╚╝ ╚╝ ╚╝ ╚╝" + RESET + "||" + AMARELO + "╚╝" 
                                      + RESET + "||" + AMARELO + "╚╝" + RESET + "||" + AMARELO + "╚╝" 
                                      + RESET + "||" + AMARELO + "╚╝ ╚╝ ╚╝ ╚╝" + RESET +"║");

    System.out.println(               "  ║" + ".. .. .. ..||..||__||..||.. .. .. ..║");

    System.out.println(               AZUL + " ~" + RESET + "║" + AMARELO + "╚╝ ╚╝ ╚╝ ╚╝" + RESET + "||" 
                                      + AMARELO + "╚╝" + RESET + "|╔═" +  AMARELO + RESET +"═╗|" + AMARELO +
                                      "╚╝" + RESET + "||" + AMARELO + "╚╝ ╚╝ ╚╝ ╚╝" + RESET +"║" + AZUL + "~");

     System.out.println(              AZUL + "~~" + RESET + "║" + AZUL + ";,;;;,;;;,;;;,  " + RESET + "║ °║"  
                                    + AZUL + "  ;;;,;;,;;;,;;;" + RESET +"║" + AZUL +"~~");

    System.out.println(               ""+ AZUL + "~~~~~~~~~~~~~~~~~~" + RESET + " `--´" + AZUL + 
                                      " ~~~~~~~~~~~~~~~~~~" + RESET);

    System.out.println("╔════════════════════════════════════════╗");
    System.out.println("║" + AZUL + "~~~~~~~~~~~~~~~~~" + RESET + " Login " + AZUL + "~~~~~~~~~~~~~~~~" + RESET + "║");
    System.out.println("╚════════════════════════════════════════╝");
}

// Menu atendente
public static void mostrarMenuAtendente() {
    int opcao = -1;
    Scanner sc = new Scanner(System.in);

    do {
        try {
            System.out.println(AZUL + "╔══" + RESET + "══════════════════════════════════════╗");
            System.out.println(AZUL + "║             Menu Atendente             " + RESET + "║");
            System.out.println(AZUL + "╚══════════════════════════════════════" + RESET + "══╝");
            System.out.println(" Escolha uma opção abaixo");
            System.out.println("╔══════════════════════════════════════"+ AZUL +"══╗" + RESET);
            System.out.println("║ 1 - Ver clientes                      "+ AZUL +" ║"+ RESET);
            System.out.println("║ 2 - Criar reserva                     "+ AZUL +" ║"+ RESET);
            System.out.println("║ 3 - Ver feedbacks                     "+ AZUL +" ║"+ RESET);
            System.out.println("║ 4 - Cadastrar novo cliente            "+ AZUL +" ║"+ RESET);
            System.err.println("║ 5 - Listar Quartos                    "+ AZUL +" ║"+ RESET);
            System.err.println("║ 0 - Sair                              "+ AZUL +" ║"+ RESET);
            System.out.println("╚══"+ AZUL +"══════════════════════════════════════╝" + RESET);
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();  // Pode lançar InputMismatchException

            switch (opcao) {
                case 1:
                    Cliente.mostrarClientes();
                    break;
                case 2:
                    Reserva.realizarReserva();
                    break;
                case 3:
                    Feedback.listarFeedback();
                    break;
                case 4:
                    Cliente.cadastrarCliente();
                    break;
                case 5:
                    Quarto.mostrarQuartos();
                    break;
               
                case 0:
                    System.out.println("Saindo...");
                    SystemApplication.menuLogin();
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "Erro: Entrada inválida. Por favor, digite um número!" + RESET);
            sc.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
        }
    } while (opcao != 0);
}

// Menu cliente
public static void mostrarMenuCliente() {
    int opcao = -1;
    Scanner sc = new Scanner(System.in);

    do {
        try {
            System.out.println(VERDE + "╔══" + RESET + "══════════════════════════════════════╗");
            System.out.println(VERDE + "║              Menu Cliente              " + RESET + "║");
            System.out.println(VERDE + "╚══════════════════════════════════════" + RESET + "══╝");
            System.out.println(" Escolha uma opção abaixo");
            System.out.println("╔══════════════════════════════════════"+ VERDE +"══╗" + RESET);
            System.out.println("║ 1 - Ver reservas                      "+ VERDE +" ║"+ RESET);
            System.out.println("║ 2 - Cancelar reserva                  "+ VERDE +" ║"+ RESET);
            System.out.println("║ 3 - Deixar feedback                   "+ VERDE +" ║"+ RESET);
            System.out.println("║ 4 - Atualizar reserva                 "+ VERDE +" ║"+ RESET);
            System.out.println("║ 5 - Pagamento                         "+ VERDE +" ║"+ RESET);
            System.out.println("║ 0 - Sair                              "+ VERDE +" ║"+ RESET);
            System.out.println("╚══"+ VERDE +"══════════════════════════════════════╝" + RESET);
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();  // Pode lançar InputMismatchException

            switch (opcao) {
                case 1:
                    Reserva.mostrarReserva();
                    break;
                case 2:
                    Reserva.cancelarReserva();
                    break;
                case 3:
                    Feedback.cadastrarFeedback();
                    break;
                case 4:
                    Reserva.mostrarReserva();
                    Reserva.atualizarReserva(Reserva.listadeReserva);
                    break;
                case 5:
                    System.out.println("Fazer pagamento");
                    Pagamento.realizarPagamento();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    SystemApplication.menuLogin();
                    break;
                default:
                    System.out.println(VERMELHO + "Digite uma opção válida!" + RESET);
                    break;
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "Erro: Entrada inválida. Por favor, digite um número!" + RESET);
            sc.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
        }
    } while (opcao != 0);
}}
