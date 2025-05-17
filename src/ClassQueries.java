import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aaryasoni
 */

public class ClassQueries {
    private static Connection connection;
    private static PreparedStatement addClass;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getClassSeats;
    private static ResultSet resultSet;
    private static PreparedStatement dropClass;
    
    public static void addClass(ClassEntry class_name)          
    {
        connection = DBConnection.getConnection();
        try
        {
            addClass = connection.prepareStatement("insert into app.classentry (semester,courseCode,seats) values (?,?,?)");
            addClass.setString(1, class_name.getSemester());
            addClass.setString(2,class_name.getCourseCode());
            addClass.setInt(3, class_name.getSeats());
            addClass.executeUpdate();

        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getAllCourseCodes(String semester)          
    {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try
        {
            getAllCourseCodes = connection.prepareStatement("select courseCode from app.classentry where semester=? order by courseCode");
            
            getAllCourseCodes.setString(1, semester);
            resultSet = getAllCourseCodes.executeQuery();
            
            while(resultSet.next())
            {
                courseCodes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodes;
        
    }
    
    public static int getClassSeats(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int seats = 0;
        
        try
        {
            getClassSeats = connection.prepareStatement("select seats from app.classentry where semester=? and coursecode=? ");
            
            getClassSeats.setString(1, semester);
            getClassSeats.setString(2, courseCode);
            resultSet = getClassSeats.executeQuery();
            
            while(resultSet.next())
            {
                seats=resultSet.getInt("seats");   // try seats=resultSet.getInt(1);
            }
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return seats;
        
    }
    
    public static void dropClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        try
        {
            dropClass = connection.prepareStatement("delete from app.classentry where semester=? and coursecode=? ");
            dropClass.setString(1, semester);
            dropClass.setString(2, courseCode);
            dropClass.executeUpdate();
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
        
}
    
   

