package com.adamraymer.kata1;

public class Main {

    public static void main(String[] args) {
	// test babysitter driver
        String enteredStartTime;
        String enteredEndTime;
        int checkStartTime = 0;
        int checkEndTime = 0;

        enteredStartTime = "05:13PM";
        enteredEndTime = "01:00AM";

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
        sitter.setCheckStartTime(checkStartTime);
        sitter.setCheckEndTime(checkEndTime);

        System.out.println(sitter.checkStartTime());
        System.out.println(sitter.checkEndTime());
        System.out.println(sitter.checkHourOrder());
        sitter.calcHourTotals();

    }
}
