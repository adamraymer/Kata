package com.adamraymer.kata1;

//Family A babysitter calculation

public class BabySitterFamilyA extends BabySitter {

    public BabySitterFamilyA(String enteredStartTime, String enteredEndTime) {
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

    //Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night

    protected int calcHourTotals(int totalBill) {
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

        if (endHour == startHour) {
            //start time and end time occur in the same hour
            if ((startHour < 11 && !startTimeAM)) {
                totalBill = 15;
            } else {
                totalBill = 20;
            }
        } else {
            if (!startTimeAM) {
                if (!endTimeAM && endHour < 11) {
                    pmStopTime = endHour;
                } else {
                    pmStopTime = 11;
                }

                for (int i = startHour; i < pmStopTime; i++) {
                    totalBill = totalBill + 15;
                }

                if (endHour < 11 && getEndMin() > 1) {
                    //add one more hour for partial hour
                    totalBill = totalBill + 15;
                }
            }


            if (endHour >= 11) {
                // if endHour >= 9 then it is PM due to range constraints
                for (int i = 11; i < endHour; i++) {
                    totalBill = totalBill + 20;
                }
                if (getEndMin() > 1) {
                    //add one more hour for partial hour
                    totalBill = totalBill + 20;
                }
            } else if (endTimeAM) {
                //endHour is between 1 to 4
                //add one hour to cover 11PM to 12AM if start time was PM
                if (!startTimeAM) {
                    totalBill = totalBill + 20;

                    for (int i = 0; i < endHour; i++) {
                        totalBill = totalBill + 20;
                    }
                } else {
                    //AM start time
                    if (startHour == 12) {
                        startHour = 0;
                    }
                    //time period between 1AM and 4AM
                    for (int i = startHour; i < endHour; ++i) {
                        totalBill = totalBill + 20;
                    }

                }

                if (getEndMin() > 1) {
                    //add one more hour for partial hour
                    totalBill = totalBill + 20;
                }
            }
        }

        return totalBill;
    }

    public void resetFamilyAValues(String enteredStartTime, String enteredEndTime) {
        //this is used if new data is given after object creation
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
}
