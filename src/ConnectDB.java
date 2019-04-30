import java.sql.*;

public class ConnectDB {
    public static final String url = "jdbc:mysql://113.54.157.141:3306/trajectory?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "work";
    public static final String password = "qwert";
    public static String str = null;
    public static void main(String[] args)  {
        Connection conn=null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM spliteddata ORDER BY flight_icaoNumber asc LIMIT 501");
            while (rs.next()){
                String name = rs.toString();
                System.out.println(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
