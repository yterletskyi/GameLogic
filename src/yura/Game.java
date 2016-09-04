package yura;

import yura.Items.ItemsEnum;
import yura.Items.WinningItem;

import java.util.Random;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class Game {

    public static final int SLOTS_COUNT = 3;
    private final int mSlotItemsCount;

    public Game() {
        mSlotItemsCount = ItemsEnum.values().length;
    }

    public int spin(int bet) {
        Winning winning = new Winning();
        winning.initWinnings(
                getWheelValue(),
                getWheelValue(),
                getWheelValue()
        );
        winning.printItems();
        ScoreManager scoreManager = new ScoreManager(winning);
        scoreManager.setBet(bet);
        return scoreManager.wonScores();
    }

    private WinningItem getWheelValue() {
        Random random = new Random();
        int index = random.nextInt(mSlotItemsCount);
        ItemsEnum selectedItemType = ItemsEnum.values()[index];
        return new WinningItem(selectedItemType);
    }
}
