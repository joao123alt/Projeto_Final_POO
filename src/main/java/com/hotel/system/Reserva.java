package com.hotelaria.system.Sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hotelaria.system.SystemApplication;
import com.hotelaria.system.Sistema.Enums.CategoriaQuarto;
import com.hotelaria.system.Sistema.Enums.StatusReserva;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserva extends Menu {

    public static List<Reserva> listadeReserva = new ArrayList<Reserva>();

    // Contador de id
    
    private static int contador = 1;
   
    // Atributos do métodos
    
    private int id;
    private String emailcliente;
    private String quarto;
    private int ndiaria;
    private Double totalconta;
    private StatusReserva status;
    private CategoriaQuarto categoriaQuarto;

    // Construtor do objeto
    public Reserva(String emailcliente, int ndiaria, Double totalconta, CategoriaQuarto categoriaQuarto) {
        this.id = contador++;
        this.emailcliente = emailcliente;
        this.ndiaria = ndiaria;
        this.totalconta = totalconta;
        this.categoriaQuarto = categoriaQuarto;
        this.status = StatusReserva.PENDENTE;
    }

    public static void alimentaReserva() {
        Reserva reserva0 = new Reserva("pedro@gmail.com", 5, 500.0, CategoriaQuarto.BASICO);
        listadeReserva.add(reserva0);
    }
    
    // Métodos do objeto //

    public static void realizarReserva() {
        Scanner screserva = new Scanner(System.in);
    
        try {
            System.out.println("Para quem é esta reserva?((Digite o email do cliente)) ");
            String emailcliente = screserva.nextLine();
            boolean achoucliente = false;
    
            for (Cliente c : Cliente.listadeClientes) {
                if (c.getEmail().equals(emailcliente)) {
                    achoucliente = true;
                }
            }
    
            if (achoucliente) {
                CategoriaQuarto categoriaQuarto = null;
    
                while (categoriaQuarto == null) {
                    try {
                        System.out.println("Escolha a categoria do quarto desejado: ");
                        System.out.println("1 - BASICO ");
                        System.out.println("2 - INTERMEDIARIO  ");
                        System.out.println("3 - STANDARD  ");
                        int opcao = screserva.nextInt();
    
                        switch (opcao) {
                            case 1:
                                categoriaQuarto = CategoriaQuarto.BASICO;
                                break;
                            case 2:
                                categoriaQuarto = CategoriaQuarto.INTERMEDIARIO;
                                break;
                            case 3:
                                categoriaQuarto = CategoriaQuarto.STANDARD;
                                break;
                            default:
                                System.out.println(VERMELHO + "Opção inválida. Por favor, escolha uma opção válida." + RESET);
                        }
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        screserva.nextLine();  
                    }
                }
    
                System.out.println("Qual o número de diárias desejadas? ");
                int diarias = screserva.nextInt();
    
                Double valoraPagar = Quarto.valorConta(categoriaQuarto, diarias);
    
                Reserva reserva = new Reserva(emailcliente, diarias, valoraPagar, categoriaQuarto);
                listadeReserva.add(reserva);
            } else {
                System.out.println("Cliente não cadastrado, tente novamente");
            }
    
        } catch (Exception e) {
            System.out.println("Erro ao realizar a reserva: " + e.getMessage());
        }
    }
    
    public static void atualizarReserva(List<Reserva> listadeReserva) {
        String emailUsuarioLogado = SystemApplication.usuarioLogado.getEmail();
        boolean temReservas = false;
    
        for (Reserva r : listadeReserva) {
            if (r.getEmailcliente().equals(emailUsuarioLogado)) {
                temReservas = true;
                break;
            }
        }
    
        if (temReservas) {
            CategoriaQuarto novacategoriaQuarto = null;
            Scanner scanner = new Scanner(System.in);
    
            try {
                System.out.println("Atualizar reserva:");
                System.out.println("Digite o id da reserva:");
                int id = scanner.nextInt();
                System.out.println("Digite nova quantidade de diárias:");
                int qtd = scanner.nextInt();
    
                while (novacategoriaQuarto == null) {
                    try {
                        System.out.println("Escolha a categoria do quarto desejado:");
                        System.out.println("1- BASICO ");
                        System.out.println("2- INTERMEDIARIO ");
                        System.out.println("3- STANDARD ");
                        int opcaoquarto = scanner.nextInt();
    
                        switch (opcaoquarto) {
                            case 1:
                                novacategoriaQuarto = CategoriaQuarto.BASICO;
                                break;
                            case 2:
                                novacategoriaQuarto = CategoriaQuarto.INTERMEDIARIO;
                                break;
                            case 3:
                                novacategoriaQuarto = CategoriaQuarto.STANDARD;
                                break;
                            default:
                                System.out.println(VERMELHO + "Opção inválida. Por favor, escolha uma opção válida." + RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(VERMELHO + "Entrada inválida. Por favor, insira um número." + RESET);
                        scanner.nextLine(); 
                    }
                }
    
                boolean reservaEncontrada = false;
    
                for (Reserva reserva : listadeReserva) {
                    if (reserva.getId() == id && reserva.getEmailcliente().equals(emailUsuarioLogado)) {
                        reserva.setNdiaria(qtd);
                        reserva.setCategoriaQuarto(novacategoriaQuarto);
                        Double valoraPagar = Quarto.valorConta(novacategoriaQuarto, qtd);
                        reserva.setTotalconta(valoraPagar);
                        reservaEncontrada = true;
                        System.out.println("Reserva atualizada com sucesso.");
                        break;
                    }
                }
    
                if (!reservaEncontrada) {
                    System.out.println(VERMELHO + "Reserva não encontrada ou não pertence a você." + RESET);
                }
            } catch (Exception e) {
                System.out.println(VERMELHO+ "Erro ao atualizar a reserva: "+ RESET + e.getMessage());
            }
        } else {
            System.out.println(VERMELHO + "Você não possui reservas." + RESET);
        }
    }
    
    public static void cancelarReserva() {
        System.out.println("Lista das reservas do cliente:");
        for (Reserva r : listadeReserva) {
            if (r.getEmailcliente().equals(SystemApplication.usuarioLogado.getEmail())) {
                System.out.println("Id: " + r.getId() + " Email: " + r.getEmailcliente() + " Quarto: " + r.getQuarto()
                        + " QTD diária: " + r.getNdiaria() + " Total a pagar: R$" + r.getTotalconta());
            }
        }
    
        Scanner sc = new Scanner(System.in);
    
        try {
            System.out.println("Qual o id da reserva a ser excluída?");
            int idexcluir = sc.nextInt();
    
            Iterator<Reserva> iterator = listadeReserva.iterator();
            boolean reservaEncontrada = false;
    
            while (iterator.hasNext()) {
                Reserva r = iterator.next();
                if (r.getEmailcliente().equals(SystemApplication.usuarioLogado.getEmail()) && r.getId() == idexcluir) {
                    iterator.remove();
                    reservaEncontrada = true;
                    System.out.println("Reserva excluída com sucesso!");
                    break;
                }
            }
    
            if (!reservaEncontrada) {
                System.out.println("Reserva não encontrada.");
            }
    
        } catch (Exception e) {
            System.out.println("Erro ao cancelar a reserva: " + e.getMessage());
        }
    }
 
    public static void mostrarReserva() {
        System.out.println(
                VERDE + "╔═════╦═══════════════════════╦════════════╦═══════════╦═════════════════╦════════════════╗"
                        + RESET);
        System.out
                .println("║ ID  ║ Email Cliente         ║ Quarto     ║ Diárias   ║ Total a Pagar   ║ Status         ║");
        System.out
                .println("╠═════╬═══════════════════════╬════════════╬═══════════╬═════════════════╬════════════════╣");

        for (Reserva r : listadeReserva) {
            if (r.getEmailcliente().equals(SystemApplication.usuarioLogado.getEmail())) {
                System.out.printf("║ %-3d ║ %-21s ║ %-10s ║ %-9d ║ R$ %-13.2f║ %-14s ║%n",
                        r.getId(),
                        r.getEmailcliente(),
                        r.getCategoriaQuarto().name(),
                        r.getNdiaria(),
                        r.getTotalconta(),
                        r.getStatus().name());
                System.out.println(
                        "╠═════╬═══════════════════════╬════════════╬═══════════╬═════════════════╬════════════════╣");
            }
        }
        System.out.println(
                VERDE + "╚═════╩═══════════════════════╩════════════╩═══════════╩═════════════════╩════════════════╝"
                        + RESET);
    }
}


