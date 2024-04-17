package it.antonio;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    /*    Rettangolo r1 = new Rettangolo(10, 20);
        Rettangolo r2 = new Rettangolo(15, 25);
        stampaRettangolo(r1);
        stampaDueRettangoli(r1, r2);*/
        /*Chiamate c1 = new Chiamate(50, 123455667);
        Sim s1 = new Sim(10000000);
        stampaDatiSim(s1);*/

        Cliente antonio = new Cliente(1, "Antonio",
                "antonio@email.it", "10/10/2024");
        Carrello antonioCart = new Carrello(antonio);
        Articolo pc = new Articolo(1, "PC", 400.90, 10);
        Articolo cell = new Articolo(3, "Cell", 1000.2, 10);

        antonioCart.aggiungiArticolo(pc, 2);
        antonioCart.aggiungiArticolo(cell, 1);
        /*antonioCart.rimuoviArticolo(cell);*/
        printCart(antonioCart, antonio);
        System.out.println(antonioCart.calcolaCostoTotale());

    }

    public static void stampaRettangolo(Rettangolo r) {
        System.out.println("Area: " + r.area() + ", Perimetro: " + r.perimeter());
    }

    public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
        System.out.println("primo rettangolo => Area: " + r1.area() + ", Perimetro: " + r1.perimeter());
        System.out.println("secondo rettangolo => Area: " + r2.area() + ", Perimetro: " + r2.perimeter());
        System.out.println("la somma delle Aree è " + (r1.area() + r2.area()));
        System.out.println("la somma dei Perimetri è " + (r1.perimeter() + r2.perimeter()));
    }

    public static void stampaDatiSim(Sim s) {
        System.out.println("Number:" + s.getNumber() + ", Credit: " + s.getCredit() + ", Calls List: " + Arrays.toString(s.getCalls()));
    }
    public static void printCart(Carrello cart, Cliente cliente){
        System.out.println("Articoli nel carrello di " + cliente.getNomeCognome() + ":");
        for (Articolo articolo : cart.getArticoli()) {
            System.out.println("Codice: " + articolo.getCodice());
            System.out.println("Descrizione: " + articolo.getDescrizione());
            System.out.println("Prezzo: " + articolo.getPrezzo());
            System.out.println("Quantità disponibile: " + articolo.getPezziDisponibili());
            System.out.println();
        }

    }
}
