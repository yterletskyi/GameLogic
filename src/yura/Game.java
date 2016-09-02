package yura;

import yura.Items.ItemsEnum;

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
        Winning winning = new Winning(mSlotItemsCount);
        ScoreManager scoreManager = new ScoreManager(winning);
        scoreManager.setBet(bet);
        return scoreManager.wonScores();
    }

    // DOUBLE_BAR CHERRY CHERRY
    // SINGLE_BAR DIAMOND DIAMOND

}
