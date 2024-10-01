package de.smoofy.core.examples.commands;
/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 29.09.24, 22:51
 */

import de.smoofy.core.examples.fetcher.UUIDFetcherExample;
import de.smoofy.core.examples.logger.LoggerExample;
import de.smoofy.core.examples.message.MessageBuilderExample;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestCommand implements CommandExecutor, TabCompleter {

    private final UUIDFetcherExample uuidFetcherExample = new UUIDFetcherExample();
    private final LoggerExample loggerExample = new LoggerExample();
    private final MessageBuilderExample messageBuilderExample = new MessageBuilderExample();

    public TestCommand() {
        Bukkit.getPluginCommand("test").setExecutor(this);
        Bukkit.getPluginCommand("test").setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("§cDu musst ein Spieler sein");
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "uuid" -> uuidFetcherExample.testUUID(player, args[1]);
            case "name" -> uuidFetcherExample.testName(player, args[1]);
            case "log" -> loggerExample.test();
            case "message" -> messageBuilderExample.test(player);
        }
        player.sendRichMessage("<green>Test ausgeführt");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return List.of("uuid", "name", "log", "message");
        }
        return List.of();
    }
}