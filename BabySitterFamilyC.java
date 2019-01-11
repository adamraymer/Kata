package com.adamraymer.kata1;

public class BabySitterFamilyC extends BabySitter{


        public BabySitterFamilyC(String enteredStartTime, String enteredEndTime) {
            setStartTime(enteredStartTime);
            setEndTime(enteredEndTime);
            setEndMin(enteredEndTime);
            setStartAMorPM(enteredStartTime.substring(5, 7));
            setEndAMorPM(enteredEndTime.substring(5, 7));

        }

        //Family C pays $21 per hour before 9pm, then $15 the rest of the night

        public int calcHourTotals(int totalBill) {
            int startHour;
            int endHour;
            String startAMorPM;
            String endAMorPM;
            boolean endTimeAM;
            boolean startTimeAM;


            startHour = super.getCheckStartTime();
            endHour = super.getCheckEndTime();
            startAMorPM = super.getStartAMorPM();
            endAMorPM = super.getEndAMorPM();

            endTimeAM = super.setEndTimeAM(endAMorPM);
            startTimeAM = super.setStartTimeAM(startAMorPM);


            if (endHour == startHour) {
                //start time and end time occur in the same hour
                if (startHour < 9) {
                    totalBill = 21;
                } else {
                    totalBill = 15;
                }
            }

            //count number of billable hours. Need to check where any change from PM to AM would be
            if ((endHour < 9 || endTimeAM) && !startTimeAM) {
                for (int i = startHour; i < endHour; i++) {
                    totalBill = totalBill + 21;
                }

                if (endHour < 9 && getEndMin() > 1) {
                    //add one more hour for partial hour
                    totalBill = totalBill + 21;
                }
            }


            if (endHour >= 9) {
                // if endHour >= 9 then it is PM due to range constraints
                for (int i = 9; i <= endHour; i++ ){
                    totalBill = totalBill + 15;
                }
            } else if (endTimeAM) {
                //endHour is between 1 to 4
                //add three hours to cover 9PM to 12AM
                totalBill = totalBill + 45;

                for (int i = 0; i <= endHour; i++) {
                    totalBill = totalBill + 15;
                }
            }
            if ((endHour == 9 && getEndMin() > 1) || (!startTimeAM && endTimeAM)) {
                //add range of 9:00 to :59 if endTime falls in that range
                totalBill = totalBill + 15;
            }

            return totalBill;
        }

}

