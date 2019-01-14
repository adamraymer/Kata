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
        boolean startTimeRange = false;
        boolean endTimeRange = false;
        boolean hourOrder = false;
        String familyDesignation;

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

        boolean startTimeX = false;
        boolean endTimeX = false;

        enteredStartTime = checkStartTimeEntry();
        enteredEndTime = checkEndTimeEntry();

        if (enteredStartTime.toUpperCase().contentEquals("X")) {
            startTimeX = true;
        }

        if (!startTimeX && !endTimeX) {
            if (inputLine.toUpperCase().contentEquals("A")) {
                BabySitterFamilyA sitter = new BabySitterFamilyA(enteredStartTime, enteredEndTime);

                while ((!startTimeRange || !endTimeRange || !hourOrder) && !enteredEndTime.toUpperCase().contentEquals("X")) {
                    startTimeRange = sitter.checkStartTime();
                    endTimeRange = sitter.checkEndTime();
                    hourOrder = sitter.checkHourOrder();
                    if (startTimeRange && endTimeRange && hourOrder) {
                        System.out.println(sitter.calcHourTotals(totalBill));
                    } else {
                        System.out.println("Invalid Hour Range");
                        enteredStartTime = checkStartTimeEntry();
                        enteredEndTime = checkEndTimeEntry();
                        sitter.setStartTime(enteredStartTime);
                        sitter.setEndTime(enteredEndTime);
                        sitter.setEndMin(enteredEndTime);
                        sitter.setStartAMorPM(enteredStartTime.substring(5, 7));
                        sitter.setEndAMorPM(enteredEndTime.substring(5, 7));
                        sitter.setCheckStartTime(Integer.parseInt(enteredStartTime.substring(0, 2)));
                        sitter.setCheckEndTime(Integer.parseInt(enteredEndTime.substring(0, 2)));
                        sitter.setCheckStartTimeMin(Integer.parseInt(enteredStartTime.substring(3, 5)));
                        sitter.setCheckEndTimeMin(Integer.parseInt(enteredEndTime.substring(3, 5)));

                    }
                }

            } else if (inputLine.toUpperCase().contentEquals("B")) {
                BabySitterFamilyB sitter = new BabySitterFamilyB(enteredStartTime, enteredEndTime);
                if (sitter.checkStartTime() && sitter.checkEndTime() && sitter.checkHourOrder()) {
                    System.out.println(sitter.calcHourTotals(totalBill));
                } else {
                    System.out.println("Invalid Hour Range");
                    enteredStartTime = checkStartTimeEntry();
                    enteredEndTime = checkEndTimeEntry();
                    sitter.setStartTime(enteredStartTime);
                    sitter.setEndTime(enteredEndTime);
                    sitter.setEndMin(enteredEndTime);
                    sitter.setStartAMorPM(enteredStartTime.substring(5, 7));
                    sitter.setEndAMorPM(enteredEndTime.substring(5, 7));
                    sitter.setCheckStartTime(Integer.parseInt(enteredStartTime.substring(0, 2)));
                    sitter.setCheckEndTime(Integer.parseInt(enteredEndTime.substring(0, 2)));
                    sitter.setCheckStartTimeMin(Integer.parseInt(enteredStartTime.substring(3, 5)));
                    sitter.setCheckEndTimeMin(Integer.parseInt(enteredEndTime.substring(3, 5)));
                }
            } else {
                BabySitterFamilyC sitter = new BabySitterFamilyC(enteredStartTime, enteredEndTime);
                if (sitter.checkStartTime() && sitter.checkEndTime() && sitter.checkHourOrder()) {
                    System.out.println(sitter.calcHourTotals(totalBill));
                } else {
                    System.out.println("Invalid Hour Range");
                    enteredStartTime = checkStartTimeEntry();
                    enteredEndTime = checkEndTimeEntry();
                    sitter.setStartTime(enteredStartTime);
                    sitter.setEndTime(enteredEndTime);
                    sitter.setEndMin(enteredEndTime);
                    sitter.setStartAMorPM(enteredStartTime.substring(5, 7));
                    sitter.setEndAMorPM(enteredEndTime.substring(5, 7));
                    sitter.setCheckStartTime(Integer.parseInt(enteredStartTime.substring(0, 2)));
                    sitter.setCheckEndTime(Integer.parseInt(enteredEndTime.substring(0, 2)));
                    sitter.setCheckStartTimeMin(Integer.parseInt(enteredStartTime.substring(3, 5)));
                    sitter.setCheckEndTimeMin(Integer.parseInt(enteredEndTime.substring(3, 5)));
                }
            }
        }

    }


    private static String checkStartTimeEntry () {


        //String startTime;
        boolean validStartTime = false;
        boolean validLength = false;
        String startTime;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Start Time (hh:mmAMPM format) ");
        startTime = in.nextLine();

        // if "X" to exit skip checks and return "X"
        if (!startTime.toUpperCase().contentEquals("X")) {
            //a valid length should be 7 characters
            while (!validLength) {
                if (startTime.length() == 7) {
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
                    Integer.parseInt(startTime.substring(0, 2));
                    Integer.parseInt(startTime.substring(3, 5));
                    numericStartTime = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Start Time Entry: " + startTime);
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
        boolean validEndTime = false;
        boolean validLength = false;

        System.out.print("Enter End Time (hh:mmAMPM format) ");
        endTime = in.nextLine();

        //a valid length should be 7 characters
        while (!validLength) {
            if (endTime.length() == 7){
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
        while (!numericEndTime) {
            try {
                Integer.parseInt(endTime.substring(0, 2));
                Integer.parseInt(endTime.substring(3, 5));
                numericEndTime = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid End Time Entry: " + endTime);
                System.out.print("Enter End Time (hh:mmAMPM format) ");
                endTime = in.nextLine();
                }
            }

        return endTime;
    }

}
