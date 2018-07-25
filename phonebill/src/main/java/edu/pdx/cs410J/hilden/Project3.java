package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.ParserException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Project3
{
    public static void main(String[] args) {

        PhoneBill bill = new PhoneBill();
        PhoneCall call = new PhoneCall();

        boolean print = false;              // Denotes -print
        boolean readTextFile = false;       // If we are reading from an input file
        boolean writeTextFile = false;      // If we are writing to an output file
        boolean writePrettyFile = false;    // If we are pretty printing to an output file

        int option = 0;                     // Keep track of what field we are currently parsing

        String inputOutputFile = "";        // Name of output file for writing
        String prettyFile = "";             // Name of output file for pretty printing
        String startTime = "";              // Storage for concatenation of start time and start date
        String endTime = "";                // Storage for concatenation of end time and end date

        int length = args.length;
        for (int i = 0; i < length; i++)
        {
            if (args[i].equals("-README"))
            {
                README();
                System.exit(0);
            }
        }
        for (String arg : args)
        {
            switch (option)
            {
                case 0: if (arg.equals("-textFile"))
                        {
                            readTextFile = true;
                            writeTextFile = true;
                        }
                        else if (arg.equals("-print"))
                        {
                            print = true;
                        }
                        else if (arg.equals("-pretty"))
                        {
                            writePrettyFile = true;
                        }
                        else
                        {
                            if (writePrettyFile)
                            {
                                prettyFile = arg;
                                writePrettyFile = false;
                            }
                            else if (readTextFile)
                            {
                                inputOutputFile = arg;
                                readTextFile = false;
                            }
                            else
                            {
                                bill.setCustomerName(arg);
                                option++;
                            }
                        }
                        break;

                case 1: if (checkIfPhoneNumberIsValid(arg))
                        {
                            call.setCallerNumber(arg);
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid Caller Number! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 2: if (checkIfPhoneNumberIsValid(arg))
                        {
                            call.setCalleeNumber(arg);
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid Callee Number! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 3: if (checkIfDateIsValid(arg))
                        {
                            startTime += arg;
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid Start Time (date)! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 4: if (checkIfTimeIsValid(arg))
                        {
                            startTime += " " + arg;
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid Start Time (time)! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 5: if (checkIfAmPm(arg))
                        {
                            startTime += " " + arg;
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm aa");
                            df.setTimeZone(TimeZone.getTimeZone("GMT"));
                            try
                            {
                                Date startDate = df.parse(startTime);
                                call.setStartTime(startDate);
                            }
                            catch (ParseException p)
                            {
                                System.out.println(p);
                            }
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid AM/PM tag! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 6: if (checkIfDateIsValid(arg))
                        {
                            endTime += arg;
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid End Time (date)! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 7: if (checkIfTimeIsValid(arg))
                        {
                            endTime += " " + arg;
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid End Time (time)! Exiting Program");
                            System.exit(1);
                        }
                        break;

                case 8: if (checkIfAmPm(arg))
                        {
                            endTime += " " + arg;
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm aa");
                            df.setTimeZone(TimeZone.getTimeZone("GMT"));
                            try
                            {
                                Date endDate = df.parse(endTime);

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
                            option++;
                        }
                        else
                        {
                            System.out.println("Invalid AM/PM tag! Exiting Program");
                            System.exit(1);
                        }
                        break;

                default: System.out.println("Invalid Number of Arguments! Exiting Program");
                         System.exit(1);
            }
        }
        if (option != 9)
        {
            System.out.println("Invalid Number of Arguments! Exiting Program");
            System.exit(1);
        }
        else
        {
            bill.addPhoneCall(call);
            if (!inputOutputFile.equals(""))
            {
                try
                {
                    String inputCustomerName = bill.getCustomer();
                    TextParser tp = new TextParser(inputOutputFile);
                    bill = tp.parse();
                    if (bill.getCustomer().equals(inputCustomerName))
                    {
                       System.out.println("Customer names do not match! Exiting Program");
                    }
                }
                catch (ParserException p)
                {
                    System.out.println(p);
                }

            }
            if (!prettyFile.equals(""))
            {
                if (prettyFile.equals("-"))
                {
                    print = true;
                }
                else
                {
                    PrettyPrinter printer = new PrettyPrinter(prettyFile);
                    try
                    {
                        printer.dump(bill);

                    }
                    catch (IOException i)
                    {
                        System.out.println(i);
                    }
                }
            }
            if (print)
            {
                System.out.println("Phone Bill for Customer: " + bill.getCustomer() + "\n");
                for (PhoneCall phoneCall : bill.getPhoneCalls())
                {
                    System.out.println("Caller: " + phoneCall.getCaller());
                    System.out.println("Callee: " + phoneCall.getCallee());
                    System.out.println("Start Time: " + phoneCall.getStartTimeString());
                    System.out.println("End Time: " + phoneCall.getEndTimeString() + "\n");
                }
            }
            if (writeTextFile)
            {
                File file = new File(inputOutputFile);
                try
                {
                    if (!file.exists())
                    {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                }
                catch (IOException i)
                {
                    System.out.println(i);
                }
                TextDumper dumper = new TextDumper(inputOutputFile);
                try
                {
                    dumper.dump(bill);

                }
                catch (IOException i)
                {
                    System.out.println(i);
                }
            }
        }
        System.exit(0);
    }

    /**
     *  Checks if the input String is a valid AM/PM tag
     *  @param  ampm
     *          Input tag to be checked for validity
     *  @return Returns true if the input is a valid AM/PM tag, false otherwise
     */
    static boolean checkIfAmPm(String ampm)
    {
        String lowerCase = ampm.toLowerCase();
        return lowerCase.equals("am") || lowerCase.equals("pm");
    }

    /**
     *  Checks if the input phone number is a valid phone number of format nnn-nnn-nnnn
     *  @param  number
     *          Phone number to be checked for validity
     *  @return Returns true if the input is a valid phone number, false otherwise
     */
    static boolean checkIfPhoneNumberIsValid(String number)
    {
        int length = number.length();
        if (length != 12)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < length; i++)
            {
                if (i == 3 || i == 7)
                {
                    if (!(number.charAt(i) == '-'))
                    {
                        return false;
                    }
                }
                else
                {
                    if (!Character.isDigit(number.charAt(i)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *  Checks if the input date is a valid date of format [n]n/[n]n/nnnn where [n] is optional
     *  @param  date
     *          Date to be checked for validity
     *  @return Returns true if the input is a valid date, false otherwise
     */
    static boolean checkIfDateIsValid(String date)
    {
        int firstSeparation = date.indexOf("/");
        int lastSeparation = date.lastIndexOf("/");

        String month =  date.substring(0, firstSeparation);
        String day = date.substring(firstSeparation + 1, lastSeparation);
        String year = date.substring(lastSeparation + 1);

        int monthLength = month.length();
        if (monthLength == 1 || monthLength == 2)
        {
            for (int i = 0; i < monthLength; i++)
            {
                if (!Character.isDigit(month.charAt(i)))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        int dayLength = day.length();
        if (dayLength == 1 || dayLength == 2)
        {
            for (int i = 0; i < dayLength; i++)
            {
                if (!Character.isDigit(day.charAt(i)))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        int yearLength = year.length();
        if (yearLength == 4)
        {
            for (int i = 0; i < yearLength; i++)
            {
                if (!Character.isDigit(year.charAt(i)))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     *  Checks if the input time is a valid time of format [n]n:nn where [n] is optional
     *  @param  time
     *          Time to be checked for validity
     *  @return Returns true if the input is a valid time, false otherwise
     */
    static boolean checkIfTimeIsValid(String time)
    {
        int colonIndex = time.indexOf(":");

        String hour = time.substring(0, colonIndex);
        String minute = time.substring(colonIndex + 1);

        int hourLength = hour.length();
        if (hourLength == 1 || hourLength == 2)
        {
            if (hourLength == 2)
            {
                if (time.charAt(0) == '0')
                {
                    char secondDigit = time.charAt(1);
                    if (!(secondDigit >= '0' && secondDigit <= '9'))
                    {
                        return false;
                    }
                }
                else if (time.charAt(0) == '1')
                {
                    char secondDigit = time.charAt(1);
                    if (!(secondDigit == '0' || secondDigit == '1' || secondDigit == '2'))
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                char firstDigit = time.charAt(0);
                if (!(firstDigit >= '1' && firstDigit <= '9'))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        int minuteLength = minute.length();
        if (minuteLength == 2)
        {
            char firstDigit = minute.charAt(0);
            if (!(firstDigit >= '0' && firstDigit <= '5'))
            {
                return false;
            }
            else
            {
                char secondDigit = minute.charAt(1);
                if (!(secondDigit >= '0' && secondDigit <= '9'))
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     *  Prints a short text snippit describing the functionality of the program to the console
     */
    public static void README()
    {
        System.out.println("Project 3: Pretty Printing a Phone Bill\n");
        System.out.println("This project adds the ability to pretty print phone calls in a phone bill");
        System.out.println("Phone calls in a phone bill will now be sorted chronologically by start time, and the");
        System.out.println("start and end times for each call are now represented by Date objects instead of strings");
        System.out.println("The pretty printer will print to a specified text file with using DateFormat to make the");
        System.out.println("dates look nice. The printer also includes the duration of each phone call in minutes.");
    }
}
