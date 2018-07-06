package edu.pdx.cs410J.hilden;

        import edu.pdx.cs410J.AbstractPhoneBill;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1
{

    public static void main(String[] args)
    {
        PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath

        int option = 0;
        boolean print = false;
        boolean readme = false;


        for (String arg : args)
        {

            switch (arg)
            {
                case "-print"  : print = true;
                                 break;
                case "-README" : readme = true;
                                 break;
                default        :
                                 break;

            }

        }



        System.exit(1);
    }
}