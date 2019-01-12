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
        boolean inputValid = false;
        String familyDesignation;

        enteredStartTime = "05:00PM";
        enteredEndTime = "11:30PM";

//front end checks
        Scanner in = new Scanner(System.in);

        System.out.println("Babysitter hourly calculator (X to quit)");
        System.out.print("Which family is this for? ");
        String inputLine = in.nextLine().toUpperCase();

        while (!inputValid) {

            switch (inputLine) {
                case "A":
                    inputValid = true;
                    break;
                case "B":
                    inputValid = true;
                    break;
                case "C":
                    inputValid = true;
                    break;
                case "X":
                    inputValid = true;
                    break;
                default:
                    System.out.println("Invalid Family Designation");

            }

            if (!inputValid) {
                System.out.println("Which family is this for? ");
                inputLine = in.nextLine().toUpperCase();
            }

        }

        checkTimeEntry();
        if (!inputLine.toUpperCase().contentEquals("X")) {
            familySelection(inputLine);
        }


        System.out.println(inputLine);


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

    private static void familySelection(String inputLine) {
        String familyDesignation = inputLine;
        if (familyDesignation.contentEquals("A")) {
            startBabySitterA();
        } else if (familyDesignation.contentEquals("B")) {
            startBabySitterB();
        } else {
            startBabySitterC();
        }
    }

    private static void startBabySitterA() {

        }

    private static void startBabySitterB() {

    }

    private static void startBabySitterC() {

    }


    private static void checkTimeEntry () {

        Scanner in = new Scanner(System.in);
        String startTime;
        int checkStartTime = 0;
        int checkStartTimeMin = 0;
        boolean validStartTime = false;
        boolean validLength = false;

        System.out.print("Enter Start Time (hh:mmAMPM format) ");
        startTime = in.nextLine();

        //a valid length should be 7 characters
        while (!validLength) {
            if (startTime.length() == 7){
                validLength = true;
            } else {
                System.out.println("Start time length is incorrect");
                System.out.print("Enter Start Time (hh:mmAMPM format) ");
                startTime = in.nextLine();
            }

        }



        boolean numericStartTime = false;
        while (!numericStartTime) {
            try {
                checkStartTime = Integer.parseInt(startTime.substring(0, 2));
                checkStartTimeMin = Integer.parseInt(startTime.substring(3, 5));
                numericStartTime = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Start Time Entry: " + startTime);
                System.out.print("Enter Start Time (hh:mmAMPM format) ");
                startTime = in.nextLine();
            }
        }


    }

}
