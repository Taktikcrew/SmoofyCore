/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.smoofy.core.api.config.IConfig;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

public class ConfigImpl implements IConfig {

    private final File directory;
    private final String fileName;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private JsonObject jsonObject = new JsonObject();

    public ConfigImpl(File directory, String fileName) {
        this.directory = directory;
        if (!fileName.endsWith(".json")) {
            fileName = fileName.split("\\.")[0] + ".json";
        }
        this.fileName = fileName;
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return GSON.fromJson(this.jsonObject.get(key), clazz);
    }

    @Override
    public IConfig addIfNotExists(String key, Object state) {
        if (!this.has(key)) {
            this.set(key, state);
        }
        return this;
    }

    @Override
    public IConfig set(String key, Object object) {
        this.jsonObject.add(key, GSON.toJsonTree(object, object.getClass()));
        return this;
    }

    @SneakyThrows
    @Override
    public IConfig load() {
        var path = new File(directory, fileName).toPath();
        if (Files.notExists(path)) {
            this.jsonObject = new JsonObject();
            return this;
        }
        var bufferedReader = Files.newBufferedReader(path);
        this.jsonObject = (JsonObject) JsonParser.parseReader(bufferedReader);
        bufferedReader.close();
        return this;
    }

    @Override
    public boolean has(String key) {
        return this.jsonObject.has(key);
    }

    @SneakyThrows
    @Override
    public IConfig save() {
        var path = new File(directory, fileName).toPath();
        if (!directory.exists() || Files.notExists(path)) {
            directory.mkdirs();
            Files.createFile(path);
        }
        var bufferedWriter = Files.newBufferedWriter(path);
        bufferedWriter.write(GSON.toJson(this.jsonObject));
        bufferedWriter.close();
        return this;
    }

    @Override
    public String toString() {
        return this.jsonObject.toString();
    }
}
