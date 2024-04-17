package it.antonio;

public class Rettangolo {
    private double height = 0.0;
    private double length = 0.0;

    public Rettangolo(double height, double length){
        this.height = height;
        this.length = length;
    }

    public double area(){
        return this.height * this.length;
    }

    public double perimeter(){
        return (this.height + this.length) * 2;
    }


}
