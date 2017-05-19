/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lettura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.naming.ConfigurationException;

/**
 *
 *
 * This class implements a Singleton pattern. Every object returned from the
 * getPreferenceHandler is the very same one. The initialization is done once
 * and never again.
 *
 * Every class can access the preference data simply declaring a
 * PreferenceHandler pref = PreferenceHandler.getPreferenceHandler();
 *
 */
public class PreferenceHandler {

    /**
     * Singleton object
     */
    private static PreferenceHandler pref;

    //preference values
    private final int ServerPort;

    private Properties prop;

    private final String dbAddress;

    private final String dbPort;

    private final String dbName;

    private final String dbUser;

    private final String dbPass;

    /**
     * default configuration file name
     */
    static final String defaultConfigurationFilename = "/var/rover/etc/RoVeRConf.xml";

//	static final String defaultServiceLoggerConfig 					="/var/rover/etc/roverServer.log4j.properties";
    /**
     * This class hosts the XML key entries for the configuration file
     *
     */
    public class ConfigKeys {

        public static final String ServerPort = "Port";

        // DB
        public static final String DBAddress = "DBAddress";
        public static final String DBPort = "DBPort";
        public static final String DBName = "DBName";
        public static final String DBUser = "DBUser";
        public static final String DBPass = "DBPass";

        //services
        public static final String UMP = "UpdateManagementProtocol";
        public static final String DEPS = "DataExchangeProtocolServer";
        public static final String DEPC = "DataExchangeProtocolClient";
        public static final String RCP = "RemoteControlProtocol";

        //logger category set in the log4j conf file
        public static final String DEPLogName = "DEPApp";
        public static final String UMPLogName = "UMPApp";

    }

    /**
     * This function has to be called just ONCE (in Main). It initialize the
     * Singleton component which read the preferences from the configuration
     * file.
     *
     * @param configFile optional custom configuration file
     * @return Preference Handler (singleton)
     * @throws InvalidPropertiesFormatException if there is a syntax error in
     * the configFile file
     * @throws FileNotFoundException if the configFile can not be found
     * @throws IOException if the configFile file can not be read
     */
    public static PreferenceHandler getPreferenceHandler(String configFile)
            throws InvalidPropertiesFormatException,
            FileNotFoundException,
            IOException {
//		Assert.assertNull(pref); //only one time this function must be called
        try {
            pref = new PreferenceHandler(configFile);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return pref;
    }

    /**
     * This function returns the same instance of an initialized
     * PreferenceHandler or initialize a default one
     *
     * @return Singleton initialized PreferenceHandler
     */
    public static PreferenceHandler getPreferenceHandler() {
        if (pref == null) {
            try {
                pref = new PreferenceHandler("");
            } catch (InvalidPropertiesFormatException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pref;
    }

    private long lastMod;
    private File confFile;

    /**
     * Private Constructor (only static methods of this class can call it)
     *
     * @param configFileName optional custom configuration file
     * @throws InvalidPropertiesFormatException if there is a syntax error in
     * the configFile file
     * @throws FileNotFoundException if the configFile can not be found
     * @throws IOException if the configFile file can not be read
     * @throws ConfigurationException if there is a simple semantic error in the
     * configuration (e.g. empty string)
     */
    private PreferenceHandler(String configFileName)
            throws InvalidPropertiesFormatException,
            FileNotFoundException,
            IOException,
            ConfigurationException {

        prop = new Properties();

        if (configFileName.length() == 0) {
            configFileName = defaultConfigurationFilename;
        }
//		SLog.i(LogTag, " Loading config file from: "+ configFile);
        confFile = new File(configFileName);
        confFile.setReadOnly();
        this.lastMod = confFile.lastModified();
        prop.loadFromXML(new FileInputStream(configFileName));

        // Read mandatory properties
        String value = prop.getProperty(ConfigKeys.ServerPort);
        this.ServerPort = Integer.parseInt(value);

        // DB connection test
        dbAddress = prop.getProperty(ConfigKeys.DBAddress);
        dbPort = prop.getProperty(ConfigKeys.DBPort);
        dbName = prop.getProperty(ConfigKeys.DBName);
        dbUser = prop.getProperty(ConfigKeys.DBUser);
        dbPass = prop.getProperty(ConfigKeys.DBPass);

        if (dbAddress == null || dbAddress.length() == 0) {
            throw new ConfigurationException("dbAddress value NOT Found!");
        }
        if (dbPort == null || dbPort.length() == 0) {
            throw new ConfigurationException("Database Server Port value NOT Found!");
        }
        if (dbName == null || dbName.length() == 0) {
            throw new ConfigurationException("Databae Name value NOT Found!");
        }
        if (dbUser == null || dbUser.length() == 0) {
            throw new ConfigurationException("Database User value NOT Found!");
        }
        if (dbPass == null || dbPass.length() == 0) {
            throw new ConfigurationException("Database Password value NOT Found!");
        }

    }

    protected void checkRefresh() {
        long newLastMod = confFile.lastModified();
        if (newLastMod != this.lastMod) {
//			reloadConfFile(); FIXME: implement
            this.lastMod = newLastMod;
        }

    }

    /**
     * @return server port number
     */
    public int getServerPort() {

        return this.ServerPort;
    }

    /**
     * @param serviceName
     * @return if the service is enabled
     */
    public boolean isServiceEnabled(String serviceName) {
        return prop.getProperty(serviceName).equalsIgnoreCase("ON");
    }

    /**
     * Connection URL (from PostgreSql J/Connector Documentation)
     *
     * jdbc:postgresql://[::1]:5740/accounting
     *
     * @return String for DB connection
     */
    public static String getJDBCConnection() {
        return "jdbc:mysql://10.4.1.14:3306/";
    }

    public String getJDBCConnection(String customDbName) {
        return "jdbc:mysql://" + dbAddress + ":" + dbPort + "/" + customDbName;
    }

    public String getDBUser() {
        return dbUser;
    }

    public String getDBPass() {
        return dbPass;
    }

    public String getDBName() {
        return this.dbName;
    }

    public String getDBPort() {
        return this.dbPort;
    }
}
