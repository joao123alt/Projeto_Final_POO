package com.hotel.system;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Usuario {
    public static List<Cliente> listadeClientes = new ArrayList<Cliente>();

    // Contrutor Cliente
    public Cliente(String cpf, String nome, String telefone, String email, String password) {
        super(cpf, nome, telefone, email, password);
    }

    // Cadastra cliente
    public static void cadastrarCliente() {
    try {
        Scanner cadastrocliente = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nomecliente = cadastrocliente.nextLine();
        System.out.println("Digite o cpf do cliente: ");
        String cpfcliente = cadastrocliente.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefonecliente = cadastrocliente.nextLine();
        System.out.println("Digite o email do cliente: ");
        String emailcliente = cadastrocliente.nextLine();
        System.out.println("Crie uma senha para o cliente:");
        String senhacliente = cadastrocliente.nextLine();

        Cliente cliente = new Cliente(cpfcliente, nomecliente, telefonecliente, emailcliente, senhacliente);
        listadeClientes.add(cliente);
        Usuario.listaDeUsuarios.add(cliente);
    } catch (Exception e) {
        System.out.println(VERMELHO + "Erro ao cadastrar cliente: " + e.getMessage() + RESET);
    }
}
     // Exclui cliente
    public static void excluirCliente() {
    try {
        Scanner scanner = new Scanner(System.in);
        if (listadeClientes.isEmpty()) {
            System.out.println(VERMELHO + "Não há clientes para serem removidos." + RESET);
        } else {
            System.out.println("Qual o número do cliente que deseja remover:");
            for (int i = 0; i < listadeClientes.size(); i++) {
                System.out.println((i + 1) + " - Nome: " + listadeClientes.get(i).getNome());
            }
            int clienteRemover = scanner.nextInt();
            if (clienteRemover > 0 && clienteRemover <= listadeClientes.size()) {
                String removido = listadeClientes.get(clienteRemover - 1).getNome();
                listadeClientes.remove(clienteRemover - 1);
                System.out.println("Cliente " + removido + " removido da lista.");
            } else {
                System.out.println(VERMELHO + "Número inválido." + RESET);
            }
        }
    } catch (IndexOutOfBoundsException e) {
        System.out.println(VERMELHO + "Erro: cliente não encontrado." + RESET);
    } catch (InputMismatchException e) {
        System.out.println(VERMELHO + "Erro: entrada inválida. Por favor, insira um número válido." + RESET);
    }
}
    // Atualiza cliente
    public static void atualizarCliente() {
    try {
        Scanner scanner = new Scanner(System.in);
        if (listadeClientes.isEmpty()) {
            System.out.println(VERMELHO + "Não há clientes para serem atualizados." + RESET);
        } else {
            System.out.println("Escolha o número do cliente que deseja atualizar:");
            for (int i = 0; i < listadeClientes.size(); i++) {
                System.out.println((i + 1) + " - Nome: " + listadeClientes.get(i).getNome());
            }
            int clienteAtualizar = scanner.nextInt() - 1;
            if (clienteAtualizar >= 0 && clienteAtualizar < listadeClientes.size()) {
                Cliente cliente = listadeClientes.get(clienteAtualizar);
                Scanner scannerAt = new Scanner(System.in);
                System.out.println("1 - Nome\n2 - CPF\nEscolha uma opção para atualizar:");
                int atualizado = scanner.nextInt();
                if (atualizado == 1) {
                    System.out.print("Novo nome: ");
                    cliente.setNome(scannerAt.nextLine());
                } else if (atualizado == 2) {
                    System.out.print("Novo CPF: ");
                    cliente.setCpf(scannerAt.nextLine());
                }
            } else {
                System.out.println(VERMELHO + "Número inválido." + RESET);
            }
        }
    } catch (InputMismatchException e) {
        System.out.println(VERMELHO + "Erro: entrada inválida. Por favor, insira um número válido." + RESET);
    }
}


    // Lista todos os clientes do Hotel
    public static void mostrarClientes() {
        if (listadeClientes.isEmpty()) {
            System.out.println(VERMELHO + "Não há clientes para serem mostrados." + RESET);
        } else {
            System.out.println(AZUL +"╔═════╦═════════════════════╦═════════════════╦═══════════════════╦════════════════════╗"+ RESET);
            System.out.println("║ ID  ║ Nome                ║ CPF             ║ Telefone          ║ Email              ║");
            System.out.println("╠═════╬═════════════════════╬═════════════════╬═══════════════════╬════════════════════╣");
            for (Cliente c : listadeClientes) {
                
                System.out.printf("║ %-3d ║ %-19s ║ %-15s ║ %-17s ║ %-18s ║%n",
                        c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail());
                System.out.println("╠═════╬═════════════════════╬═════════════════╬═══════════════════╬════════════════════╣");
            }
            System.out.println(AZUL +"╚═════╩═════════════════════╩═════════════════╩═══════════════════╩════════════════════╝"+ RESET);
        }
    }

    // Login Cliente
    @Override
    public void login() {
        Menu.mostrarMenuCliente();
    }

    
}