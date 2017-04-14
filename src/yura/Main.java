package yura;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        int bet = 1;
//
        double rtp = 0.95;
        double winPercent = 0.3;
//
//        long totalBet = 0;
//        long totalWin = 0;
//
//        WinRandom winRandom = new WinRandom();
//        int win = 0;
//
        double[] winnings = {800, 160, 80, 50, 40, 25, 20, 10, 5, 2, 0};
//        double[] probabilities = metaCalcProbabilities(winPercent / 100, rtp, winnings);
//
//        for (double p : probabilities) {
//            System.out.println(p);
//        }
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
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i * i);
//        }


        double[] probs = calcProbabilities(rtp, winPercent);
        for (double p : probs) {
            System.out.printf("%.50f\n", p);
        }
//
//        double a = winPercent - (sum(probs) - probs[0]);
//
//        reverse(probs);
//        double b = rtp - sumProduct(probs, winnings);
//
//        System.out.println();


    }

    private static double[] reverse(double[] array) {
        multiplyBy(array, -1);
        Arrays.sort(array);
        multiplyBy(array, -1);
        return array;
    }

    private static double[] multiplyBy(double[] array, double mul) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= mul;
        }
        return array;
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
//        double[] values = calcProbabilities(max);
//
//        boolean isRtpCorrect = isRtpCorrect(wins, values, rtp);
//        while (!isRtpCorrect) {
//            values = calcProbabilities(max);
//            isRtpCorrect = isRtpCorrect(wins, values, rtp);
//        }
        return null;
    }

    private static boolean isRtpCorrect(double[] wins, double[] values, double rtp) {
        return sumProduct(wins, values) - rtp <= 0.1;
    }

//    private static double[] calcProbabilities(double rtp, double max) {
//        int size = 11;
//        double[] probabilities = new double[size];
//        probabilities[0] = 1 - max;
//        probabilities[1] = getCoefficients()[0] * rtp;
//
//        for (int i = 1; i < getCoefficients().length; i++) {
//            double prev = probabilities[i];
//            double coef = getCoefficients()[i];
//            probabilities[i + 1] = prev * coef;
//        }
//        return probabilities;
//    }

    private static double[] calcProbabilities(double rtp, double max) {
        int size = 11;
        double[] probabilities = new double[size];
        probabilities[0] = 1 - max;

//        for (int i = 1; i < getCoefficients().length; i++) {
//            double prev = probabilities[i];
//            double coef = getCoefficients()[i];
//            probabilities[i + 1] = prev * coef;
//        }
        double step = 0.0375;
        max -= step;
        probabilities[1] = randomDoubleInRange(max - step, max);
        max -= probabilities[1];
        probabilities[2] = randomDoubleInRange(max - step, max);

        return probabilities;
    }

    private static double randomDoubleInRange(double rangeMin, double upperBound) {
        Random r = new Random();
        return rangeMin + (upperBound - rangeMin) * r.nextDouble();
    }

    private static double[] getCoefficients() {
        return new double[]{0.24, 0.25, 0.27, 0.135, 0.095, 0.5, 0.2, 0.5};
    }

}
