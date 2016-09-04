package yura;

import yura.Items.ItemsEnum;
import yura.Items.WinningItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class Winning {

    private ArrayList<WinningItem> mWinningItems;

    public Winning(int slotItemsCount) {
        mWinningItems = new ArrayList<>(Game.SLOTS_COUNT);
        Random random = new Random();
        initWinnings(
                getWheelValue(random.nextInt(slotItemsCount)),
                getWheelValue(random.nextInt(slotItemsCount)),
                getWheelValue(random.nextInt(slotItemsCount))
        );
    }

    private void initWinnings(WinningItem... items) {
        for (WinningItem item : items) {
            mWinningItems.add(item);
            System.out.printf("%s ", item.getType().toString());
        }
        System.out.println();
    }

    private WinningItem getWheelValue(int index) {
        ItemsEnum selectedItemType = ItemsEnum.values()[index];
        return new WinningItem(selectedItemType);
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
