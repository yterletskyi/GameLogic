package yura.Items;

/**
 * Created by yterletskyi on 30.08.16.
 */
public abstract class WinningItem {
    protected ItemsEnum mType;

    public ItemsEnum getType() {
        return mType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WinningItem) {
            WinningItem that = (WinningItem) obj;
            return mType.equals(that.mType);
        }
        return false;
    }
}
