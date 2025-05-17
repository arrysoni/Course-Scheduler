
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aaryasoni
 */

public class StudentQueries {
    


    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet resultSet;
    private static  PreparedStatement dropStudent;
    private static  PreparedStatement getStudent;
    
    public static void addStudent(StudentEntry student_name)
    {
        connection = DBConnection.getConnection();
        try
        {
            addStudent = connection.prepareStatement("insert into app.student (StudentID,firstName,lastName) values (?,?,?)");
            addStudent.setString(1, student_name.getStudentID());
            addStudent.setString(2, student_name.getFirstName());
            addStudent.setString(3, student_name.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<StudentEntry> getAllStudents()
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        try
        {
            getAllStudents = connection.prepareStatement("select * from app.student order by lastname");
            resultSet = getAllStudents.executeQuery();
            
            while(resultSet.next())
            {
                  StudentEntry student = new StudentEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                  students.add(student);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
        
    }
    
    public static StudentEntry getStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        StudentEntry student = null;
        try
        {
            getStudent = connection.prepareStatement("select * from app.student where studentID = '" + studentID + "'");
            resultSet = getStudent.executeQuery();
            resultSet.next();
            student = new StudentEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return student;
    }
    
    public static void dropStudent(String studentID)
    {
        connection = DBConnection.getConnection();
        try
        { 
            dropStudent=connection.prepareStatement("delete from app.student where studentid=?");
            dropStudent.setString(1,studentID);
            dropStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
                
    }

    
}
