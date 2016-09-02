package yura;

import yura.Items.ItemsEnum;

/**
 * Created by yterletskyi on 30.08.16.
 */
public class ScoreManager {

    private int mBet;
    private int mWonScores;
    private Winning mWinning;

    public ScoreManager(Winning winning) {
        mWinning = winning;
    }

    public void setBet(int bet) {
        mBet = bet;
    }

    public int wonScores() {
        if (mWinning.areAllItemsEqual()) {
            calcScoresIfAllTypesEqual(mWinning.getWinningItems().get(0).getType());
        } else if (isWinningFromList()) {
            calcScoresFromList();
        } else {
            calcScoresFromRestOfPaytable();
        }
        return mWonScores;
    }

    private void calcScoresFromRestOfPaytable() {
        int price = 0;
        if ((mWinning.barsCount() == 3) || (mWinning.cherriesCount() == 2)) {
            price = Prices.ANY_BAR_OR_CHERRY_AND_ANY_TWO;
        } else if (mWinning.cherriesCount() == 1) {
            price = Prices.CHERRY_AND_ANY_ONE;
        }
        mWonScores = mBet * price;
    }

    private void calcScoresFromList() {
        int price = 0;
        if (mWinning.diamondsCount() == 1) {
            if (mWinning.doubleBarsCount() == 2) {
                price = Prices.DOUBLE_BAR_TWO_AND_DIAMOND_ONE;
            } else if (mWinning.tripleBarsCount() == 2) {
                price = Prices.TRIPLE_BAR_TWO_AND_DIAMOND_ONE;
            } else if (mWinning.singleBarsCount() == 2) {
                price = Prices.SINGLE_BAR_TWO_AND_DIAMOND_ONE;
            } else if (mWinning.cherriesCount() == 2) {
                price = Prices.CHERRY_TWO_AND_DIAMOND_ONE;
            } else if (mWinning.sevensCount() == 2) {
                price = Prices.SEVEN_TWO_AND_DIAMOND_ONE;
            }
        } else if (mWinning.diamondsCount() == 2) {
            if (mWinning.doubleBarsCount() == 1) {
                price = Prices.DOUBLE_BAR_ONE_AND_DIAMOND_TWO;
            } else if (mWinning.tripleBarsCount() == 1) {
                price = Prices.TRIPLE_BAR_ONE_AND_DIAMOND_TWO;
            } else if (mWinning.singleBarsCount() == 1) {
                price = Prices.SINGLE_BAR_ONE_AND_DIAMOND_TWO;
            } else if (mWinning.cherriesCount() == 1) {
                price = Prices.CHERRY_ONE_AND_DIAMOND_TWO;
            } else if (mWinning.sevensCount() == 1) {
                price = Prices.SEVEN_ONE_AND_DIAMOND_TWO;
            }
        }
        mWonScores = mBet * price;
    }

    private boolean isWinningFromList() {
        return mWinning.diamondsCount() >= 1 && mWinning.hasTwoEqualItems();
    }

    private void calcScoresIfAllTypesEqual(ItemsEnum allType) {
        if (allType.equals(ItemsEnum.DIAMOND)) {
            if (mBet == 1) {
                mWonScores = Prices.ALL_DIAMONDS_BET_ONE;
            } else if (mBet == 2) {
                mWonScores = Prices.ALL_DIAMONDS_BET_TWO;
            } else if (mBet == 3) {
                mWonScores = Prices.ALL_DIAMONDS_BET_THREE;
            }
        } else if (allType.equals(ItemsEnum.SEVEN)) {
            mWonScores = mBet * Prices.ALL_SEVENS;
        } else if (allType.equals(ItemsEnum.TRIPLE_BAR)) {
            mWonScores = mBet * Prices.ALL_TRIPLE_BARS;
        } else if (allType.equals(ItemsEnum.DOUBLE_BAR)) {
            mWonScores = mBet * Prices.ALL_DOUBLE_BARS;
        } else if (allType.equals(ItemsEnum.SINGLE_BAR) || allType.equals(ItemsEnum.CHERRY)) {
            mWonScores = mBet * Prices.ALL_SINGLE_BARS_OR_CHERRIES;
        }
    }

}
