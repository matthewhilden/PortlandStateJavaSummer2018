package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.ArrayList;
import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill<PhoneCall>
{
    private String customerName;
    private Collection<PhoneCall> phoneCalls = new ArrayList<>();

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
    public Collection<PhoneCall> getPhoneCalls()
    {
        return phoneCalls;
    }
}
