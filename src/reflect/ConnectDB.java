package reflect;

import java.sql.*;

public class ConnectDB {
    public static final String url = "jdbc:mysql://113.54.157.141:3306/trajectory?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "work";
    public static final String password = "qwert";
    public static String str = null;
    public static void main(String[] args)  {
        Connection conn=null;//表示数据库的连接对象
        try {
            Class.forName(name);//1、使用CLASS类加载驱动程序 ,反射机制的体现
            conn = DriverManager.getConnection(url, user, password);//2、连接数据库
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
