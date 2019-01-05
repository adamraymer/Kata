package com.adamraymer.kata1;

public class BabySitter {
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(int checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    public int getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(int checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    private String startTime;
    private String endTime;
    private String startAMorPM;
    private String endAMorPM;
    private int checkStartTime;
    private int checkEndTime;



    public BabySitter (String enteredStartTime, String enteredEndTime){
        startTime = enteredStartTime;
        endTime = enteredEndTime;
        startAMorPM = startTime.substring(5,7);
        endAMorPM = endTime.substring(5,7);
        checkStartTime = Integer.parseInt(startTime.substring(1,2));
        checkEndTime = Integer.parseInt(endTime.substring(1,2));
    }


    public boolean checkTimeEntry (){
        return true;

    }


    public boolean checkAMPMOrder (){
        boolean checkOrder = true;
        if (startAMorPM.contentEquals("AM") && endAMorPM.contentEquals("PM")){
            checkOrder = false;
        }

        return checkOrder;
    }

    public boolean checkHourOrder () {
        boolean checkOrder = false;

        if ((startAMorPM.compareTo(endAMorPM) > 0)
                && (getCheckStartTime() > getCheckEndTime())
                && checkAMPMOrder ()) {
            checkOrder = true;
        }
            return checkOrder;
    }

    public boolean checkStartTime (){
        //this will check start time
        //check value first

        boolean checkStart = false;

        if (checkValidAMorPM(startAMorPM)){

            if (startAMorPM.contentEquals("PM")) {
                //check PM range
                if (validPMRange(checkStartTime)) {
                    return true;
                }
            } else if (validAMRange(checkStartTime)) {
                return true;
            }
        }

            return false;

    }

    public boolean checkEndTime (){
        //this will check end time
        //check value first

        //grab AM or PM
        boolean checkTime = false;
        if (checkValidAMorPM(endAMorPM)){

            if (endAMorPM.contentEquals("PM")) {
                //check PM range
                if (validPMRange(checkEndTime)) {checkTime = true;}
            } else if (validAMRange(checkEndTime)){checkTime = true;}
        }

        return checkTime;
    }

   public boolean checkValidAMorPM (String value){
        if (value.contentEquals("AM") || value.contentEquals("PM") ){
            return true;
        }
            return false;
    }

    public boolean validPMRange (int value){
        if ((value >= 5) && (value < 12)) {
            return true;
        }
            return false;

    }

    public boolean validAMRange (int value){
        if ((value == 12) || (value <= 4)){
            return true;
        }
            return false;

    }
}
