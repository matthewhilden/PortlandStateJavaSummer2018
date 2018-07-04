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
    public void getStartTimeStringImplemented()
    {
        PhoneCall call = new PhoneCall("Doesn't Matter", "Doesn't Matter", "StartTime", "Doesn't Matter");
        assertThat(call.getStartTimeString(), containsString("StartTime"));
    }

    @Test
    public void getCalleeImplemented()
    {
        PhoneCall call = new PhoneCall("Doesn't Matter", "Callee", "Doesn't Matter", "Doesn't Matter");
        assertThat(call.getCallee(), containsString("Callee"));
    }

    @Test
    public void getStartTimeImplemented()
    {
        PhoneCall call = new PhoneCall();
        assertThat(call.getStartTime(), is(nullValue()));
    }

}
