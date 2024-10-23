/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.api.config;

public interface IConfig {

    /**
     * Gets a object from the config
     *
     * @param key the key
     * @param clazz the class
     * @return the object
     */
    <T> T get(String key, Class<T> clazz);

    /**
     * Adds a value to the config if it does not exist
     *
     * @param key the key
     * @param value the value
     * @return the config
     */
    IConfig addIfNotExists(String key, Object value);

    /**
     * Sets a value in the config
     *
     * @param key the key
     * @param value the value
     * @return the config
     */
    IConfig set(String key, Object value);

    /**
     * Loads the config
     *
     * @return the config
     */
    IConfig load();

    /**
     * Checks if the config has a key
     *
     * @param key the key
     * @return true if the config has the key, false otherwise
     */
    boolean has(String key);

    /**
     * Saves the config
     *
     * @return the config
     */
    IConfig save();

    /**
     * Converts the config to a string
     *
     * @return the config as a string
     */
    String toString();

}
