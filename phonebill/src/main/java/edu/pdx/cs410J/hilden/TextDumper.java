package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.PhoneBillDumper;
import java.io.IOException;


/**
 *  The TextDumper class dumps the content of a PhoneBill object to a text file
 */
public class TextDumper implements PhoneBillDumper<PhoneBill>
{
    /**
     *  Default Constructor
     *  Does not take any input parameters
     */
    public TextDumper()
    {

    }


    /**
     *  Dumps the contents of a PhoneBill to a text file
     *  @param  phoneBill
     *          The PhoneBill object to dump to the text file
     */
    @Override
    public void dump(PhoneBill phoneBill) throws IOException
    {

    }
}
