package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.pdx.cs410J.hilden.Project3.*;

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

        String line;
        boolean readInput = false;
        try
        {
            line = reader.readLine();
            if (line != null)
            {
                bill.setCustomerName(line);
            }

            while ((line = reader.readLine()) != null)
            {
                PhoneCall call = new PhoneCall();
                if (checkIfPhoneNumberIsValid(line))
                {
                    call.setCallerNumber(line);
                }
                else
                {
                    System.out.println("Caller Number in file is Invalid! Exiting Program");
                    System.exit(1);
                }

                line = reader.readLine();
                if (line != null)
                {
                    if (checkIfPhoneNumberIsValid(line))
                    {
                        call.setCalleeNumber(line);
                    }
                    else
                    {
                        System.out.println("Callee Number in file is Invalid! Exiting Program");
                        System.exit(1);
                    }
                }
                else
                {
                    System.out.println("Missing Argument in file! Exiting Program");
                    System.exit(1);
                }

                String startTime = reader.readLine();
                Date startDate = new Date();
                if (startTime != null)
                {
                    int startTimeFirstSpace = startTime.indexOf(" ");
                    int startTimeSecondSpace = startTime.lastIndexOf(" ");
                    if (checkIfDateIsValid(startTime.substring(0, startTimeFirstSpace)))
                    {
                        if (checkIfTimeIsValid(startTime.substring(startTimeFirstSpace + 1, startTimeSecondSpace)))
                        {
                            if (checkIfAmPm(startTime.substring(startTimeSecondSpace + 1)))
                            {
                                DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                                try
                                {
                                    startDate = df.parse(startTime);
                                    call.setStartTime(startDate);
                                }
                                catch (ParseException p)
                                {
                                    System.out.println(p);
                                }
                            }
                            else
                            {
                                System.out.println("AM/PM in file is not Valid! Exiting Program");
                                System.exit(1);
                            }
                        }
                        else
                        {
                            System.out.println("Start Time (time) in file is Invalid! Exiting Program");
                            System.exit(1);
                        }
                    }
                    else
                    {
                        System.out.println("Start Time (date) in file is Invalid! Exiting Program");
                        System.exit(1);
                    }
                }
                else
                {
                    System.out.println("Missing Argument in file! Exiting Program");
                    System.exit(1);
                }

                String endTime = reader.readLine();
                if (endTime != null)
                {
                    int endTimeFirstSpace = endTime.indexOf(" ");
                    int endTimeSecondSpace = endTime.lastIndexOf(" ");
                    if (checkIfDateIsValid(endTime.substring(0, endTimeFirstSpace)))
                    {
                        if (checkIfTimeIsValid(endTime.substring(endTimeFirstSpace + 1, endTimeSecondSpace)))
                        {
                            if (checkIfAmPm(endTime.substring(endTimeSecondSpace + 1)))
                            {
                                DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                                try
                                {
                                    Date endDate = df.parse(endTime);
                                    if (startDate.before(endDate))
                                    {
                                        call.setEndTime(endDate);
                                    }
                                    else
                                    {
                                        System.out.println("End Time in file is before Start Time in file! Exiting Program");
                                        System.exit(1);
                                    }
                                }
                                catch (ParseException p)
                                {
                                    System.out.println(p);
                                }
                                bill.addPhoneCall(call);
                            }
                            else
                            {
                                System.out.println("AM/PM in file is not Valid! Exiting Program");
                                System.exit(1);
                            }
                        }
                        else
                        {
                            System.out.println("End Time (time) in file is Invalid! Exiting Program");
                            System.exit(1);
                        }
                    }
                    else
                    {
                        System.out.println("End Time (date) in file is Invalid! Exiting Program");
                        System.exit(1);
                    }
                }
                else
                {
                    System.out.println("Missing Argument in file! Exiting Program");
                    System.exit(1);
                }
                readInput = true;
                bill.addPhoneCall(call);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        if (!readInput)
        {
            System.out.println("Missing Arguments in file! Exiting Program");
            System.exit(1);
        }
        return bill;
    }
}
