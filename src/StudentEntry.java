/**
 *
 * @author aaryasoni
 */

// I know we didn't need setters but I have added them just in case.

public class StudentEntry {
    
    private String StudentID;
    private String firstName;
    private String lastName;

    public StudentEntry(String StudentID, String firstName, String lastName) {
        this.StudentID = StudentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString() {
        return lastName + ", " + firstName;
    }
}
