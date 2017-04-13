package yura.rtp;

/**
 * Created by yterletskyi on 13.04.17.
 */
public class Range<T extends Comparable<T>> {

    private T mStartValue;
    private T mEndValue;

    public Range(T startValue, T endValue) {
        this.mStartValue = startValue;
        this.mEndValue = endValue;
    }

    public boolean isInRange(T value) {
        boolean biggerThanStart = mStartValue.compareTo(value) < 0;
        boolean smallerThanEnd = mEndValue.compareTo(value) >= 0;
        return biggerThanStart && smallerThanEnd;
    }

}
