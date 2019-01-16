package com.adamraymer.kata1;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // test babysitter driver
        String enteredStartTime;
        String enteredEndTime;
        int totalBill = 0;
        boolean inputValid = false;


//front end checks
        Scanner in = new Scanner(System.in);

        System.out.println("Babysitter hourly calculator (X to quit)");
        System.out.print("Which family is this for? ");
        String inputLine = in.nextLine().toUpperCase();
        String familyToCalc = " ";

        while (!inputValid) {

            switch (inputLine) {
                case "A":
                    inputValid = true;
                    familyToCalc = "A";
                    break;
                case "B":
                    inputValid = true;
                    familyToCalc = "B";
                    break;
                case "C":
                    inputValid = true;
                    familyToCalc = "C";
                    break;
                case "X":
                    inputValid = true;
                    familyToCalc = "X";
                    break;
                default:
                    System.out.println("Invalid Family Designation");

            }

            if (!inputValid) {
                System.out.println("Which family is this for? ");
                inputLine = in.nextLine().toUpperCase();
            }

        }


        if (!familyToCalc.contentEquals("X")) {
            enteredStartTime = checkStartTimeEntry();

            if (isTimeX(enteredStartTime)) {
                enteredEndTime = "X";
            } else {
                //if enteredEndTime becomes X it will be checked by isTimeX(string) later
                enteredEndTime = checkEndTimeEntry();
            }
        } else {
            //set entered times to X as well
            enteredStartTime = "X";
            enteredEndTime = "X";
        }


        if (!isTimeX(enteredStartTime) && !isTimeX(enteredEndTime)) {
            if (familyToCalc.contentEquals("A")) {
                BabySitterFamilyA sitter = new BabySitterFamilyA(enteredStartTime, enteredEndTime);

                if (sitter.validHourRange()) {
                    //hour range entered was correct; calculate totals
                    System.out.println(sitter.calcHourTotals(totalBill));
                } else {
                    while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        //loop through until valid data is found
                        System.out.println("Invalid Hour Range");
                        //Bad hour range, try again
                        //first, check to see if input is valid; if X, exit
                        enteredStartTime = checkStartTimeEntry();
                        if (isTimeX(enteredStartTime)) {
                            enteredEndTime = "X";
                        } else {
                            enteredEndTime = checkEndTimeEntry();
                            if (!isTimeX(enteredEndTime)) {
                                sitter.resetFamilyAValues(enteredStartTime, enteredEndTime);
                            }
                        }
                        //check if input is valid or if it is X to exit
                        if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                            System.out.println(sitter.calcHourTotals(totalBill));
                        }
                    }
                }
            }

        } else if (familyToCalc.contentEquals("B")) {
            BabySitterFamilyB sitter = new BabySitterFamilyB(enteredStartTime, enteredEndTime);
            if (sitter.validHourRange()) {
                //hour range entered was correct; calculate totals
                System.out.println(sitter.calcHourTotals(totalBill));
            } else {
                while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                    //loop through until valid data is found
                    System.out.println("Invalid Hour Range");
                    //Bad hour range, try again
                    //first, check to see if input is valid; if X, exit
                    enteredStartTime = checkStartTimeEntry();
                    if (isTimeX(enteredStartTime)) {
                        enteredEndTime = "X";
                    } else {
                        enteredEndTime = checkEndTimeEntry();
                        if (!isTimeX(enteredEndTime)) {
                            sitter.resetFamilyBValues(enteredStartTime, enteredEndTime);
                        }
                    }
                    //check if input is valid or if it is X to exit
                    if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        System.out.println(sitter.calcHourTotals(totalBill));
                    }
                }
            }
        } else {
            BabySitterFamilyC sitter = new BabySitterFamilyC(enteredStartTime, enteredEndTime);
            if (sitter.validHourRange()) {
                //hour range entered was correct; calculate totals
                System.out.println(sitter.calcHourTotals(totalBill));
            } else {
                while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                    //loop through until valid data is found
                    System.out.println("Invalid Hour Range");
                    //Bad hour range, try again
                    //first, check to see if input is valid; if X, exit
                    enteredStartTime = checkStartTimeEntry();
                    if (isTimeX(enteredStartTime)) {
                        enteredEndTime = "X";
                    } else {
                        enteredEndTime = checkEndTimeEntry();
                        if (!isTimeX(enteredEndTime)) {
                            sitter.resetFamilyCValues(enteredStartTime, enteredEndTime);
                        }
                    }
                    //check if input is valid or if it is X to exit
                    if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        System.out.println(sitter.calcHourTotals(totalBill));
                    }
                }
            }
        }
    }




    private static String checkStartTimeEntry () {

        boolean validLength = false;
        String startTime;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Start Time (hh:mmAMPM format) ");
        startTime = in.nextLine();

        // if "X" to exit skip checks and return "X"
        if (!isTimeX(startTime)) {
            //a valid length should be 7 characters
            while (!validLength && !isTimeX(startTime)) {
                if (startTime.length() == 7) {
                    validLength = true;
                } else {
                    System.out.println("Start time length is incorrect");
                    System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    startTime = in.nextLine();
                }

            }

            boolean numericStartTime = false;
            while (!numericStartTime && !isTimeX(startTime)) {
                try {
                    Integer.parseInt(startTime.substring(0, 2));
                    Integer.parseInt(startTime.substring(3, 5));
                    numericStartTime = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Start Time Entry: " + startTime);
                    System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    startTime = in.nextLine();
                }
            }

            boolean colonRightSpot = false;
            while (!colonRightSpot && !isTimeX(startTime)){
                if (startTime.substring(2,3).contentEquals(":")) {
                    colonRightSpot = true;
                } else {
                    System.out.println("Missing ':' or in incorrect format");
                    System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    startTime = in.nextLine();
                }
            }
        }

        return startTime;

    }

    private static String checkEndTimeEntry () {

        Scanner in = new Scanner(System.in);
        String endTime;
        boolean validLength = false;

        System.out.print("Enter End Time (hh:mmAMPM format) ");
        endTime = in.nextLine();

        if (!isTimeX(endTime)) {
            //a valid length should be 7 characters
            while (!validLength && !isTimeX(endTime)) {
                if (endTime.length() == 7) {
                    validLength = true;
                } else if (endTime.toUpperCase().contentEquals("X")) {
                    validLength = true;
                } else {
                    System.out.println("End time length is incorrect");
                    System.out.print("Enter End Time (hh:mmAMPM format) ");
                    endTime = in.nextLine();
                }

            }


            boolean numericEndTime = false;
            while (!numericEndTime && !isTimeX(endTime)) {
                try {
                    Integer.parseInt(endTime.substring(0, 2));
                    Integer.parseInt(endTime.substring(3, 5));
                    numericEndTime = true;
                } catch (Exception e) {
                    System.out.println("Invalid End Time Entry: " + endTime);
                    System.out.print("Enter End Time (hh:mmAMPM format) ");
                    endTime = in.nextLine();
                }
            }
        }

        return endTime;
    }

    private static boolean isTimeX(String time) {
        //check to see if X was entered for a time parameter. This is used to skip the rest of processing
        boolean isTimeX = false;
        if (time.toUpperCase().contentEquals("X"))
            isTimeX = true;

        return isTimeX;

    }


}
