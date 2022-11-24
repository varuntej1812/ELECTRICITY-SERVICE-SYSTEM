package DATABASE;

// import java.sql.*;

public class DataBase {
    private String DB_URL = "jdbc:mysql://localhost:3306/OOP_Project";
    private String USER = "root";
    private String PASS = "Vivek@9352";

    public DataBase() {

    }

    public DataBase(String dB_URL, String uSER, String pASS) {
        DB_URL = dB_URL;
        USER = uSER;
        PASS = pASS;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String dB_URL) {
        DB_URL = dB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String uSER) {
        USER = uSER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String pASS) {
        PASS = pASS;
    }
}