package objects;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import app.*;

public class E06Customer implements Serializable {

    private int CustomerID;
    public String CustomerName;
    public String ContactName;
    public String Address;
    public String City;
    public String PostalCode;
    public String Country;

    public E06Customer() {
    }

    public E06Customer(JSONObject jsonObject) {
        try {
            setCustomerID(jsonObject.getInt(ROUTER.CustomerID));
            setCustomerName(jsonObject.getString(ROUTER.CustomerName));
            setContactName(jsonObject.getString(ROUTER.ContactName));
            setAddress(jsonObject.getString(ROUTER.Address));
            setCity(jsonObject.getString(ROUTER.City));
            setPostalCode(jsonObject.getString(ROUTER.PostalCode));
            setCountry(jsonObject.getString(ROUTER.Country));
        } catch (JSONException e) {
            app.l(e.toString());
        }
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
