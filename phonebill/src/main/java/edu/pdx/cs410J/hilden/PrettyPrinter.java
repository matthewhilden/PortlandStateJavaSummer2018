package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.PhoneBillDumper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
            File file = new File(textFile);
            if (!file.exists())
            {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
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
     *          ignals that an I/O exception of some sort has occurred
     */
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
            String customerName = phoneBill.getCustomer();
            if (customerName == null || customerName.equals(""))
            {
                System.out.println("Invalid Customer name! Exiting Program");
            }
            else
            {
                writer.write(phoneBill.getCustomer() + "\n\n");
            }
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
                    writer.write(startTime + "\n");
                }
                else
                {
                    System.out.println("Start Time is Null! Exiting Program");
                    System.exit(1);
                }
                String endTime = call.getEndTimeString();
                if (endTime != null)
                {
                    writer.write(endTime + "\n");
                }
                else
                {
                    System.out.println("End Time is Null! Exiting Program");
                    System.exit(1);
                }
                long callDuration = call.getEndTime().getTime() - call.getStartTime().getTime();
                writer.write("Call Duration: " + TimeUnit.MILLISECONDS.toMinutes(callDuration) + " minutes\n\n");
            }
            writer.close();
        }
    }
}
