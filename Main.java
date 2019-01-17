package com.adamraymer.kata1;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


//front end checks

        String familyToCalc;
        familyToCalc = determineFamily();

        String enteredStartTime;
        String enteredEndTime;

        //enter time values. If invalid, loop until valid. If X, exit. This is true for both start and
        //end times
        if (!familyToCalc.contentEquals("X")) {
            enteredStartTime = checkTimeEntry(true);

            if (isTimeX(enteredStartTime)) {
                enteredEndTime = "X";
            } else {
                //if enteredEndTime becomes X it will be checked by isTimeX(string) later
                enteredEndTime = checkTimeEntry(false);
            }
        } else {
            //set entered times to X as well
            enteredStartTime = "X";
            enteredEndTime = "X";
        }

        calcFamilyHours(familyToCalc, enteredStartTime, enteredEndTime);

    }

    private static String determineFamily() {

        //determine which family to calculate the total for. If X, exit the program
        String familyToCalc = " ";

        Scanner in = new Scanner(System.in);

        System.out.println("Babysitter hourly calculator (X to quit)");
        System.out.print("Which family is this for? ");
        String inputLine = in.nextLine().toUpperCase();

        boolean inputValid = false;
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

        return familyToCalc;

    }

    private static void calcFamilyHours(String familyToCalc, String enteredStartTime, String enteredEndTime) {
        //this will calculate total bill by family. After entry has been validated for basic rules
        //it will check to see if the range is correct before continuing. The use can X to escape

        int totalBill = 0;

        if (!isTimeX(enteredStartTime) && !isTimeX(enteredEndTime)) {
            if (familyToCalc.contentEquals("A")) {
                BabySitterFamilyA sitter = new BabySitterFamilyA(enteredStartTime, enteredEndTime);

                if (sitter.validHourRange()) {
                    //hour range entered was correct; calculate totals
                    System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                } else {
                    while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        //loop through until valid data is found
                        System.out.println("Invalid Hour Range");
                        //Bad hour range, try again
                        //first, check to see if input is valid; if X, exit
                        enteredStartTime = checkTimeEntry(true);
                        if (isTimeX(enteredStartTime)) {
                            enteredEndTime = "X";
                        } else {
                            enteredEndTime = checkTimeEntry(false);
                            if (!isTimeX(enteredEndTime)) {
                                sitter.resetFamilyAValues(enteredStartTime, enteredEndTime);
                            }
                        }
                        //check if input is valid or if it is X to exit
                        if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                            System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                        }
                    }
                }
            } else if (familyToCalc.contentEquals("B")) {
                BabySitterFamilyB sitter = new BabySitterFamilyB(enteredStartTime, enteredEndTime);

                if (sitter.validHourRange()) {
                    //hour range entered was correct; calculate totals
                    System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                } else {
                    while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        //loop through until valid data is found
                        System.out.println("Invalid Hour Range");
                        //Bad hour range, try again
                        //first, check to see if input is valid; if X, exit
                        enteredStartTime = checkTimeEntry(true);
                        if (isTimeX(enteredStartTime)) {
                            enteredEndTime = "X";
                        } else {
                            enteredEndTime = checkTimeEntry(false);
                            if (!isTimeX(enteredEndTime)) {
                                sitter.resetFamilyBValues(enteredStartTime, enteredEndTime);
                            }
                        }
                        //check if input is valid or if it is X to exit
                        if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                            System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                        }
                    }
                }
            } else {
                BabySitterFamilyC sitter = new BabySitterFamilyC(enteredStartTime, enteredEndTime);

                if (sitter.validHourRange()) {
                    //hour range entered was correct; calculate totals
                    System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                } else {
                    while ((!sitter.validHourRange()) && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                        //loop through until valid data is found
                        System.out.println("Invalid Hour Range");
                        //Bad hour range, try again
                        //first, check to see if input is valid; if X, exit
                        enteredStartTime = checkTimeEntry(true);
                        if (isTimeX(enteredStartTime)) {
                            enteredEndTime = "X";
                        } else {
                            enteredEndTime = checkTimeEntry(false);
                            if (!isTimeX(enteredEndTime)) {
                                sitter.resetFamilyCValues(enteredStartTime, enteredEndTime);
                            }
                        }
                        //check if input is valid or if it is X to exit
                        if (sitter.validHourRange() && (!isTimeX(enteredStartTime) || !isTimeX(enteredEndTime))) {
                            System.out.println("Total Hourly Bill: $" + sitter.calcHourTotals(totalBill));
                        }
                    }
                }
            }
        }
    }

    private static String checkTimeEntry (boolean isStartTime) {


        String checkTime;
        Scanner in = new Scanner(System.in);
        if (isStartTime) {
            System.out.print("Enter Start Time (hh:mmAMPM format) ");
        } else {
            System.out.print("Enter End Time (hh:mmAMPM format) ");
        }
        checkTime = in.nextLine();

        // if "X" to exit skip checks and return "X"
        boolean validLength = false;
        if (!isTimeX(checkTime)) {
            //a valid length should be 7 characters
            while (!validLength && !isTimeX(checkTime)) {
                if (checkTime.length() == 7) {
                    validLength = true;
                } else {
                    if (isStartTime) {
                        //start time passed in
                        System.out.println("Start time length is incorrect");
                        System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    } else {
                        //end time
                        System.out.println("End time length is incorrect");
                        System.out.print("Enter End Time (hh:mmAMPM format) ");
                    }
                    checkTime = in.nextLine();
                }

            }

            boolean numericStartTime = false;
            while (!numericStartTime && !isTimeX(checkTime)) {
                try {
                    Integer.parseInt(checkTime.substring(0, 2));
                    Integer.parseInt(checkTime.substring(3, 5));
                    numericStartTime = true;
                } catch (NumberFormatException e) {
                    if (isStartTime) {
                        //start time
                        System.out.println("Invalid Start Time Entry: " + checkTime);
                        System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    } else {
                        //end time
                        System.out.println("Invalid End Time Entry: " + checkTime);
                        System.out.print("Enter End Time (hh:mmAMPM format) ");
                    }

                    checkTime = in.nextLine();
                }
            }

            boolean colonRightSpot = false;
            while (!colonRightSpot && !isTimeX(checkTime)){
                if (checkTime.substring(2,3).contentEquals(":")) {
                    colonRightSpot = true;
                } else {
                    if (isStartTime) {
                        //start time
                        System.out.println("Missing ':' or in incorrect format");
                        System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    } else {
                        //end time
                        System.out.println("Missing ':' or in incorrect format");
                        System.out.print("Enter End Time (hh:mmAMPM format) ");
                    }
                    checkTime = in.nextLine();
                }
            }

            while (checkNotValidAMorPM(checkTime.toUpperCase().substring(5,7)) && !isTimeX(checkTime)){
                if (checkNotValidAMorPM(checkTime.toUpperCase().substring(5,7))) {
                    if (isStartTime) {
                        //start time
                        System.out.println("AM or PM not selected " + checkTime);
                        System.out.print("Enter Start Time (hh:mmAMPM format) ");
                    } else {
                        //end time
                        System.out.println("AM or PM not selected " + checkTime);
                        System.out.print("Enter End Time (hh:mmAMPM format) ");
                    }
                    checkTime = in.nextLine();
                }
            }
        }

        return checkTime;

    }


    private static boolean isTimeX(String time) {
        //check to see if X was entered for a time parameter. This is used to skip the rest of processing
        boolean isTimeX = false;
        if (time.toUpperCase().contentEquals("X"))
            isTimeX = true;

        return isTimeX;

    }

    private static boolean checkNotValidAMorPM (String valueNotAMPM){
        //check to make sure that the value for AM or PM is valid
        boolean validNotAMorPM = true;
        if (valueNotAMPM.contentEquals("AM") || valueNotAMPM.contentEquals("PM") )
            validNotAMorPM = false;

        return validNotAMorPM;
    }

}
