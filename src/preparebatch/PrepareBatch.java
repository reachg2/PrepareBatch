
package preparebatch;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrepareBatch {

    
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root","");
            PreparedStatement ps = con.prepareStatement("insert into bank values (?,?,?)");
            ps.setInt(1, 7);
            ps.setString(2, "samann");
            ps.setInt(3,10000);
            ps.addBatch();
            ps.setInt(1, 8);
            ps.setString(2, "makara");
            ps.setInt(3,10000);
            ps.addBatch();
            ps.executeBatch();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrepareBatch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrepareBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
