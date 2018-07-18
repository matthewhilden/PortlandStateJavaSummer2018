package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.*;

import static edu.pdx.cs410J.hilden.Project2.checkIfDateIsValid;
import static edu.pdx.cs410J.hilden.Project2.checkIfPhoneNumberIsValid;
import static edu.pdx.cs410J.hilden.Project2.checkIfTimeIsValid;

/**
 *  The TextParser class reads a text file and creates a new PhoneBill object containing PhoneCall(s)
 *  containing the information read from the text file
 */
public class TextParser implements PhoneBillParser<PhoneBill>
{
    private BufferedReader reader;
    String textFile;

    /**
     *  Default Constructor
     *  @param  textFile
     *          Name of the text file to read input data from
     */
    TextParser(String textFile)
    {
        this.textFile = textFile;
    }

    /**
     *  Read the input text file into PhoneCalls to add to a new PhoneBill object
     *  @return Returns a PhoneBill object
     *  @throws ParserException
     *          Signals that an error has been reached unexpectedly while parsing
     */
    @Override
    public PhoneBill parse() throws ParserException
    {
        PhoneBill bill = new PhoneBill();
        PhoneCall call = new PhoneCall();

        try
        {
            File file = new File(textFile);
            if (file.exists())
            {
                this.reader = new BufferedReader(new FileReader(textFile));
            }
            else
            {
                return bill;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

        String startTime = "";              // Storage for concatenation of start time and start date
        String endTime = "";                // Storage for concatenation of end time and end date

        String line;
        int i = 0;
        try
        {
            while ((line = reader.readLine()) != null)
            {
                switch (i)
                {
                    case 0:  if (line.equals(""))
                             {
                                 System.out.println("Customer Name is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             bill.setCustomerName(line);
                             i++;
                             break;

                    case 1:  if (checkIfPhoneNumberIsValid(line))
                             {
                                 call.setCallerNumber(line);
                                 i++;
                             }
                             else
                             {
                                 System.out.println("Caller Number is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    case 2:  if (checkIfPhoneNumberIsValid(line))
                             {
                                 call.setCalleeNumber(line);
                                 i++;
                             }
                             else
                             {
                                 System.out.println("Callee Number is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    case 3:  if (checkIfDateIsValid(line))
                             {
                                 startTime += line;
                                 i++;
                             }
                             else
                             {
                                 System.out.println("Start Time is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    case 4:  if (checkIfTimeIsValid(line))
                             {
                                 startTime += " " + line;
                                 call.setStartTime(startTime);
                                 i++;
                             }
                             else
                             {
                                 System.out.println("Start Time is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;
                    case 5:  if (checkIfDateIsValid(line))
                             {
                                 endTime += line;
                                 i++;
                             }
                             else
                             {
                                 System.out.println("End Time is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;
                    case 6:  if (checkIfTimeIsValid(line))
                             {
                                 endTime += " " + line;
                                 call.setEndTime(endTime);
                                 i++;
                             }
                             else
                             {
                                 System.out.println("End Time is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;
                    default: if (!line.equals(""))              // Scrub extra space - Don't count as invalid argument
                             {
                                 System.out.println("Invalid Number of Arguments! Exiting Program");
                                 System.exit(1);
                             }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        if (i != 7)
        {
            System.out.println("Invalid Number of Arguments! Exiting Program");
            System.exit(1);
        }
        bill.addPhoneCall(call);
        return bill;
    }
}
