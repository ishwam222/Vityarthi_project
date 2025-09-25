package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance;
    private String dataFolder = "data";
    private String backupFolder = "backups";

    private AppConfig() {
        // Private constructor for Singleton
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getDataFolder() {
        return dataFolder;
    }

    public String getBackupFolder() {
        return backupFolder;
    }
}