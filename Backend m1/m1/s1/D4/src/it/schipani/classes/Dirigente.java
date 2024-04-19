package it.schipani.classes;

public class Dirigente extends Dipendente{

    public Dirigente(int matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public void calculateSalary() {
        System.out.println("Il Dirigente con matricola: " + getMatricola() + ", ha uno stipendio mensile di " + getStipendio());
    }


}
