package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

/**
 *  The TextParser class reads a text file and creates a new PhoneBill object containing PhoneCall(s)
 *  containing the information read from the text file
 */
public class TextParser implements PhoneBillParser<PhoneBill>
{

    /**
     *  Default Constructor
     *  Does not take parameters
     */
    public TextParser()
    {

    }

    /**
     *  Read the input text file into PhoneCalls to add to a new PhoneBill object
     *  @return Returns a PhoneBill object
     *  @throws ParserException
     */
    @Override
    public PhoneBill parse() throws ParserException
    {

        return null;
    }
}
