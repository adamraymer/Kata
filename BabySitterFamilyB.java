package com.adamraymer.kata1;

public class BabySitterFamilyB extends BabySitter {

    public BabySitterFamilyB(String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5, 7));
        setEndAMorPM(enteredEndTime.substring(5, 7));

    }

    //Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night

    public int calcHourTotals(int totalBill) {
        int startHour;
        int endHour;
        String startAMorPM;
        String endAMorPM;
        String endTime;
        boolean endTimeAM;
        boolean startTimeAM;
        int pmStopTime;
        int pmStartTime;

        startHour = super.getCheckStartTime();
        endHour = super.getCheckEndTime();
        startAMorPM = super.getStartAMorPM();
        endAMorPM = super.getEndAMorPM();
        endTime = super.getEndTime();


        endTimeAM = setEndTimeAM(endAMorPM);
        startTimeAM = setStartTimeAM(startAMorPM);
        pmStopTime = setPMStopTime(endTimeAM, endHour);

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

            if ((endHour <= 10) && (!endTimeAM) && (Integer.parseInt(endTime.substring(3, 5)) > 1)) {
                //add one more hour for partial hour
                totalBill = totalBill + 12;
            }
        }

        if ((startHour >= 10 && startHour <= 12) || (endHour >= 10 && endHour <= 12) || (startHour >=5 && endTimeAM == true)) {
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

            if (endHour == 12 && Integer.parseInt(endTime.substring(3, 5)) > 1 ) {
                //hour over lap into 12:00 to 12:59 range
                totalBill = totalBill + 16;
            } else if (endHour <= 12 && Integer.parseInt(endTime.substring(3, 5)) > 1 && !endTimeAM){
                totalBill = totalBill + 8;
            }
        }

        if (endHour >= 1) {
            int thirdTier = 0;

            if (startTimeAM == true && startHour < 12) {
                thirdTier = startHour;
            }

            for (int i = thirdTier; i < endHour; i++) {
                totalBill = totalBill + 16;
            }

            if (Integer.parseInt(endTime.substring(3, 5)) > 1 ) {
                totalBill = totalBill + 16;
            }

        }

        return totalBill;
    }

    private boolean setEndTimeAM(String endAMorPM) {
        boolean endTimeAM = false;
        if (endAMorPM.contentEquals("AM")) {
            endTimeAM = true;
        }

        return endTimeAM;
    }

    private boolean setStartTimeAM (String startAMorPM) {
        boolean startTimeAM = false;
        if (startAMorPM.contentEquals("AM")) {
            startTimeAM = true;
        }

        return startTimeAM;
    }

    private int setPMStopTime (boolean endTimeAM, int endHour) {
        int pmStopTime;
        if (endHour < 10) {
            pmStopTime = 11;
        } else {
            pmStopTime = endHour;
        }

        return pmStopTime;
    }
}
