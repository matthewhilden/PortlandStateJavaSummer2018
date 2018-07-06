package edu.pdx.cs410J.hilden;

        import org.junit.Test;

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
}
