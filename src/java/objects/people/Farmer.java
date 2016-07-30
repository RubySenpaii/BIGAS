/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.people;

/**
 *
 * @author RubySenpaii
 */
public class Farmer {
    public final static String TABLE_FARMER = "Farmer";
    public final static String COLUMN_FARMERID = "FarmerID";
    public final static String COLUMN_FARMID = "FarmID";
    public final static String COLUMN_LASTNAME = "LastName";
    public final static String COLUMN_FIRSTNAME = "FirstName";
    public final static String COLUMN_MIDDLENAME = "MiddleName";
    public final static String COLUMN_BIRTHDAY = "Birthday";
    public final static String COLUMN_ADDRESS = "Address";
    public final static String COLUMN_CONTACTNO = "ContactNo";
    
    private int farmerID;
    private int farmID;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthday;
    private String address;
    private String contactNo;
    
    public Farmer() {
        
    }

    /**
     * @return the farmerID
     */
    public int getFarmerID() {
        return farmerID;
    }

    /**
     * @param farmerID the farmerID to set
     */
    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
    }

    /**
     * @return the farmID
     */
    public int getFarmID() {
        return farmID;
    }

    /**
     * @param farmID the farmID to set
     */
    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
