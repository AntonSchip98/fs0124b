package it.schipani;

import it.schipani.classes.*;

import java.net.SocketOption;

public class Main {
    public static void main(String[] args) {
      /*  Dipendente antonio = new Dipendente(1, 3000.0, Dipartimento.AMMINISTRAZIONE);
        Dipendente cristiano = new Dipendente(2, 2000.0, Dipartimento.PRODUZIONE);
        Dipendente andrea = new Dipendente(3, 2000.0, Dipartimento.VENDITE);


        Dipendente[] dipendenti = {antonio, cristiano, andrea};

        for (Dipendente d : dipendenti) {
            System.out.println("Matricola: " + d.getMatricola());
        }*/

        var antonio = new Dirigente(1, 5000.0, Dipartimento.AMMINISTRAZIONE);
        var cristiano = new DipendenteFullTime(2, 4000.0, Dipartimento.AMMINISTRAZIONE);
        var andrea = new DipendentePartTime(3, 4000.0, Dipartimento.AMMINISTRAZIONE, 5);
        var simoneI = new Volontario("Simone", 30, "CV-Simone");

        antonio.calculateSalary();
        cristiano.calculateSalary();
        andrea.calculateSalary();
        simoneI.checkIn();

        Dipendente[] dipendenti = {antonio, cristiano, andrea};




        double stipendi = 0;
        for (Dipendente d : dipendenti) {
            stipendi += d.getStipendio();
        }
        System.out.println(stipendi);

        System.out.println("-------------------");


        Check[] dip = {antonio, cristiano, andrea, simoneI};
        for (var d : dip){
            d.checkIn();
        }
        System.out.println();
    }


}
