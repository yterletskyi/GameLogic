package yura;

import yura.rtp.Range;
import yura.rtp.WinRandom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        int bet = 1;

        double rtp = 0.95;
        double winPercent = 30;


        long totalBet = 0;
        long totalWin = 0;

        WinRandom winRandom = new WinRandom();
        int win = 0;

        double[] winnings = {800, 160, 80, 50, 40, 25, 20, 10, 5, 2, 0};
        double[] probabilities = calcProbabilities(winPercent / 100, 0.5);


        int multiplier = multiplier(probabilities, 100);

        System.out.println(sumProduct(probabilities, winnings));

        int size = probabilities.length;
        for (int i = 0; i < size; i++) {
            double prob = probabilities[i];
            prob *= multiplier;
            prob = Math.round(prob);
            probabilities[i] = prob;
        }

        System.out.println("multiplier: " + multiplier);

        Map<Range<Double>, Integer> winRangeMap = new HashMap<>();
        double prevValue = 0;
        for (int i = 0; i < winnings.length; i++) {
            double iWin = winnings[i];
            double iProb = probabilities[i];
            winRangeMap.put(new Range<>(prevValue, iProb + iProb), (int) iWin);
            prevValue += iProb;
        }

//        double total = sum(probabilities);

//        for (int i = 0; i < 1_000_000; i++) {
//
//            double rand = winRandom.randIntIncluding((int) total);
//
//            for (Map.Entry<Range<Double>, Integer> entry : winRangeMap.entrySet()) {
//                Range<Double> range = entry.getKey();
//                Integer winInteger = entry.getValue();
//
//                if (range.isInRange(rand)) {
//                    win = winInteger;
//                }
//            }
//            totalWin += win;
//            totalBet += bet;
//        }
//
//        double rtpCheck = (double) totalWin / (double) totalBet;
//        System.out.println(rtpCheck);


    }

    private static double sum(double[] array) {
        double sum = 0;
        for (double a : array) {
            sum += a;
        }
        return sum;
    }

//    private static int spin(int winPercent, double rtp) {
//
//    }

//    private static int multiplier(double[] probabilities, int precision) {
//        precision /= 10;
//        int multiplier = 1;
//        for (double prob : probabilities) {
//            while (prob <= precision) {
//                prob *= multiplier;
//                if (prob < precision) {
//                    multiplier *= 10;
//                }
//            }
//        }
//        // todo check if I didn't change probabilities here
//        return multiplier;
//    }

    private static int multiplier(double[] probabilities, int precision) {
        int multiplier = 1;
        Arrays.sort(probabilities);

        double prob = probabilities[0];

        while (prob < precision) {
            multiplier *= 10;
            prob *= 10;
        }

        return multiplier;
    }

    private static double sumProduct(double[] array1, double[] array2) {
        int size = array1.length;
        double sum = 0;
        for (int i = 0; i < size; i++) {
            double a1 = array1[i];
            double a2 = array2[i];
            sum += a1 * a2;
        }
        return sum;
    }

    private static double[] calcProbabilities(double max, final double k) {
        int size = 11;
        double[] probabilities = new double[size];
        probabilities[size - 1] = 1 - max;
        for (int i = 0; i < size - 1; i++) {
            double dif = max * k;
            max = max - dif;
            probabilities[i] = dif;
        }
        return probabilities;
    }
}
