/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 23.10.24, 13:13
 */

package de.smoofy.core.examples.config;

import de.smoofy.core.api.Core;
import de.smoofy.core.api.config.IConfig;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;

public class ConfigExample {

    private final File directory = new File(Bukkit.getWorldContainer() + "/plugins/CoreExample/");
    private final String fileName = "config.json";

    private final IConfig config = Core.instance().config(directory, fileName);

    public void testSave() {
        config.set("test", "Test");
        config.set("test.string", "TestString");
        config.set("test.int", 1);
        config.set("test.boolean", true);
        config.addIfNotExists("hallo", "Hallo Welt!");
        config.addIfNotExists("hallo", "Hallo Welt2!");
        config.addIfNotExists("test", "Hallo");
        config.save();
    }

    public void testLoad(Player player) {
        config.load();
        player.sendRichMessage(config.toString());
    }

    public void testSaveObject() {
        config.set("person", new Person("Smoofy", -1, true));
        config.save();
    }

    public void testLoadObject(Player player) {
        config.load();
        var person = config.get("person", Person.class);
        if (person == null) {
            return;
        }
        player.sendRichMessage(person.toString());
    }

    @AllArgsConstructor
    public static class Person {

        private final String name;
        private final int age;
        private final boolean isDeveloper;

        @Override
        public String toString() {
            return "Name: " + this.name + ", Age: " + this.age + ", Developer: " + this.isDeveloper;
        }
    }

}
