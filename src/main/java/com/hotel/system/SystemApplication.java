package com.hotel.system;


import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelaria.system.Sistema.Atendente;
import com.hotelaria.system.Sistema.Cliente;
import com.hotelaria.system.Sistema.Menu;
import com.hotelaria.system.Sistema.Quarto;
import com.hotelaria.system.Sistema.Reserva;
import com.hotelaria.system.Sistema.Usuario;

@SpringBootApplication
public class SystemApplication implements CommandLineRunner {
    public static int tentativas = 3;
    public static Usuario usuarioLogado;

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Alimentando quarto
        Quarto.alimentaQuarto();
        //
        Reserva.alimentaReserva();
        // Inicialização de alguns atendentes e clientes
        Atendente atendente = new Atendente("11122233344", "Joao", "21993337478", "joao@gmail.com", "1234");
        Atendente.listadeAtendente.add(atendente);
        Usuario.listaDeUsuarios.add(atendente);

        Cliente cliente = new Cliente("99988877766", "Pedro", "24998886565", "pedro@gmail.com", "4321");
        Cliente.listadeClientes.add(cliente);
        Usuario.listaDeUsuarios.add(cliente);

        // Exibe o menu de login
        menuLogin();
    }

    public static void menuLogin() {

        Menu.exibirCabecalhoLogin("Login");

        while (tentativas > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Login: ");
            String loginDigitado = sc.nextLine();
            System.out.print("Senha: ");
            String senhaDigitada = sc.nextLine();

            if (autorizaCredenciais(loginDigitado, senhaDigitada)) {
                tentativas = 3;
                System.out.println("\nLogin bem-sucedido! Bem-vindo, " + usuarioLogado.getNome());
                usuarioLogado.login();   
                break;
            } else if (tentativas > 1) {
                tentativas--;
                System.out.println("Login ou senha incorretos! " + tentativas + " tentativas restantes.");
            } else {
                tentativas--;
                System.out.println("Cadastro bloqueado após várias tentativas incorretas!");
            }
        }
    }

    public static boolean autorizaCredenciais(String loginDigitado, String senhaDigitada) {
        // Verificação das credenciais digitadas
        for (Usuario p : Usuario.listaDeUsuarios) {
            if (p.getEmail().equals(loginDigitado) && p.getPassword().equals(senhaDigitada)) {
                usuarioLogado = p;
                return true;
            }
        }
        return false;
    }
}
