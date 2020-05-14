package me.sfiguz7.transcendence.implementation.listeners;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class TranscEndenceGuideListener implements Listener {

    private final boolean giveOnFirstJoin;

    public TranscEndenceGuideListener(SlimefunAddon addon, boolean giveOnFirstJoin) {
        this.giveOnFirstJoin = giveOnFirstJoin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (giveOnFirstJoin && !e.getPlayer().hasPlayedBefore()) {
            Player p = e.getPlayer();

            p.getInventory().addItem(getGuide());
        }
    }

    public static ItemStack getGuide() {
        List<String> pages = new ArrayList<String>();
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle("TranscEndence Guide");
        meta.setAuthor("Sfiguz7");
        //Page 3 has an extra space after "Polarizer" otherwise "in" gets cut
        pages.add(ChatColors.color("你好！ 这是进阶模组的快速指南。\n\n" +
                "&a孤立元素 &r是主要的材料，只能通过&9振荡器&a获得 " +
                "&r(只能在末地里才能工作!)."));
        pages.add(ChatColors.color("你将得到四种不同的孤立元素，取决于&9旋转方向 : &r上, 下, 左, " +
                "右.\n\n" +
                "你可以强制振荡器产生更多垂直或水平旋转的孤立元素" +
                "通过使用相对应的 &d偏光片  &r在紫色的空格内."));
        pages.add(ChatColors.color("&4不稳定的锭 &r是基本的材料以获取终极物品:" +
                "注意, 他们将会&c杀死 &r你并且消失如果你将它拿在手中并持续几秒钟.\n\n" +
                "非常建议你使用货运通道来移动他们."));
        pages.add(ChatColors.color("&a左特 &r只能被&a左特过载器&r充能, 孤立元素" +
                "将会被消耗以充能左特.\n\n" +
                "如果左特的方向与孤立元素的方向一致，则充能比例为 1:1 , 如果不同，则为 16:1."));
        pages.add(ChatColors.color("&a终极元素 &r是最终的终极产物: 每一种元素" +
                "都会给你不同的效果一直持续到你死亡.\n" +
                "你可以根据名字来判断他们的效果\n" +
                "死亡时，你每获得一种效果将掉落8个稳定方块，也就是说你仅需要一颗额外的下界之星" +
                "即可再次制造终极元素"));
        meta.setPages(pages);
        book.setItemMeta(meta);
        return book;

    }
}
