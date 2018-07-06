package edu.pdx.cs410J.hilden;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1
{

    public static void main(String[] args)
    {
        PhoneBill bill = new PhoneBill();
        PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath

        int option = 0;
        boolean print = false;
        boolean readme = false;

        boolean multiWordCustomer = false;
        String customerName = "";

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
                          break;
                case 3  : break;
                case 4  : break;
                default : break;
            }
        }
        if (option != 4)
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

    // Check if input string is a valid date
    public static boolean checkIfDateIsValid(String arg)
    {
        return true;
    }

    // Check if input string is a valid time
    public static boolean checkIfTimeIsValid(String arg)
    {
        return true;
    }
}