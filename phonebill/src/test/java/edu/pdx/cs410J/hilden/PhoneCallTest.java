package edu.pdx.cs410J.hilden;

import org.junit.Test;

import static edu.pdx.cs410J.hilden.Project1.checkIfDateIsValid;
import static edu.pdx.cs410J.hilden.Project1.checkIfPhoneNumberIsValid;
import static edu.pdx.cs410J.hilden.Project1.checkIfTimeIsValid;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 */
public class PhoneCallTest
{

    @Test
    public void getCallerImplemented()
    {
        PhoneCall call = new PhoneCall("Caller", "Doesn't Matter", "Doesn't Matter", "Doesn't Matter");
        assertThat(call.getCaller(), containsString("Caller"));
    }

    @Test
    public void getCalleeImplemented()
    {
        PhoneCall call = new PhoneCall("Doesn't Matter", "Callee", "Doesn't Matter", "Doesn't Matter");
        assertThat(call.getCallee(), containsString("Callee"));
    }

    @Test
    public void getStartTimeStringImplemented()
    {
        PhoneCall call = new PhoneCall("Doesn't Matter", "Doesn't Matter", "StartTime", "Doesn't Matter");
        assertThat(call.getStartTimeString(), containsString("StartTime"));
    }

    @Test
    public void getEndTimeStringImplemented()
    {
        PhoneCall call = new PhoneCall("Doesn't Matter", "Doesn't Matter", "Doesn't Matter", "EndTime");
        assertThat(call.getEndTimeString(), containsString("EndTime"));
    }

    @Test
    public void setCallerNumberImplemented()
    {
        PhoneCall call = new PhoneCall();
        call.setCallerNumber("CallerNumber");
        assertThat(call.getCaller(), containsString("CallerNumber"));
    }

    @Test
    public void setCalleeNumberImplemented()
    {
        PhoneCall call = new PhoneCall();
        call.setCalleeNumber("CalleeNumber");
        assertThat(call.getCallee(), containsString("CalleeNumber"));
    }

    @Test
    public void setStartTimeImplemented()
    {
        PhoneCall call = new PhoneCall();
        call.setStartTime("StartTime");
        assertThat(call.getStartTimeString(), containsString("StartTime"));
    }

    @Test
    public void setEndTimeImplemented()
    {
        PhoneCall call = new PhoneCall();
        call.setEndTime("EndTime");
        assertThat(call.getEndTimeString(), containsString("EndTime"));
    }

    @Test
    public void checkValidPhoneNumbers()
    {
        String phoneNumber = "555-555-5555";
        assertTrue(checkIfPhoneNumberIsValid(phoneNumber));
    }

    @Test
    public void checkValidDate()
    {
        String date = "07/06/2018";
        assertTrue(checkIfDateIsValid(date));
    }

    @Test
    public void checkValidTime()
    {
        String time = "4:58";
        assertTrue(checkIfTimeIsValid(time));
    }
}
