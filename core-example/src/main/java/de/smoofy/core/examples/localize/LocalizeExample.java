package de.smoofy.core.examples.localize;

/*
 * Copyright ©️
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * Created - 02.10.24, 11:51
 */

import de.smoofy.core.api.Core;
import de.smoofy.core.api.localization.ILocalize;
import de.smoofy.core.api.localization.Language;
import de.smoofy.core.examples.CoreExample;
import org.bukkit.entity.Player;

public class LocalizeExample {

    private final ILocalize localize;

    public LocalizeExample() {
        this.localize = Core.instance().localize(CoreExample.class);
        this.localize.loadLanguages(Language.GERMAN);
    }

    public void test(Player player) {
        player.sendRichMessage(this.localize.translate(Language.GERMAN, "test.localization", "Das ist das Replacement!"));
    }

}
