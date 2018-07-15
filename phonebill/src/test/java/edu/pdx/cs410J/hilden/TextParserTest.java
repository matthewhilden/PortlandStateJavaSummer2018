package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import org.junit.Test;

public class TextParserTest
{
    @Test
    public void parseTextFile()
    {
        PhoneBill bill;
        TextParser parser = new TextParser("file");
        try
        {
            bill = parser.parse();
        }
        catch (ParserException e)
        {
            e.printStackTrace();
        }
    }
}
