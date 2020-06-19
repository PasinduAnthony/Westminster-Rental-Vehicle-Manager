package CLI;

import java.util.Date;

public class Customer
{
    protected String Name;
    protected String PhoneNumber;
    protected String NIC;
    protected Date LicenceExpireDate;

    public Customer(String CN, String CP, String NIC, Date CExpire)
    {
        this.Name=CN;
        this.PhoneNumber=CP;
        this.NIC=NIC;
        this.LicenceExpireDate=CExpire;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getNIC() {
        return NIC;
    }

    public Date getLicenceExpireDate() {
        return LicenceExpireDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public boolean checkLicence()
    {
        return false;
    }
}
