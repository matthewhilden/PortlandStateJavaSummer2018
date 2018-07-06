package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill<PhoneCall>
{

    private String customerName;
    private Collection<PhoneCall> phoneCalls;

    // Default Constructor
    public PhoneBill()
    {
        this.customerName = null;
        this.phoneCalls = null;
    }

    // Secondary Constructor
    // Takes input for a customer name
    public PhoneBill(String customerName)
    {
        this.customerName = customerName;
    }

    // Tertiary Constructor
    // Takes input for a customer name and a collection of phone calls
    public PhoneBill(String customerName, Collection<PhoneCall> phoneCalls)
    {
        this.customerName = customerName;
        this.phoneCalls = phoneCalls;
    }

    @Override
    public String getCustomer()
    {
        return customerName;
    }

    @Override
    public void addPhoneCall(PhoneCall phoneCall)
    {
        phoneCalls.add(phoneCall);
    }


    @Override
    public Collection getPhoneCalls()
    {
        return phoneCalls;
    }
}
