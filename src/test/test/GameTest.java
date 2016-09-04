package test;

import org.junit.Test;
import yura.Items.ItemsEnum;
import yura.Items.WinningItem;
import yura.ScoreManager;
import yura.Winning;

import static org.junit.Assert.*;

/**
 * Created by yterletskyi on 04.09.16.
 */
public class GameTest {

    @Test
    public void emulate() throws Exception {

        Winning winning = new Winning();
        winning.initWinnings(
                new WinningItem(ItemsEnum.CHERRY),
                new WinningItem(ItemsEnum.CHERRY),
                new WinningItem(ItemsEnum.SEVEN)
        );

        ScoreManager scoreManager = new ScoreManager(winning);
        scoreManager.setBet(3);

        assertEquals(scoreManager.wonScores(), 15);
    }


}