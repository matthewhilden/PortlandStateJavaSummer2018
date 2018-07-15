package edu.pdx.cs410J.hilden;

import org.junit.Test;

import java.io.IOException;


public class TextDumperTest
{
    @Test
    public void dumpTextFile()
    {
        PhoneBill bill = new PhoneBill();
        bill.setCustomerName("Matthew Hilden");
        PhoneCall call = new PhoneCall("555-555-5555", "666-666-6666", "00/00/0000 00:00", "11/11/1111 11:11");
        bill.addPhoneCall(call);
        TextDumper dumper = new TextDumper("file");

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
