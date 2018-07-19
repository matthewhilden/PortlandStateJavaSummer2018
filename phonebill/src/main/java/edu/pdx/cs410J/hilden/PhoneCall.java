package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.Date;

/**
 *  The PhoneCall class represents a PhoneCall object that contains information regarding a single PhoneCall
 */
public class PhoneCall extends AbstractPhoneCall
{
    private String callerNumber;
    private String calleeNumber;
    private String startTime;
    private String endTime;

    /**
     *  Creates a new PhoneCall
     *  Does not take any parameters
      */
    PhoneCall()
    {
        this.callerNumber = null;
        this.calleeNumber = null;
        this.startTime = null;
        this.endTime = null;
    }

    /**
     *  Creates a new PhoneCall. Takes parameters for all fields in the PhoneCall object
     *  @param  callerNumber
     *          Phone number of the person making the call
     *  @param  calleeNumber
     *          Phone number of the person receiving the call
     *  @param  startTime
     *          The time at which the phone call began
     *  @param  endTime
     *          The time at which the phone call ended
     */
    PhoneCall(String callerNumber, String calleeNumber, String startTime, String endTime)
    {
        this.callerNumber = callerNumber;
        this.calleeNumber = calleeNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     *  Sets the callerNumber field to the input value
     *  @param  callerNumber
     *          The number of the person making the call
     */
    public void setCallerNumber(String callerNumber)
    {
        this.callerNumber = callerNumber;
    }

    /**
     *  Sets the calleeNumber field to the input value
     *  @param  calleeNumber
     *          Phone number of the person receiving the call
     */
    public void setCalleeNumber(String calleeNumber)
    {
        this.calleeNumber = calleeNumber;
    }

    /**
     *  Sets the startTime field to the input value
     *  @param  startTime
     *          The time at which the phone call began
     */
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    /**
     *  Sets the endTime field to the input value
     *  @param  endTime
     *          The time at which the phone call ended
     */
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    /**
     *  Gets the phone number of the person making the call
     *  @return Returns the callerNumber field
     */
    @Override
    public String getCaller()
    {
        return callerNumber;
    }

    /**
     *  Gets the phone number of the person receiving the call
     *  @return Returns the calleeNumber field
     */
    @Override
    public String getCallee()
    {
        return calleeNumber;
    }

    /**
     *  Gets the start time of the phone call
     *  @return Returns the startTime field
     */
    @Override
    public String getStartTimeString()
    {
        return startTime;
    }

    /**
     *  Gets the end time of the phone call
     *  @return Returns the endTime field
     */
    @Override
    public String getEndTimeString()
    {
        return endTime;
    }

    @Override
    public Date getStartTime()
    {
        return null;
    }

    @Override
    public Date getEndTime()
    {
        return null;
    }
}
