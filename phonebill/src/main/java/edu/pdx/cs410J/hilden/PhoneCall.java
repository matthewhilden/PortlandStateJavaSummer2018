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
    public PhoneCall()
    {
        this.callerNumber = null;
        this.calleeNumber = null;
        this.startTime = null;
        this.endTime = null;
    }

    // Secondary Constructor
    // Initializes all data members to input values
    public PhoneCall(String callerNumber, String calleeNumber, String startTime, String endTime)
    {
        this.callerNumber = callerNumber;
        this.calleeNumber = calleeNumber;
        this.startTime = startTime;
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
