package com.adamraymer.kata1;

public class BabySitterFamilyA extends BabySitter {




    public BabySitterFamilyA(String enteredStartTime, String enteredEndTime) {
        setStartTime(enteredStartTime);
        setEndTime(enteredEndTime);
        setStartAMorPM(enteredStartTime.substring(5, 7));
        setEndAMorPM(enteredEndTime.substring(5, 7));

    }

    //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night

    public int calcHourTotals(int totalBill) {
        int startHour = 0;
        int endHour = 0;
        String startAMorPM;
        String endAMorPM;
        String endTime;
        
        startHour = super.getCheckStartTime();
        endHour = super.getCheckEndTime();
        startAMorPM = super.getStartAMorPM();
        endAMorPM = super.getEndAMorPM();
        endTime = super.getEndTime();
        boolean endTimeAM;
        boolean startTimeAM = false;
        int pmStopTime;

        endTimeAM = setEndTimeAM(endAMorPM);
        startTimeAM = setStartTimeAM(startAMorPM);
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
        if ((endHour <= 11) || (endTimeAM)) {
            for (int i = startHour; i < pmStopTime; i++) {
                totalBill = totalBill + 15;
            }

            if ((endHour != 11) && (!endTimeAM) && (Integer.parseInt(endTime.substring(3, 5)) > 1)) {
                //add one more hour for partial hour
                totalBill = totalBill + 15;
            }
        }

        if ((endHour == 11) && (Integer.parseInt(endTime.substring(3, 5)) > 1) ||
                ((!startTimeAM) && (endTimeAM))) {
            //add range of 11:00 to 11:59 if endTime falls in that range
            totalBill = totalBill + 20;
        }

        if (endAMorPM.contentEquals("AM")) {
            if (startAMorPM.contentEquals("PM")) {
                //this covers 11:00PM to 11:59PM
                // totalBill = totalBill +20;
                if (endHour == 12 && Integer.parseInt(endTime.substring(3, 5)) > 1) {
                    totalBill = totalBill + 20;
                } else {
                    for (int i = 0; i <= endHour; i++) {
                        //midnight to end time
                        totalBill = totalBill + 20;
                    }
                }
            }
            if (startAMorPM.contentEquals("AM")) {
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
        int pmStopTime = 0;
        if (endTimeAM) {
            pmStopTime = 11;
        } else {
            pmStopTime = endHour;
        }

        return pmStopTime;
    }
}
