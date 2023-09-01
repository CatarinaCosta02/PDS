package e2;

import java.util.Scanner;

public class Main {
    // the implemenattion of the menu will be here
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        boolean command = true;
        while(true){
            System.out.println("H: choose an option");
            System.out.println("I: Read a file with the information of the flights");
            System.out.println("M: flight code ");
            System.out.println("F: flight_code num_seats_executive num_seats_tourist");
            System.out.println("B: light_code class number_seats");
            System.out.println("C: reservation_code");
            System.out.println("Q: quit");

            String[] input = sc.nextLine().split(" ");

            switch (input[0].toLowerCase()){
                case "i":
                case "m":
                case "f":
                case "b":
                case "c":
                default:
                    System.out.println("Invalid command");
                    break;

            }
        }


    }
}
