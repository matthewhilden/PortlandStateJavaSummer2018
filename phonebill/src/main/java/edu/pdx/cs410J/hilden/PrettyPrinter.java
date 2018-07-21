package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrettyPrinter implements PhoneBillDumper<PhoneBill>
{
    private BufferedWriter writer;

    /**
     *  Default Constructor
     *  @param  textFile
     *          Name of the text file to write output data to
     */
    PrettyPrinter(String textFile)
    {
        try
        {
            writer = new BufferedWriter(new FileWriter(textFile));
        }
        catch (IOException i)
        {
            System.out.println(i);
        }
    }

    @Override
    public void dump(PhoneBill phoneBill) throws IOException
    {
        if (phoneBill == null)
        {
            System.out.println("PhoneBill does not exist! Exiting program");
            System.exit(1);
        }
        else
        {

        }
    }
}
