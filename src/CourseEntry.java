/**
 *
 * @author aaryasoni
 */

// I know we didn't need setters but I have added them just in case.

public class CourseEntry {
    private String courseCode;
    private String description;

    public CourseEntry(String courseCode, String description) {
        this.courseCode = courseCode;
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    
}
