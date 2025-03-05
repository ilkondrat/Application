//package NotKasse;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Zahlenratespiel {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Bitte gib ein Zahl ein");
//        int grenze = scanner.nextInt();
//        Random random = new Random();
//        int zahl = random.nextInt(grenze) + 1;
//        int versuche = 0;
//
//        System.out.println("Willkommen beim Zahlenratespiel!");
//        System.out.printf("Ich habe mir eine Zahl zwischen 1 und %d ausgedacht.", grenze);
//
//        while (true) {
//            System.out.print("Bitte rate eine Zahl: ");
//
//            if (!scanner.hasNextInt()) {
//                System.out.println("Bitte gib nur Zahlen ein!");
//                scanner.next();
//                continue;
//            }
//
//            int eingabe = scanner.nextInt();
//            versuche++;
//
//            if (eingabe == zahl) {
//                System.out.println("Glückwunsch! Du hast die Zahl in " + versuche + " Versuchen erraten!");
//                break;
//            } else if (eingabe < zahl) {
//                System.out.println("Die gesuchte Zahl ist größer!");
//            } else {
//                System.out.println("Die gesuchte Zahl ist kleiner!");
//            }
//        }
//        scanner.close();
//    }
//}
