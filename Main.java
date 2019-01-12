package com.adamraymer.kata1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// test babysitter driver
        String enteredStartTime;
        String enteredEndTime;
        int checkStartTime = 0;
        int checkEndTime = 0;
        int totalBill = 0;
        boolean inputInvalid = true;
        char family;

        enteredStartTime = "05:00PM";
        enteredEndTime = "11:30PM";

//front end checks
        Scanner in = new Scanner(System.in);

        System.out.println("Babysitter hourly calculator (X to quit)");
        System.out.print("Which family is this for? ");
        String inputLine = in.nextLine().toUpperCase();

        while (inputInvalid) {

            switch (inputLine) {
                case "A":
                    inputInvalid = false;
                    break;
                case "B":
                    inputInvalid = false;
                    break;
                case "C":
                    inputInvalid = false;
                    break;
                case "X":
                    inputInvalid = false;
                    break;
                default:
                    System.out.println("Invalid Family Designation");

            }

            if (inputInvalid) {
                System.out.println("Which family is this for? ");
                inputLine = in.nextLine().toUpperCase();
            }
        }
        System.out.println(inputLine);
        try {
            checkStartTime = Integer.parseInt(enteredStartTime.substring(0, 2));
            Integer.parseInt(enteredStartTime.substring(3, 5));
        } catch (NumberFormatException e) {
            System.out.println("Invalid Start Time Entry: " + enteredStartTime);
        }

        try {
            checkEndTime = Integer.parseInt(enteredEndTime.substring(0, 2));
            Integer.parseInt(enteredEndTime.substring(3, 5));
        } catch (NumberFormatException e) {
            System.out.println("Invalid End Time Entry: " + enteredEndTime);
        }


        BabySitterFamilyA sitter = new BabySitterFamilyA(enteredStartTime, enteredEndTime);
      //  BabySitterFamilyB sitter = new BabySitterFamilyB(enteredStartTime, enteredEndTime);
        sitter.setCheckStartTime(checkStartTime);
        sitter.setCheckEndTime(checkEndTime);

        System.out.println(sitter.checkStartTime());
        System.out.println(sitter.checkEndTime());
        System.out.println(sitter.checkHourOrder());
        System.out.println(sitter.calcHourTotals(totalBill));

    }


}
