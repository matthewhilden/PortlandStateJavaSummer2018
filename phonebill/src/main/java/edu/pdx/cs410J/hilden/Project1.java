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
        boolean readme = false;             // Denotes -README

        boolean multiWordCustomer = false;  // If the Customer name will use more than one argument
        String customerName = "";           // Storage for concatenation of multi word Customers
        String startTime = "";              // Storage for concatenation of start time and start date
        String endTime = "";                // Storage for concatenation of end time and end date

        for (String arg : args)
        {
            switch (option)
            {
                case 0  : if (arg.equals("-print"))
                          {
                              print = true;
                          }
                          else if (arg.equals("-README"))
                          {
                              readme = true;
                          }
                          else
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

                case 1  : if (checkIfPhoneNumberIsValid(arg))
                          {
                              call.setCallerNumber(arg);
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                case 2  : if (checkIfPhoneNumberIsValid(arg))
                          {
                              call.setCalleeNumber(arg);
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                case 3  : if (checkIfDateIsValid(arg))
                          {
                              startTime += arg;
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                case 4  : if (checkIfTimeIsValid(arg))
                          {
                              startTime += " " + arg;
                              call.setStartTime(startTime);
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                case 5  : if (checkIfDateIsValid(arg))
                          {
                              endTime += arg;
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                case 6  : if (checkIfTimeIsValid(arg))
                          {
                              endTime += " " + arg;
                              call.setEndTime(startTime);
                              option++;
                          }
                          else
                          {
                              System.exit(1);
                          }
                          break;

                default : System.exit(1);
            }
        }
        if (option != 6)
        {
            System.exit(1);
        }
        else
        {
            if (print)
            {

            }

            if (readme)
            {

            }
        }
        System.exit(0);
    }

    // Check if input string is a valid phone number of format: nnn-nnn-nnnn
    // Returns true if the format is valid, false otherwise
    public static boolean checkIfPhoneNumberIsValid(String arg)
    {
        int length = arg.length();
        if (length != 12)               // Immediately check the correct length
        {
            return false;
        }
        else
        {
            for (int i = 0; i < length; i++)
            {
                if (i == 3 || i == 7)   // Check for - characters
                {
                    if (!(arg.charAt(i) == '-'))
                    {
                        return false;
                    }
                }
                else                    // Check numeric characters
                {
                    if (!Character.isDigit(arg.charAt(i)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Check if input string is a valid date of format: [n]n/[n]n/nnnn where [n] is optional
    // Returns true if the format is valid, false otherwise
    public static boolean checkIfDateIsValid(String arg)
    {
        int firstSeparation = arg.indexOf("/");
        int lastSeparation = arg.lastIndexOf("/");

        String month =  arg.substring(0, firstSeparation);
        String day = arg.substring(firstSeparation + 1, lastSeparation);
        String year = arg.substring(lastSeparation + 1);

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

    // Check if input string is a valid time of format: [n]n:nn where [n] is optional
    // Returns true if the format is valid, false otherwise
    public static boolean checkIfTimeIsValid(String arg)
    {
        int colonIndex = arg.indexOf(":");

        String hour = arg.substring(0, colonIndex);
        String minute = arg.substring(colonIndex + 1);

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
}