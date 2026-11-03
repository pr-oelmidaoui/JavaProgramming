package ma.dentalPro.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Crée la connexion JDBC à partir des paramètres de application.properties.
 */
public final class JdbcConnectionFactory {

    private JdbcConnectionFactory() {}

    public static Connection createConnection(Properties properties) {
        Connection session = null;

            var driver      = getRequiredProperty(properties, "dataSource.driver");
            var url         = getRequiredProperty(properties, "dataSource.url");
            var user        = getRequiredProperty(properties, "dataSource.user");
            var password    = getRequiredProperty(properties, "dataSource.pass");

        try {
                    Class.forName(driver);
                    session = DriverManager.getConnection(url, user, password);
                    System.out.println("You are successfully connected to database ^_^ |  "+ url);
            }
        catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC MySQL introuvable : " + driver + " =>" +  e.getMessage()); }
        catch (SQLException e) {
            System.err.println("Impossible de se connecter à MySQL : " + url+ " =>" +  e.getMessage());}

        return session;
    }

    // fonction pour verification de la valeur de la propriété
    private static String getRequiredProperty(Properties properties, String key) {
        var value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Propriété JDBC obligatoire absente : " + key);
        }
        return value.trim();
    }
}
