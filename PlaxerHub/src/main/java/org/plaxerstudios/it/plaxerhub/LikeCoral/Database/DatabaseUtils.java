package org.plaxerstudios.it.plaxerhub.LikeCoral.Database;

import org.bukkit.plugin.Plugin;
import org.plaxerstudios.it.plaxerhub.PlaxerHub;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    private static Connection connection;

    private static Plugin plugin = PlaxerHub.getPlugin(PlaxerHub.class);
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:"
                        + plugin.getDataFolder().getAbsolutePath() + "/database.db");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void setupDatabase() {
        File databaseFile = new File(plugin.getDataFolder(), "database.db");
        if (databaseFile.exists()) {
            try {
                getConnection().prepareStatement("""
            CREATE TABLE IF NOT EXISTS DATA(
            UUID VARCHAR(36) NOT NULL,
            BLOCKS_PLACED INT NOT NULL,
            PRIMARY KEY(UUID)
        )
        """).execute();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return;
        }

    }
    public static void createDatabase() {
        // Verifica se il database esiste già
        File databaseFile = new File(plugin.getDataFolder(), "database.db");
        if (databaseFile.exists()) {
            plugin.getLogger().info("Il database esiste già.");
            return;
        }

        try {
            // Caricamento del driver SQLite
            Class.forName("org.sqlite.JDBC");

            // Creazione della connessione al database
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile);

            // Creazione di una tabella di esempio
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

            plugin.getLogger().info("Il database è stato creato correttamente.");
        } catch (ClassNotFoundException | SQLException e) {
            plugin.getLogger().severe("Si è verificato un errore durante la creazione del database: " + e.getMessage());
        }
    }
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                plugin.getLogger().info("Connessione al database chiusa correttamente.");
            }
        } catch (SQLException e) {
            plugin.getLogger().severe("Si è verificato un errore durante la chiusura della connessione al database: " + e.getMessage());
        }
    }

}
