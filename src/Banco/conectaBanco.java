package Banco;

public class conectaBanco {

   private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   private String DB_URL ="jdbc:mysql://localhost/pizzaria15";
   private String DB_USER = "root";
   private String DB_PASS = "root";

    public String JDBC_DRIVER(){
        return JDBC_DRIVER;
    }
    public String DB_URL(){
        return DB_URL;
    }
    public String DB_USER(){
        return DB_USER;
    }
    public String DB_PASS(){
        return DB_PASS;
    }

}
