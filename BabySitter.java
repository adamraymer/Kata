package com.adamraymer.kata1;

public class BabySitter {

    private String startTime;
    private String endTime;
    private String startAMorPM;
    private String endAMorPM;
    private int checkStartTime;
    private int checkEndTime;

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

    public void setStartAMorPM(String startAMorPM) {
        this.startAMorPM = startAMorPM;
    }

    public void setEndAMorPM(String endAMorPM) {
        this.endAMorPM = endAMorPM;
    }

    protected String getStartAMorPM() {
        return startAMorPM;
    }

    protected String getEndAMorPM() {
        return endAMorPM;
    }

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
                && (getCheckEndTime() > getCheckStartTime())
                && checkAMPMOrder()) {
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


            } else {checkStart = validAMRange(checkStartTime);}
        }

            return checkStart;

    }

    public boolean checkEndTime (){
        //this will check end time
        //check value first

        //grab AM or PM
        boolean checkEnd = false;
        if (checkValidAMorPM(endAMorPM)){

            if (endAMorPM.contentEquals("PM")) {
                //check PM range
                checkEnd = validPMRange(checkEndTime);
            } else {checkEnd = validAMRange(checkEndTime);}
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

    private boolean validAMRange (int value){

        boolean validAMRange = false;
        if ((value == 12) || (value <= 4))
            validAMRange = true;

            return validAMRange;

    }
}
