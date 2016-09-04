package yura;

import yura.Items.ItemsEnum;
import yura.Items.WinningItem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class Winning {

    private ArrayList<WinningItem> mWinningItems;

    public Winning() {
        mWinningItems = new ArrayList<>(Game.SLOTS_COUNT);
    }

    public void initWinnings(WinningItem... items) {
        Collections.addAll(mWinningItems, items);
    }

    public void printItems() {
        for (WinningItem item : mWinningItems) {
            System.out.printf("%s ", item.getType());
        }
        System.out.println();
    }

    public boolean areAllItemsEqual() {
        ItemsEnum itemType = mWinningItems.get(0).getType();
        for (int i = 1; i < mWinningItems.size(); i++) {
            if (!mWinningItems.get(i).getType().equals(itemType)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasTwoEqualItems() {
        ItemsEnum itemOne = mWinningItems.get(0).getType();
        ItemsEnum itemTwo = mWinningItems.get(1).getType();
        ItemsEnum itemThree = mWinningItems.get(2).getType();
        return itemOne.equals(itemTwo) || itemTwo.equals(itemThree) || itemOne.equals(itemThree);
    }

    private int countOf(ItemsEnum itemType) {
        int count = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(itemType)) {
                count++;
            }
        }
        return count;
    }

    public int diamondsCount() {
        return countOf(ItemsEnum.DIAMOND);
    }

    public int doubleBarsCount() {
        return countOf(ItemsEnum.DOUBLE_BAR);
    }

    public int tripleBarsCount() {
        return countOf(ItemsEnum.TRIPLE_BAR);
    }

    public int singleBarsCount() {
        return countOf(ItemsEnum.SINGLE_BAR);
    }

    public int cherriesCount() {
        return countOf(ItemsEnum.CHERRY);
    }

    public int sevensCount() {
        return countOf(ItemsEnum.SEVEN);
    }

    public int barsCount() {
        int barsCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.SINGLE_BAR)
                    || item.getType().equals(ItemsEnum.DOUBLE_BAR)
                    || item.getType().equals(ItemsEnum.TRIPLE_BAR)
                    ) {
                barsCount++;
            }
        }
        return barsCount;
    }

    public ArrayList<WinningItem> getWinningItems() {
        return mWinningItems;
    }
}
