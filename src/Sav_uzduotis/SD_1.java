package Sav_uzduotis;

import java.util.Random;
import java.util.Scanner;

public class SD_1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Iveskite šešiaženklį sklaiciu, be pasikartojančiu skaičių: ");
        String ticket_txt = inp.next();
        if (isNumeric(ticket_txt) && ticket_txt.length() == 6) {
            if (noDuplicate(ticket_txt)) {
                if (checkTickets(ticket_txt)) {
                    System.out.println("Jusu bilieto skaicius laimingas! ");
                    count = 0;
                } else {
                    System.out.println("Deja Jusu bilieto skaicius nelaimejo! ");
                    System.out.println();
                    randTicket();
                }
            } else System.out.print("Ivestame skaičiuja pasikartoja skaičius. ");
        } else {
            System.out.println("Ivestas ne šešiaženklis skaičius");
        }
    }

    private static void randTicket() {
        Random random = new Random();
        int rand = random.nextInt(100000, 1000000);
        String str = Integer.toString(rand);
        if (noDuplicate(str)) {
            count++;
            System.out.println("Bandymas Nr.: " + count + " - " + str);
            if (checkTickets(str)) {
                System.out.println();
                System.out.println("Laimingas bandymas " + count + ", bilietas Nr.: " + str);
            } else randTicket();
        } else randTicket();
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("\\d*\\.?\\d+");
    }

    private static boolean noDuplicate(String str) {
        for (int i = 0; i < str.length(); i++) {
            int number = Integer.parseInt(String.valueOf(str.charAt(i)));
            for (int y = i + 1; y < str.length(); y++) {
                if (number == Integer.parseInt(String.valueOf(str.charAt(y)))) return false;
            }
        }
        return true;
    }

    private static boolean checkTickets(String str) {
        int firsTrio = 0;
        int secondTrio = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (i < 3) {
                firsTrio += value;
            } else secondTrio += value;
        }
        return firsTrio == secondTrio;
    }

    static int count = 0;
}