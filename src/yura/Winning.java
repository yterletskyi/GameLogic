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
        return ItemFactory.createWinningItem(selectedItemType);
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

    public int diamondsCount() {
        int diamondsCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.DIAMOND)) {
                diamondsCount++;
            }
        }
        return diamondsCount;
    }

    public boolean hasTwoEqualItems() {
        ItemsEnum itemOne = mWinningItems.get(0).getType();
        ItemsEnum itemTwo = mWinningItems.get(1).getType();
        ItemsEnum itemThree = mWinningItems.get(2).getType();

        return itemOne.equals(itemTwo) || itemTwo.equals(itemThree) || itemOne.equals(itemThree);

    }

    public int doubleBarsCount() {
        int doubleBarsCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.DOUBLE_BAR)) {
                doubleBarsCount++;
            }
        }
        return doubleBarsCount;
    }

    public int tripleBarsCount() {
        int tripleBarsCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.TRIPLE_BAR)) {
                tripleBarsCount++;
            }
        }
        return tripleBarsCount;
    }

    public int singleBarsCount() {
        int singleBarsCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.SINGLE_BAR)) {
                singleBarsCount++;
            }
        }
        return singleBarsCount;
    }

    public int cherriesCount() {
        int cherriesCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.CHERRY)) {
                cherriesCount++;
            }
        }
        return cherriesCount;
    }

    public int sevensCount() {
        int sevensCount = 0;
        for (WinningItem item : mWinningItems) {
            if (item.getType().equals(ItemsEnum.SEVEN)) {
                sevensCount++;
            }
        }
        return sevensCount;
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
