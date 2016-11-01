package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Farmer {

    public static final String TABLE_NAME = "Farmer";
    public static final String COLUMN_FARMER_ID = "FarmerID";
    public static final String COLUMN_FARM_ID = "FarmID";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_MIDDLE_NAME = "MiddleName";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_BIRTHDAY = "Birthday";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_CONTACT_NO = "ContactNo";
    public static final String COLUMN_FLAG = "Flag";

    private int farmerID;
    private int farmID;
    private String lastName;
    private String middleName;
    private String firstName;
    private String birthday;
    private String address;
    private String contactNo;
    private int flag;

    public Farmer() {
    }

    public Farmer(int farmerID, int farmID, String lastName, String middleName, String firstName, String birthday, String address, String contactNo, int flag) {
        this.farmerID = farmerID;
        this.farmID = farmID;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.contactNo = contactNo;
        this.flag = flag;
    }

    public int getFarmerID() {
        return farmerID;
    }

    public void setFarmerID(int farmerID) {
        this.farmerID = farmerID;
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
