package kata5P2.view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MailListReaderDDBB {
    public static List<String> readDDBB () throws ClassNotFoundException, SQLException{
        List<String> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Downloads\\KATA.sDB");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT mail FROM MAIL;");
        
        while(rs.next()){
            mailList.add(rs.getString("mail"));
        }
        return mailList;
    }
}
