
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aaryasoni
 */

public class MultiTableQueries {

    private static Connection connection;
    private static PreparedStatement getAllClassDescriptions;
    private static ResultSet resultSet;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass;
    
    
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> description = new ArrayList<>();
        try
        {
            getAllClassDescriptions = connection.prepareStatement("select app.classentry.courseCode, description, seats from app.classentry, app.course where semester = ? and app.classentry.courseCode = app.course.courseCode order by app.classentry.courseCode");
            getAllClassDescriptions.setString(1, semester);
            resultSet = getAllClassDescriptions.executeQuery();
            
            while(resultSet.next())
            {
                ClassDescription obj = new ClassDescription(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3));
                description.add(obj);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return description;
        
    }
    
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select app.student.studentid, firstname,lastname from app.schedule,app.student where semester=? and coursecode=? and status='S' and app.student.studentid=app.schedule.studentid order by timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            while (resultSet.next())
            {
                StudentEntry newStudentID=new StudentEntry(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3));
                students.add(newStudentID);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select app.schedule.studentID, firstname, lastname from app.schedule, app.student where app.schedule.semester=? and app.schedule.coursecode=? and app.schedule.status = 'W' and app.student.studentID=app.schedule.studentID");
            getWaitlistedStudentsByClass.setString(1, semester); 
            getWaitlistedStudentsByClass.setString(2, courseCode);
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while (resultSet.next())
            {
                StudentEntry newStudentID=new StudentEntry(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3));
                students.add(newStudentID);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
    }
    
    
}


