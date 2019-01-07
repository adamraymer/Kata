package com.adamraymer.kata1;

public class BabySitterFamilyA extends BabySitter {

    private int startHour = 0;
    private int endHour = 0;
    private String startAMorPM;
    private String endAMorPM;
    private String endTime;
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
        endTime = super.getEndTime();

        //count number of billable hours. Need to check where any change from PM to AM would be
        if ((endHour <= 11) || (endAMorPM == "AM")) {
            for (int i = startHour; i < 11; i++) {
                totalBill = totalBill + 15;
            }
        }

        if ((endHour == 11) && (Integer.parseInt(endTime.substring(3, 5)) > 1)) {
            //add one more hour
            totalBill = totalBill + 20;
        }

        if (endAMorPM.contentEquals("AM")) {
            if (startAMorPM.contentEquals("AM")) {
                if (startHour > 1) {
                    for (int i = 0; i < endHour; i++) {
                        totalBill = totalBill + 20;
                    }
                } else {
                    for (int i = 0; i < endHour; i++) {
                        totalBill = totalBill + 20;
                    }
                }
            }
        }
        System.out.println(totalBill);
    }
}
