package it.schipani;

import it.schipani.it.schipani.classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var img1 = new Immagine("img1", ElementiMultimediali.IMMAGINE, 4);
        var audio1 = new Audio("audio1", ElementiMultimediali.AUDIO, 5, 3);
        var video1 = new Video("video1", ElementiMultimediali.VIDEO, 5, 15, 6);
        img1.abassaVolume();
        /*System.out.println(img1);
        System.out.println(audio1);
        System.out.println(video1);*/



      /*  img1.playOrShow();
        audio1.playOrShow();
        video1.playOrShow();*/

        Player player = new Player();
        player.addElementToLettore();
        player.eseguiElementiMultimediali();
    }


}
