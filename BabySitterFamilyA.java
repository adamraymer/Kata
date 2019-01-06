package com.adamraymer.kata1;

public class BabySitterFamilyA extends BabySitter {

    private int startHour = 0;
    private int endHour = 0;
    private String startAMorPM;
    private String endAMorPM;

    public BabySitterFamilyA (String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5,7));
        setEndAMorPM(enteredEndTime.substring(5,7));
    }

    //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night

    public void calcHourTotals() {
        this.startHour = super.getCheckStartTime();
        this.endHour = super.getCheckEndTime();
        this.startAMorPM = super.getStartAMorPM();
        this.endAMorPM = super.getEndAMorPM();

        

    }
}
