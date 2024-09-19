package com.hotelaria.system.Sistema;

import java.util.ArrayList;
import java.util.List;

import com.hotelaria.system.Sistema.Enums.CategoriaQuarto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Quarto {

    // Colection de Quarto
    
    public static List<Quarto> listadeQuartos = new ArrayList<Quarto>();

    public static int contId=1;

    // Alimenta a colection listadeQuartos

    public static void alimentaQuarto() {
        Quarto quarto1 = new Quarto(CategoriaQuarto.BASICO);
        Quarto quarto2 = new Quarto(CategoriaQuarto.INTERMEDIARIO);
        Quarto quarto3 = new Quarto(CategoriaQuarto.STANDARD);
        listadeQuartos.add(quarto1);
        listadeQuartos.add(quarto2);
        listadeQuartos.add(quarto3);

    }

    // ATRIBUTOS DO OBJETO

    private int id = 1;
    private Double valorDiaria;
    private CategoriaQuarto categoriaQuarto;

    // CONSTRUTOR

    public Quarto(CategoriaQuarto categoriaQuarto) {
        id++;
        this.categoriaQuarto = categoriaQuarto;
        this.valorDiaria = definirDiaria(categoriaQuarto);
    }

    // AUXILIA O CONSTRUTOR A DEFINIR O VALOR DA DIARIA

    public static double definirDiaria(CategoriaQuarto categoriaQuarto) {
        switch (categoriaQuarto) {
            case BASICO:
                return 100.0 ;
            case INTERMEDIARIO:
                return 500.0;
            case STANDARD:
                return 1000.0 ;
            default:
                return 0.0;
        }

    }

    /*public static double valorConta(CategoriaQuarto categoriaQuarto, int diarias) {
        switch (categoriaQuarto) {
            case BASICO:
                return (100.0 * diarias);
            case INTERMEDIARIO:
                return (500.0 * diarias);
            case STANDARD:
                return (1000.0 * diarias);
            default:
                return 0.0;
        }

    }*/

    public static double valorConta(CategoriaQuarto categoriaQuarto, int diarias) {
        double valorDiaria = definirDiaria(categoriaQuarto);
        return valorDiaria * diarias;
    }

   /*  public static void mostrarQuartos() {
        if (listadeQuartos.isEmpty()) {
            System.out.println("Nenhum quarto disponível.");
        } else {
            for (Quarto q : listadeQuartos) {
                System.out.println("Quarto ID: " + q.getId() +
                                   "\nCategoria: " + q.getCategoriaQuarto() +
                                   " | Diária: R$ " + q.getValorDiaria());
            }
        }
    }
}*/
}

    // MÉTODOS DO OBJETO

    /*public static void mostrarQuartos() {
        for (Quarto q : Quarto.listadeQuartos) {

            System.out.println("Quarto: " + q.getId() + "\nCategoria: " + q.getCategoriaQuarto() + " Diaria: "
                    + q.getValorDiaria());

        }
    }
}*/