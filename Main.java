package com.adamraymer.kata1;

public class Main {

    public static void main(String[] args) {
	// test babysitter driver
        String enteredStartTime;
        String enteredEndTime;

        enteredStartTime = "03:00PM";
        enteredEndTime = "03:00AM";


        BabySitter sitter = new BabySitter(enteredStartTime, enteredEndTime);


        System.out.println(sitter.checkStartTime());
        System.out.println(sitter.checkEndTime());
        System.out.println(sitter.checkHourOrder());

    }
}
