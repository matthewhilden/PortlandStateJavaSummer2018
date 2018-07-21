package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.DateFormat;
import java.util.Date;

/**
 *  The PhoneCall class represents a PhoneCall object that contains information regarding a single PhoneCall
 */
public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall>
{
    private String callerNumber;
    private String calleeNumber;
    private Date startTime;
    private Date endTime;

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
     *          The time/date at which the phone call began
     *  @param  endTime
     *          The time/date at which the phone call ended
     */
    PhoneCall(String callerNumber, String calleeNumber, Date startTime, Date endTime)
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
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    /**
     *  Sets the endTime field to the input value
     *  @param  endTime
     *          The time at which the phone call ended
     */
    public void setEndTime(Date endTime)
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
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return df.format(startTime);
    }

    /**
     *  Gets the end time of the phone call
     *  @return Returns the endTime field
     */
    @Override
    public String getEndTimeString()
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return df.format(endTime);
    }

    @Override
    public Date getStartTime()
    {
        return startTime;
    }

    @Override
    public Date getEndTime()
    {
        return endTime;
    }

    @Override
    public int compareTo(PhoneCall phoneCall)
    {
        if (this.getStartTime().before(phoneCall.getStartTime()))
        {
            return -1;
        }
        else if (this.getStartTime().after(phoneCall.getStartTime()))
        {
            return 1;
        }
        else
        {
            if (this.getCaller().compareTo(phoneCall.getCaller()) < 0)
            {
                return -1;
            }
            else if (this.getCaller().compareTo(phoneCall.getCaller()) > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
