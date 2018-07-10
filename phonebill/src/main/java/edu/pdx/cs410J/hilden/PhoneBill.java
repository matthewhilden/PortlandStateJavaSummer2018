package edu.pdx.cs410J.hilden;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  The PhoneBill class represents a PhoneBill object that contains information about a users phone bill
 */
public class PhoneBill extends AbstractPhoneBill<PhoneCall>
{
    private String customerName;
    private Collection<PhoneCall> phoneCalls;

    /**
     *  Creates a new PhoneBill
     *  Does not take any parameters
     */
    PhoneBill()
    {
        this.customerName = null;
        this.phoneCalls = new ArrayList<>();
    }

    /**
     *  Sets the Customer Name field of the PhoneBill object
     *  @param  customerName
     *          The name of the customer for the specified PhoneBill
     */
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    /**
     *  Gets the Customer Name field of the PhoneBill object
     *  @return  Returns the String of the CustomerName field
     */
    @Override
    public String getCustomer()
    {
        return customerName;
    }

    /**
     *  Adds the input PhoneCall to the PhoneBill object
     *  @param  phoneCall
     *          An individual PhoneCall of the PhoneBill object
     */
    @Override
    public void addPhoneCall(PhoneCall phoneCall)
    {
        phoneCalls.add(phoneCall);
    }

    /**
     *  Get the Collection of PhoneCalls contained in the PhoneBill object
     *  @return Returns a Collection of PhoneCall objects
     */
    @Override
    public Collection<PhoneCall> getPhoneCalls()
    {
        return phoneCalls;
    }
}
