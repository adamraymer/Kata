package com.adamraymer.kata1;

public class BabySitterFamilyA extends BabySitter {

    private int startHour = 0;
    private int endHour = 0;
    private String startAMorPM;
    private String endAMorPM;
    private int totalBill = 0;

    public BabySitterFamilyA (String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5,7));
        setEndAMorPM(enteredEndTime.substring(5,7));

    }

    //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night

    public void calcHourTotals() {
        startHour = super.getCheckStartTime();
        endHour = super.getCheckEndTime();
        startAMorPM = super.getStartAMorPM();
        endAMorPM = super.getEndAMorPM();

        //count number of billable hours. Need to check where any change from PM to AM would be
        if (endHour <= 11) {
            for (int i = startHour; i < 11; i++) {
                totalBill = totalBill + 15;

            }

        }
        System.out.println(totalBill);
    }
}
