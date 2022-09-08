import configurations.core.DriverProvider;
import configurations.jdbc.conf.DBConnectionProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;

public class BaseTest {

    protected static Connection connection;

    @BeforeSuite
    public void setup() {
        DriverProvider.getDriver();
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    @AfterSuite
    public void tearDown() {
        DriverProvider.quitDriver();
    }
}
