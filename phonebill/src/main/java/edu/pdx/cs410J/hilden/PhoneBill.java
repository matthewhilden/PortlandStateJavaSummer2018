package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.ArrayList;
import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill<PhoneCall>
{
    private String customerName;
    private Collection<PhoneCall> phoneCalls = new ArrayList<>();

    // Default Constructor
    PhoneBill()
    {
        this.customerName = null;
        this.phoneCalls = null;
    }

    // Set CustomerName
    public void setCustomerName(String customerName)
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
