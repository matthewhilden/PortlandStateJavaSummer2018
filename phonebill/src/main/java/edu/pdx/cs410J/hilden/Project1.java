package edu.pdx.cs410J.hilden;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1
{
    public static void main(String[] args)
    {
        PhoneBill bill = new PhoneBill();
        PhoneCall call = new PhoneCall();

        int option = 0;                     // Keep track of what field we are currently parsing
        boolean print = false;              // Denotes -print

        boolean multiWordCustomer = false;  // If the Customer name will use more than one argument
        String customerName = "";           // Storage for concatenation of multi word Customers
        String startTime = "";              // Storage for concatenation of start time and start date
        String endTime = "";                // Storage for concatenation of end time and end date

        for (String arg : args)
        {
            switch (option)
            {
                case 0  : if (arg.equals("-README"))            // Parse -README
                          {
                              README();
                              System.exit(0);
                          }
                          else if (arg.equals("-print"))        // Parse -print
                          {
                              print = true;
                          }
                          else                                  // Parse customerName
                          {
                              if (arg.charAt(0) == '"')
                              {
                                  multiWordCustomer = true;
                                  customerName += arg.substring(1);
                              }
                              else if (multiWordCustomer && arg.charAt(arg.length() - 1) == '"')
                              {
                                  customerName += " " + arg.substring(0, arg.length() - 2);
                                  bill.setCustomerName(customerName);
                                  option++;
                              }
                              else
                              {
                                  if (multiWordCustomer)
                                  {
                                      customerName += " " + arg;
                                  }
                                  else
                                  {
                                      bill.setCustomerName(arg);
                                      option++;
                                  }
                              }
                          }
                          break;

                case 1  : if (checkIfPhoneNumberIsValid(arg))   // Parse callerNumber
                          {
                              call.setCallerNumber(arg);
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                case 2  : if (checkIfPhoneNumberIsValid(arg))   // Parse calleeNumber
                          {
                              call.setCalleeNumber(arg);
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                case 3  : if (checkIfDateIsValid(arg))          // Parse startTime date portion
                          {
                              startTime += arg;
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                case 4  : if (checkIfTimeIsValid(arg))          // Parse startTime time portion
                          {
                              startTime += " " + arg;
                              call.setStartTime(startTime);
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                case 5  : if (checkIfDateIsValid(arg))          // Parse endTime date portion
                          {
                              endTime += arg;
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                case 6  : if (checkIfTimeIsValid(arg))          // Parse endTime time portion
                          {
                              endTime += " " + arg;
                              call.setEndTime(endTime);
                              option++;
                          }
                          else
                          {
                              System.out.println("Invalid Argument! Exiting Program");
                              System.exit(1);
                          }
                          break;

                default : System.out.println("Invalid Number of Arguments! Exiting Program");
                          System.exit(1);               // Default denotes error and exits
            }
        }
        if (option != 7)                                       // Check for extraneous command line arguments
        {
            System.out.println("Invalid Number of Arguments! Exiting Program");
            System.exit(1);
        }
        else
        {
            if (print)                                          // Print if required
            {
                System.out.println("Phone Bill for Customer: " + bill.getCustomer() + "\n");
                System.out.println("Caller: " + call.getCaller());
                System.out.println("Callee: " + call.getCallee());
                System.out.println("Start Time: " + call.getStartTimeString());
                System.out.println("End Time: " + call.getEndTimeString());
            }
        }
        System.exit(0);
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
        if (length != 12)                                       // Immediately check the correct length
        {
            return false;
        }
        else
        {
            for (int i = 0; i < length; i++)
            {
                if (i == 3 || i == 7)                           // Check for - characters at the correct positions
                {
                    if (!(number.charAt(i) == '-'))
                    {
                        return false;
                    }
                }
                else                                            // Check numeric characters
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
            for (int i = 0; i < hourLength; i++)
            {
                if (!Character.isDigit(hour.charAt(i)))
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
            for (int i = 0; i < minuteLength; i++)
            {
                if (!Character.isDigit(minute.charAt(i)))
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
        System.out.println("Project 1: Designing a Phone Bill Application\n");
        System.out.print("This project models an invdividual's phone bill.\nThe phone bill contains the customer's name, ");
        System.out.print("and a list of phone calls associated with the current billing cycle.\nEach phone call monitors ");
        System.out.println("the ingoing and outgoing phone numbers, as well as the call's start and end time.");
    }
}