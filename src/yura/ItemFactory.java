package yura;

import yura.Items.ItemsEnum;
import yura.Items.WinningItem;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class ItemFactory {

    public static WinningItem createWinningItem(ItemsEnum itemType) {
        return new WinningItem(itemType);
    }
}
