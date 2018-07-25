package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
            if (line == null || line.equals(""))
            {
                System.out.println("Customer Name in file is Invalid! Exiting Program");
                System.exit(1);
            }
            else
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
                if (line != null)
                {
                    int startTimeFirstSpace = line.indexOf(" ");
                    int startTimeSecondSpace = line.lastIndexOf(" ");
                    if (checkIfDateIsValid(line.substring(0, startTimeFirstSpace)))
                    {
                        if (checkIfTimeIsValid(line.substring(startTimeFirstSpace + 1, startTimeSecondSpace)))
                        {
                            if (checkIfAmPm(line.substring(startTimeSecondSpace + 1)))
                            {
                                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm aa");
                                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                                try
                                {
                                    Date startDate = df.parse(line);
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

                line = reader.readLine();
                if (line != null)
                {
                    int endTimeFirstSpace = line.indexOf(" ");
                    int endTimeSecondSpace = line.lastIndexOf(" ");
                    if (checkIfDateIsValid(line.substring(0, endTimeFirstSpace)))
                    {
                        if (checkIfTimeIsValid(line.substring(endTimeFirstSpace + 1, endTimeSecondSpace)))
                        {
                            if (checkIfAmPm(line.substring(endTimeSecondSpace + 1)))
                            {
                                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm aa");
                                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                                try
                                {
                                    Date endDate = df.parse(line);
                                    if (endDate.before(df.parse(startTime)));
                                    {
                                        System.out.println("End Time is before Start Time! Exiting Program");
                                        System.exit(1);
                                    }
                                    call.setEndTime(endDate);
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
