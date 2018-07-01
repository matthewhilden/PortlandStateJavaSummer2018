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
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getCallee()
    {
        return "This method is not implemented yet";
    }

    @Override
    public String getStartTimeString()
    {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getEndTimeString()
    {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
