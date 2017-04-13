package yura;

import yura.rtp.WinRandom;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int bet = 1;

        double rtp = 0.95;
        double winPercent = 30;

        long totalBet = 0;
        long totalWin = 0;

        WinRandom winRandom = new WinRandom();
        int win = 0;

        double[] winnings = {800, 160, 80, 50, 40, 25, 20, 10, 5, 2, 0};
        double[] probabilities = metaCalcProbabilities(winPercent / 100, rtp, winnings);

        for (double p : probabilities) {
            System.out.println(p);
        }

//
//        int multiplier = multiplier(probabilities, 100);
//
//        System.out.println("checking rtp: " + sumProduct(probabilities, winnings));
//
//        int size = probabilities.length;
//        for (int i = 0; i < size; i++) {
//            double prob = probabilities[i];
//            prob *= multiplier;
//            prob = Math.round(prob);
//            probabilities[i] = prob;
//        }
//
//        System.out.println("multiplier: " + multiplier);
//
//        Map<Range<Double>, Integer> winRangeMap = new HashMap<>();
//        double prevValue = 0;
//        for (int i = 0; i < winnings.length; i++) {
//            double iWin = winnings[i];
//            double iProb = probabilities[i];
//            winRangeMap.put(new Range<>(prevValue, iProb + iProb), (int) iWin);
//            prevValue += iProb;
//        }
//
//        double total = sum(probabilities);
//
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
//        System.out.println("rtp is: " + rtpCheck);


    }

    private static double sum(double[] array) {
        double sum = 0;
        for (double a : array) {
            sum += a;
        }
        return sum;
    }

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

    private static double[] metaCalcProbabilities(double max, final double rtp, double[] wins) {
        double[] values = calcProbabilities(max);

        boolean isRtpCorrect = isRtpCorrect(wins, values, rtp);
        while (!isRtpCorrect) {
            values = calcProbabilities(max);
            isRtpCorrect = isRtpCorrect(wins, values, rtp);
        }
        return values;
    }

    private static boolean isRtpCorrect(double[] wins, double[] values, double rtp) {
        return sumProduct(wins, values) - rtp <= 0.1;
    }

    private static double[] calcProbabilities(double max) {
        int size = 11;
        double[] probabilities = new double[size];
        probabilities[size - 1] = 1 - max;
        for (int i = 0; i < size - 1; i++) {
            double prob = randomDoubleInRange(max);
            probabilities[i] = prob;
            max -= prob;
        }
        return probabilities;
    }

    private static double randomDoubleInRange(double upperBound) {
        Random r = new Random();
        double rangeMin = 0.000001;
        return rangeMin + (upperBound - rangeMin) * r.nextDouble();
    }
}
