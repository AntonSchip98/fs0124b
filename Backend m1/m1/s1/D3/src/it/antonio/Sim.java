package it.antonio;

public class Sim {

    private int number;
    private int credit;
    private Chiamate[] calls;

    public Sim(int number) {
        this.number = number;
        this.credit = 0;
        this.calls = new Chiamate[0];
    }


    public int getNumber() {
        return number;
    }

    public int getCredit() {
        return credit;
    }

    public Chiamate[] getCalls() {
        return calls;
    }

    public void setCalls(Chiamate[] calls) {
        this.calls = calls;
    }
}
