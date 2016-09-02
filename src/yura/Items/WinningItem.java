package yura.Items;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class WinningItem {

    private ItemsEnum mType;

    public WinningItem(ItemsEnum type) {
        mType = type;
    }

    public ItemsEnum getType() {
        return mType;
    }
}
