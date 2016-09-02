package yura;

import yura.Items.*;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class ItemFactory {

    public static WinningItem createWinningItem(ItemsEnum itemType) {
        switch (itemType) {
            case CHERRY:
                return new Cherry();
            case SEVEN:
                return new Seven();
            case DIAMOND:
                return new Diamond();
            case SINGLE_BAR:
                return new SingleBar();
            case DOUBLE_BAR:
                return new DoubleBar();
            case TRIPLE_BAR:
                return new TripleBar();
        }
        throw new IllegalArgumentException();
    }

}
