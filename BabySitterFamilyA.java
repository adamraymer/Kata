package com.adamraymer.kata1;

public class BabySitterFamilyA extends BabySitter {

    public BabySitterFamilyA(String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setEndMin(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5, 7));
        setEndAMorPM(enteredEndTime.substring(5, 7));

    }

    //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night

    public int calcHourTotals(int totalBill) {
        int startHour;
        int endHour;
        String startAMorPM;
        String endAMorPM;
        boolean endTimeAM;
        boolean startTimeAM;
        int pmStopTime;

        startHour = super.getCheckStartTime();
        endHour = super.getCheckEndTime();
        startAMorPM = super.getStartAMorPM();
        endAMorPM = super.getEndAMorPM();

        endTimeAM = super.setEndTimeAM(endAMorPM);
        startTimeAM = super.setStartTimeAM(startAMorPM);
        pmStopTime = setPMStopTime(endTimeAM, endHour);

        if (endHour == startHour) {
            //start time and end time occur in the same hour
            if (startHour < 11) {
                totalBill = 15;
            } else {
                totalBill = 20;
            }
        }

        //count number of billable hours. Need to check where any change from PM to AM would be
        if ((endHour <= 11 || endTimeAM) && startHour <= 5) {
            for (int i = startHour; i < pmStopTime; i++) {
                totalBill = totalBill + 15;
            }

            if (endHour != 11 && !endTimeAM && getEndMin() > 1) {
                //add one more hour for partial hour
                totalBill = totalBill + 15;
            }
        }

        if ((endHour == 11 && getEndMin() > 1) || (!startTimeAM && endTimeAM)) {
            //add range of 11:00 to 11:59 if endTime falls in that range
            totalBill = totalBill + 20;
        }

        if (endTimeAM) {
            if (!startTimeAM) {
                //this covers 11:00PM to 11:59PM
                // totalBill = totalBill +20;
                if (endHour == 12 && getEndMin() > 1) {
                    totalBill = totalBill + 20;
                } else {
                    for (int i = 0; i <= endHour; i++) {
                        //midnight to end time
                        totalBill = totalBill + 20;
                    }
                }
            }
            if (startTimeAM) {
                //if startHour is 1AM or later
                if (startHour >= 1 && startHour <= 4) {
                    for (int i = startHour; i <= endHour; i++) {
                        totalBill = totalBill + 20;
                    }
                } else {
                    for (int i = 0; i <= endHour; i++) {
                        //midnight to end time
                        totalBill = totalBill + 20;
                    }
                }
            }
        }
        return totalBill;
    }

    private int setPMStopTime (boolean endTimeAM, int endHour) {
        int pmStopTime;
        if (endTimeAM) {
            pmStopTime = 11;
        } else {
            pmStopTime = endHour;
        }

        return pmStopTime;
    }
}
