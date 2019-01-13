package com.adamraymer.kata1;

public class BabySitterFamilyB extends BabySitter {

    public BabySitterFamilyB(String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setEndMin(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5, 7));
        setEndAMorPM(enteredEndTime.substring(5, 7));
        setCheckStartTime(Integer.parseInt(enteredStartTime.substring(0, 2)));
        setCheckEndTime(Integer.parseInt(enteredEndTime.substring(0, 2)));
        setCheckStartTimeMin(Integer.parseInt(enteredStartTime.substring(3, 5)));
        setCheckEndTimeMin(Integer.parseInt(enteredEndTime.substring(3, 5)));

    }

    //Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night

    public int calcHourTotals(int totalBill) {
        int startHour;
        int endHour;
        String startAMorPM;
        String endAMorPM;
        boolean endTimeAM;
        boolean startTimeAM;
        int pmStopTime;
        int pmStartTime;

        startHour = super.getCheckStartTime();
        endHour = super.getCheckEndTime();
        startAMorPM = super.getStartAMorPM();
        endAMorPM = super.getEndAMorPM();

        endTimeAM = super.setEndTimeAM(endAMorPM);
        startTimeAM = super.setStartTimeAM(startAMorPM);


        if (endHour == startHour) {
            //start time and end time occur in the same hour
            if (startHour < 10) {
                totalBill = 12;
            } else if (startHour >= 10 && startHour <= 12){
                totalBill = 8;
            } else {totalBill = 16;}
        }

        //count number of billable hours. Need to check where any change from PM to AM would be
        if (startHour < 10 && !startTimeAM) {
            if (endHour < 10 && !endTimeAM) {
                pmStopTime = endHour;
            } else { pmStopTime = 10; }

         //find hours billed for 5pm to 10pm
            for (int i = startHour; i < pmStopTime; i++) {
                totalBill = totalBill + 12;
            }

            if (endHour <= 10 && !endTimeAM && getEndMin() > 1) {
                //add one more hour for partial hour
                totalBill = totalBill + 12;
            }
        }

        if ((startHour >= 10 && startHour <= 12 && endTimeAM) || (endHour >= 10 && endHour <= 12)) {
            //add range of 10:00PM to 12:00AM if endTime falls in that range
            if (startHour >= 10 && !startTimeAM) {
                pmStartTime = startHour;
            } else { pmStartTime = 10; }

            if (endHour >= 10 && endHour <= 12){
                pmStopTime = endHour;
            } else { pmStopTime = 12; }

            for (int i = pmStartTime; i < pmStopTime; i++) {
                totalBill = totalBill + 8;
            }

            if (endHour == 12 && getEndMin() > 1 ) {
                //hour over lap into 12:00 to 12:59 range
                totalBill = totalBill + 16;
            } else if (endHour <= 12 && getEndMin() > 1 && !endTimeAM){
                totalBill = totalBill + 8;
            }
        }

        if (endHour >= 1 && endTimeAM) {
            int thirdTier = 0;

            if (startTimeAM && startHour < 12) {
                thirdTier = startHour;
            }

            for (int i = thirdTier; i < endHour; i++) {
                totalBill = totalBill + 16;
            }

            if (getEndMin() > 1 ) {
                totalBill = totalBill + 16;
            }

        }

        return totalBill;
    }


}
