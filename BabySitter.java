package com.adamraymer.kata1;

public class BabySitter {

    private String startTime;
    private String endTime;
    private String startAMorPM;
    private String endAMorPM;
    private int checkStartTime;
    private int checkEndTime;
    private int checkStartTimeMin;
    private int checkEndTimeMin;
    private int endMin;


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    protected int getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(int checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    protected int getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(int checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    protected int getCheckStartTimeMin() {
        return checkStartTimeMin;
    }

    public void setCheckStartTimeMin(int checkStartTimeMin) {
        this.checkStartTimeMin = checkStartTimeMin;
    }

    protected int getCheckEndTimeMin() {
        return checkEndTimeMin;
    }

    public void setCheckEndTimeMin(int checkEndTimeMin) {
        this.checkEndTimeMin = checkEndTimeMin;
    }

    public void setStartAMorPM(String startAMorPM) {
        //this will always be set to uppercase for functionality and conformity
        this.startAMorPM = startAMorPM.toUpperCase();
    }

    public void setEndAMorPM(String endAMorPM) {
        //this will always be set to uppercase for functionality and conformity
        this.endAMorPM = endAMorPM.toUpperCase();
    }

    protected String getStartAMorPM() {
        return startAMorPM;
    }

    protected String getEndAMorPM() {
        return endAMorPM;
    }

    protected void setEndMin (String endTime) { this.endMin = Integer.parseInt(endTime.substring(3, 5));}

    protected int getEndMin () {return endMin;}


    public BabySitter (String enteredStartTime, String enteredEndTime){
        startTime = enteredStartTime;
        endTime = enteredEndTime;
        startAMorPM = startTime.substring(5,7);
        endAMorPM = endTime.substring(5,7);

    }

    public BabySitter (){
        startTime = "00:00AM";
        endTime = "00:00PM";
        startAMorPM = startTime.substring(5,7);
        endAMorPM = endTime.substring(5,7);

    }
    private boolean checkAMPMOrder (){
        boolean checkOrder = true;
        if (startAMorPM.contentEquals("AM") && endAMorPM.contentEquals("PM")){
            checkOrder = false;
        }

        return checkOrder;
    }

    public boolean checkHourOrder () {
        boolean checkOrder = false;

        if ((startAMorPM.compareTo(endAMorPM) == 0)
                && ((getCheckEndTime() > getCheckStartTime()) || ((getCheckEndTime() == getCheckStartTime()) && (getCheckEndTimeMin() > getCheckStartTimeMin()) ))
                && checkAMPMOrder()) {
            // if start and end times are both AM or both PM
            checkOrder = true;
        } else if (checkAMPMOrder()){
            // if the start time is PM and the end time is AM then it is still in order
            // example: 11PM is before 2AM
            checkOrder = true;
        }
            return checkOrder;
    }

    //remove AMorPM check once the interface is created. Should be able to do it there
    public boolean checkStartTime (){
        //this will check start time
        //check value first

        boolean checkStart = false;

        if (checkValidAMorPM(startAMorPM)){

            if (startAMorPM.contentEquals("PM")) {
                //check PM range
                checkStart = validPMRange(checkStartTime);


            } else {checkStart = validAMRange(checkStartTime, 0);}
        }

            return checkStart;

    }

    public boolean checkEndTime (){
        //this will check end time
        //check value first

        //grab AM or PM
        boolean checkEnd = false;
        if (checkValidAMorPM(endAMorPM)){

            if (endAMorPM.toUpperCase().contentEquals("PM")) {
                //check PM range
                checkEnd = validPMRange(checkEndTime);
            } else {checkEnd = validAMRange(checkEndTime, endMin);}
        }

        return checkEnd;
    }

   private boolean checkValidAMorPM (String value){

        boolean validAMorPM = false;
        if (value.contentEquals("AM") || value.contentEquals("PM") )
            validAMorPM = true;

            return validAMorPM;
    }

    private boolean validPMRange (int value){

        boolean validPMRange = false;
        if ((value >= 5) && (value < 12))
            validPMRange = true;

            return validPMRange;

    }

    private boolean validAMRange (int hour, int min){

        boolean validAMRange = false;
        if ((hour == 12) || (hour <= 4)) {
            //any value greater than 1 for min and hour = 4 would put it past 4AM
            if (hour != 4 || min == 0) {
                validAMRange = true;
            }
        }

            return validAMRange;

    }

    protected boolean setEndTimeAM(String endAMorPM) {
        boolean endTimeAM = false;
        if (endAMorPM.contentEquals("AM")) {
            endTimeAM = true;
        }

        return endTimeAM;
    }

    protected boolean setStartTimeAM (String startAMorPM) {
        boolean startTimeAM = false;
        if (startAMorPM.contentEquals("AM")) {
            startTimeAM = true;
        }

        return startTimeAM;
    }

    protected boolean validHourRange () {
        boolean validHourRange = false;
        if(checkStartTime() && checkEndTime() && checkHourOrder())
            validHourRange = true;

        return validHourRange;
    }
}
