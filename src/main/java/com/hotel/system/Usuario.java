package com.hotelaria.system.Sistema;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

import com.hotelaria.system.Sistema.Interface.Login;

@Getter
@Setter
public abstract class Usuario extends Menu implements Login {

    public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

    // ATRIBUTOS DO OBJETO

    //Adicionar endereço
    private static int contador = 1;

    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String password;
    
    
    public Usuario(String cpf, String nome, String telefone, String email, String password) {
        id = contador;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.password = password;
        contador++;
    }
}
