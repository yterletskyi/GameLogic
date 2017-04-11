package yura;

import java.util.Random;

/**
 * Created by yterletskyi on 11.04.17.
 */
public class WinRandom {

    private static final int HUNDRED_PERCENT = 100;

    public boolean isWinCombination(int winPercent) {
        int randomInt = new Random().nextInt(HUNDRED_PERCENT + 1) - 1;
        return randomInt < winPercent;
    }

}
