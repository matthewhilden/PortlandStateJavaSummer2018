package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  The TextDumper class dumps the content of a PhoneBill object to a text file
 */
public class TextDumper implements PhoneBillDumper<PhoneBill>
{
    private BufferedWriter writer;

    /**
     *  Default Constructor
     *  @param  textFile
     *          Name of the text file to write output data from
     */
    TextDumper(String textFile)
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

    /**
     *  Dumps the contents of a PhoneBill to a text file
     *  @param  phoneBill
     *          The PhoneBill object to dump to the text file
     *  @throws IOException
     *          Signals that an I/O exception of some sort has occurred
     */
    @Override
    public void dump(PhoneBill phoneBill) throws IOException
    {
        writer.write(phoneBill.getCustomer() + "\n");

        for (PhoneCall call : phoneBill.getPhoneCalls())
        {
            String caller = call.getCaller();
            if (caller != null)
            {
                writer.write(call.getCaller() + "\n");
            }
            else
            {
                System.out.println("Caller is Null! Exiting Program");
                System.exit(1);
            }
            String callee = call.getCallee();
            if (callee != null)
            {
                writer.write(call.getCallee() + "\n");
            }
            else
            {
                System.out.println("Callee is Null! Exiting Program");
                System.exit(1);
            }
            String startTime = call.getStartTimeString();
            if (startTime != null)
            {
                int index = startTime.indexOf(" ");
                if (index != -1)
                {
                    writer.write(startTime.substring(0, index) + "\n");
                    writer.write(startTime.substring(index + 1) + "\n");
                }
                else
                {
                    System.out.println("Invalid Start Time! Exiting Program");
                    System.exit(1);
                }
            }
            else
            {
                System.out.println("Start Time is Null! Exiting Program");
                System.exit(1);
            }
            String endTime = call.getEndTimeString();
            if (endTime != null)
            {
                int index = endTime.indexOf(" ");
                if (index != -1)
                {
                    writer.write(endTime.substring(0, index) + "\n");
                    writer.write(endTime.substring(index + 1) + "\n");
                }
                else
                {
                    System.out.println("Invalid End Time! Exiting Program");
                    System.exit(1);
                }
            }
            else
            {
                System.out.println("End Time is Null! Exiting Program");
                System.exit(1);
            }
        }
        writer.close();
    }
}
