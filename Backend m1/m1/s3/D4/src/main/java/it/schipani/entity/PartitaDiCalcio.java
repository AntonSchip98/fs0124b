package it.schipani.entity;

import java.util.Date;

public class PartitaDiCalcio extends Evento{

    private String squadraDiCasa;

    private String squadraOspite;

    private String vincitore;

    private int goalCasa;

    private int goalOspite;

    public PartitaDiCalcio(String title, Date dataEvento, String description,
                           int maxNumberPartecipant, String squadraDiCasa,
                           String squadraOspite, String vincitore, int goalCasa, int goalOspite) {
        super(title, dataEvento, description, maxNumberPartecipant);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.vincitore = vincitore;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getVincitore() {
        return vincitore;
    }

    public int getGoalCasa() {
        return goalCasa;
    }

    public int getGoalOspite() {
        return goalOspite;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public void setGoalCasa(int goalCasa) {
        this.goalCasa = goalCasa;
    }

    public void setGoalOspite(int goalOspite) {
        this.goalOspite = goalOspite;
    }
}
