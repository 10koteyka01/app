package GUI;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DBConnection {
    Connection con;
    private Statement stat;
    PreparedStatement pstat;
    ResultSet rs;
    
    public DBConnection()
    {
        systemConnection();
    }
    
    private void systemConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/headhunter?zeroDateTimeBehavior=convertToNull", "root", "root");
//            stat = con.createStatement();
            JOptionPane.showMessageDialog(null, "It's all successfully complited");
        } catch (ClassNotFoundException ex) {
            System.err.println("Не найден драйвер");
        } catch (SQLException ex) {
            System.err.println("Классу DBConnection не удаётся подключиться к БД");
        }
    }
}
