package com.adamraymer.kata1;

public class BabySitter {
    private String startTime;
    private String endTime;


    public BabySitter (String enteredStartTime, String enteredEndTime){
        startTime = enteredStartTime;
        endTime = enteredEndTime;
    }

    public boolean checkStartTime (){
        //this will check start time
        //check value first
        int checkStartTime = Integer.parseInt(startTime.substring(1,2));
        String amOrPM;

        //grab AM or PM

        if (checkValidAMorPM(startTime.substring(5,7))){
            amOrPM = startTime.substring(5,7);

            if (amOrPM.contentEquals("PM")) {
                //check PM range
                if (validPMRange(checkStartTime)) {
                    return true;
                }
            }
        }

            return false;

    }

    public boolean checkEndTime (){
        //this will check end time
        return true;
    }

   public boolean checkValidAMorPM (String value){
        if (value.contentEquals("AM") || value.contentEquals("PM") ){
            return true;
        } else {
            return false;
        }
    }

    public boolean validPMRange (int value){
        if ((value >= 5) && (value < 12)){
            return true;
        } else {
            return false;
        }
    }
}