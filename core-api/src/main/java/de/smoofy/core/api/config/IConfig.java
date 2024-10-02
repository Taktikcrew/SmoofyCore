package de.smoofy.core.api.config;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 14:27
 */

public interface IConfig {

    <T> T get(String key, Class<T> clazz);

    IConfig addIfNotExists(String key, Object state);

    IConfig set(String key, Object object);

    IConfig load();

    boolean has(String key);

    IConfig save();

    String toString();

}
