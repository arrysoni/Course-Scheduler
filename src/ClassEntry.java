/**
 *
 * @author aaryasoni
 */

// I know we didn't need setters but I have added them just in case.

public class ClassEntry {
    
    private String semester;
    private String courseCode;
    private int seats;

    public ClassEntry(String semester, String courseCode, int seats) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.seats = seats;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getSeats() {
        return seats;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    
}
