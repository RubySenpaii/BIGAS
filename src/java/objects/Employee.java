package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class Employee {

    public static final String TABLE_NAME = "Employee";
    public static final String COLUMN_EMPLOYEE_ID = "EmployeeID";
    public static final String COLUMN_MUNICIPALITY_ID = "MunicipalityID";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_MIDDLE_NAME = "MiddleName";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_ADDRESS = "Address";
    public static final String COLUMN_BIRTHDAY = "Birthday";
    public static final String COLUMN_AUTHORITY = "Authority";
    public static final String COLUMN_GENDER = "Gender";
    public static final String COLUMN_CONTACT_NO = "ContactNo";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_FLAG = "Flag";

    private int employeeID;
    private int municipalityID;
    private String lastName;
    private String middleName;
    private String firstName;
    private String address;
    private String birthday;
    private String authority;
    private String gender;
    private String contactNo;
    private String username;
    private String password;
    private int flag;

    public Employee() {
    }

    public Employee(int employeeID, int municipalityID, String lastName, String middleName, String firstName, String address,
                    String birthday, String authority, String gender, String contactNo, String username, String password, int flag) {
        this.employeeID = employeeID;
        this.municipalityID = municipalityID;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.address = address;
        this.birthday = birthday;
        this.authority = authority;
        this.gender = gender;
        this.contactNo = contactNo;
        this.username = username;
        this.password = password;
        this.flag = flag;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getMunicipalityID() {
        return municipalityID;
    }

    public void setMunicipalityID(int municipalityID) {
        this.municipalityID = municipalityID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
