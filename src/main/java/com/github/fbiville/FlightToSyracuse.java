package com.github.fbiville;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Objects.toStringHelper;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.util.Collections.max;

public class FlightToSyracuse {

    private final List<Long> flightSequence = new ArrayList<Long>();
    private final long initial;

    public FlightToSyracuse(long initial) {
        this.initial = initial;
        flightSequence.add(initial);
    }

    public FlightToSyracuse(String planeName) {
        this(new PlaneToLong().convert(planeName));
    }

    static long nextRound(long result) {
        result = result % 2 == 0 ? result / 2 : result * 3 + 1;
        return result;
    }

    public long takeOff() {
        return iterate(initial);
    }

    public List<Long> getFlightSequence() {
        return flightSequence;
    }

    public long getMaxAltitude() {
        return max(flightSequence);
    }

    public long getHighFlyingTime() {
        long result = 0;
        for (long item: flightSequence) {
            if (item < initial) {
                break;
            }
            result++;
        }
        return result;
    }

    public String toString() {
        return toStringHelper(this)
            .add("Initial value", initial)
            .add("High-flying time", getHighFlyingTime())
            .add("Max altitude", getMaxAltitude())
            .add("Flight sequence", flightSequence)
        .toString();
    }

    private long iterate(long result) {
        while (result > 1) {
            if (isPowerOf2(result)) {
                handlePowersOf2(result);
                break;
            }

            result = nextRound(result);
            flightSequence.add(result);
        }
        return result;
    }

    private boolean isPowerOf2(long result) {
        double powersOf2 = log(result) / log(2);
        return (powersOf2 - (long) powersOf2) == 0;
    }

    //yep, just for the fun of it
    private void handlePowersOf2(long result) {
        long powersOf2 = (long) (log(result) / log(2));
        for (long i = powersOf2 - 1 ; i >= 0; i--) {
            flightSequence.add((long) pow(2, i));
        }
    }
}
