package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.pdx.cs410J.hilden.Project3.checkIfDateIsValid;
import static edu.pdx.cs410J.hilden.Project3.checkIfPhoneNumberIsValid;
import static edu.pdx.cs410J.hilden.Project3.checkIfTimeIsValid;

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

        String startTime = "";
        String endTime = "";

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
                                 System.out.println("Customer Name in file is Invalid! Exiting Program");
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
                                 System.out.println("Caller Number in file is Invalid! Exiting Program");
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
                                 System.out.println("Callee Number in file is Invalid! Exiting Program");
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
                                 System.out.println("Start Time in file is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    case 4:  if (checkIfTimeIsValid(line))
                             {
                                 startTime += " " + line;
                                 DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
                                 try
                                 {
                                     Date startDate = df.parse(startTime);
                                     call.setStartTime(startDate);
                                 }
                                 catch (ParseException p)
                                 {
                                     System.out.println(p);
                                 }
                                 i++;
                             }
                             else
                             {
                                 System.out.println("Start Time in file is Invalid! Exiting Program");
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
                                 System.out.println("End Time in file is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    case 6:  if (checkIfTimeIsValid(line))
                             {
                                 endTime += " " + line;
                                 DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
                                 try
                                 {
                                     Date endDate = df.parse(endTime);
                                     call.setStartTime(endDate);
                                 }
                                 catch (ParseException p)
                                 {
                                     System.out.println(p);
                                 }
                                 i++;
                             }
                             else
                             {
                                 System.out.println("End Time in file is Invalid! Exiting Program");
                                 System.exit(1);
                             }
                             break;

                    default: if (!line.equals(""))
                             {
                                 System.out.println("Invalid Number of Arguments in file! Exiting Program");
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
            System.out.println("Invalid Number of Arguments in file! Exiting Program");
            System.exit(1);
        }
        bill.addPhoneCall(call);
        return bill;
    }
}
