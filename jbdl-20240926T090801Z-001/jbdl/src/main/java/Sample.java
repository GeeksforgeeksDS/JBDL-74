import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

    /**
     *
     *
     *  how these artifacts are resolved --> ?
     *
     *  ---->    (local m2 repository)
     *                  --> yes
     *                     ---> no      -------> it would check in remote server/ artifactory
     *                                              --> yes
     *                                                  ---> no                 -------> central repository (https://repo.maven.apache.org/maven2)
     *                                                                      --> yes
     *                                                                      --> no (not present)
     *
     *
     *
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("create table sample_info ( id int(10) primary key , " +
                " user_role varchar(50) default null ," +
                " name varchar(20) default  null )");
    }
}
