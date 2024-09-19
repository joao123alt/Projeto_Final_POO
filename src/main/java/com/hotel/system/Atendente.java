package com.hotel.system;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Atendente extends Usuario {
     
    public static List<Atendente> listadeAtendente = new ArrayList<Atendente>();


    //CONSTRUTOR
    //Adicionar endereço e id
    public Atendente ( String cpf, String nome, String telefone,   String email, String password){
        
        super(cpf, nome, telefone,  email, password);

    }



    //Métodos do Sistema de Login




    @Override
    public void login() {
        Menu.mostrarMenuAtendente();
    }
      


}