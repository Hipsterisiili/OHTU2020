package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static Scanner lukija = new Scanner(System.in);

    private static String luku() {
        return lukija.nextLine();
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        while (true) {
            luettu = luku();
            switch (luettu) {
                case "A":
                case "a":
                    return A;
                case "B":
                case "b":
                    return B;
                case "C":
                case "c":
                    return C;
                default:
                    System.out.println("Virheellinen joukko! " + luettu
                            + "\nYritä uudelleen!");
            }
        }
    }

    private static void lisaa() {
        System.out.println("\nMihin joukkoon ja mikä luku?");
        IntJoukko joukko = mikaJoukko();
        joukko.lisaa(Integer.parseInt(lukija.nextLine()));
    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, cJoukko;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        cJoukko = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + cJoukko.toString());
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, cJoukko;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        cJoukko = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + cJoukko.toString());
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        IntJoukko joukko;
        int lisLuku;
        System.out.print("Mistä joukosta ja mikä luku poistetaan? ");
        joukko = mikaJoukko();
        lisLuku = Integer.parseInt(lukija.nextLine());
        joukko.poista(lisLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        System.out.print("Mihin joukkoon ja mikä luku? ");
        joukko = mikaJoukko();
        kysLuku = Integer.parseInt(lukija.nextLine());
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!"
                + "\nKäytössäsi ovat joukot A, B ja C."
                + "\nJoukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            luettu = luku();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
            }
        }
    }
}
