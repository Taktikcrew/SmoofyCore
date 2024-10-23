/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.base.fetcher;

import com.google.common.collect.Maps;
import de.smoofy.core.api.fetcher.IUUIDFetcher;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UUIDFetcherImpl implements IUUIDFetcher {

    private final Pattern NAME_PATTERN = Pattern.compile(",\\s*\"name\"\\s*:\\s*\"(.*?)\"");
    private final Pattern UUID_PATTERN = Pattern.compile("\"id\"\\s*:\\s*\"(.*?)\"");

    private final Map<String, UUID> uuidCache = Maps.newHashMap();
    private final Map<UUID, String> nameCache = Maps.newHashMap();

    @Override
    public UUID uuid(@NotNull String name) {
        name = name.toLowerCase();
        if (this.uuidCache.containsKey(name)) return uuidCache.get(name);
        String url = this.callURL("https://api.mojang.com/users/profiles/minecraft/" + name);
        if (url == null) return null;
        Matcher matcher = UUID_PATTERN.matcher(url);
        if (matcher.find()) {
            String uuidString = matcher.group(1);
            UUID uuid = UUID.fromString(uuidString.substring(0, 8) + "-" + uuidString.substring(8, 12) + "-" +
                    uuidString.substring(12, 16) + "-" + uuidString.substring(16, 20) + "-" + uuidString.substring(20, 32));
            this.uuidCache.put(name, uuid);
            return uuid;
        }
        return null;
    }

    @Override
    public String name(@NotNull UUID uuid) {
        if (this.nameCache.containsKey(uuid)) return nameCache.get(uuid);
        String url = this.callURL("https://sessionserver.mojang.com/session/minecraft/profile/" +
                uuid.toString().replace("-", ""));
        if (url == null) return null;
        Matcher matcher = NAME_PATTERN.matcher(url);
        if (matcher.find()) {
            String name = matcher.group(1);
            this.nameCache.put(uuid, name);
            return name;
        }
        return null;
    }

    private String callURL(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        URLConnection urlConnection;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            urlConnection = new URI(url).toURL().openConnection();
            if (urlConnection != null) urlConnection.setReadTimeout(60 * 1000);
            if (urlConnection != null && urlConnection.getInputStream() != null) {
                inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            }
            if (bufferedReader != null) bufferedReader.close();
            if (inputStreamReader != null) inputStreamReader.close();
        } catch (Exception e) {
            return null;
        }
        return stringBuilder.toString();
    }
}
