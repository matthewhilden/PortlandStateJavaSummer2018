package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall
{
    private String callerNumber;
    private String calleeNumber;
    private String startTime;
    private String endTime;

    // Default Constructor
    // Initializes all data members to null
    PhoneCall()
    {
        this.callerNumber = null;
        this.calleeNumber = null;
        this.startTime = null;
        this.endTime = null;
    }

    // Secondary Constructor
    // Initializes all data members to input values
    PhoneCall(String callerNumber, String calleeNumber, String startTime, String endTime)
    {
        this.callerNumber = callerNumber;
        this.calleeNumber = calleeNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Set Caller
    public void setCallerNumber(String callerNumber)
    {
        this.callerNumber = callerNumber;
    }

    // Set Callee
    public void setCalleeNumber(String calleeNumber)
    {
        this.calleeNumber = calleeNumber;
    }

    // Set StartTime
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    // Set EndTime
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    @Override
    public String getCaller()
    {
        return callerNumber;
    }

    @Override
    public String getCallee()
    {
        return calleeNumber;
    }

    @Override
    public String getStartTimeString()
    {
        return startTime;
    }

    @Override
    public String getEndTimeString()
    {
        return endTime;
    }
}
