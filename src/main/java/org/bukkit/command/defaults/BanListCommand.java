package org.bukkit.command.defaults;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import com.google.common.collect.ImmutableList;

public class BanListCommand extends VanillaCommand {
    private static final List<String> BANLIST_TYPES = ImmutableList.of("ips", "players");

    public BanListCommand() {
        super("banlist");
        this.description = "View all players banned from this server";
        this.usageMessage = "/banlist [ips|players]";
        this.setPermission("bukkit.command.ban.list");
    }

    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if (!testPermission(sender)) return true;
        if (args.length == 0 || !BANLIST_TYPES.contains(args[0].toLowerCase()))  {
            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
            return false;
        }

        boolean isIPListing = args[0].toLowerCase().equals("ips");
        BanList.Type banListType = isIPListing ? BanList.Type.IP : BanList.Type.PLAYER;
        StringBuilder message = new StringBuilder();
        BanEntry[] banlist = Bukkit.getBanList(banListType).getBanEntries().toArray(new BanEntry[0]);

        for (int x = 0; x < banlist.length; x++) {
            if (x != 0) {
                if (x == banlist.length - 1) {
                    message.append(" and ");
                } else {
                    message.append(", ");
                }
            }
            message.append(banlist[x].getName());
        }

        sender.sendMessage("There are " + banlist.length + " total banned " + (isIPListing ? "IPs" : "players") + ":");
        sender.sendMessage(message.toString());
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        Validate.notNull(sender, "Sender cannot be null");
        Validate.notNull(args, "Arguments cannot be null");
        Validate.notNull(alias, "Alias cannot be null");

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], BANLIST_TYPES, new ArrayList<String>(BANLIST_TYPES.size()));
        }
        return ImmutableList.of();
    }
}
