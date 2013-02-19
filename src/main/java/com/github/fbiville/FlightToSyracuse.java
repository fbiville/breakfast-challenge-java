package com.github.fbiville;

import java.util.ArrayList;
import java.util.List;

import static com.github.fbiville.Arithmetic.isPowerOf2;
import static com.github.fbiville.Arithmetic.log2;
import static com.google.common.base.Objects.toStringHelper;
import static java.lang.Math.pow;
import static java.util.Collections.max;

public class FlightToSyracuse {

    private final List<Long> flightSequence = new ArrayList<Long>();
    private final long initial;

    public FlightToSyracuse(String planeName) {
        this(new PlaneToLong().convert(planeName));
    }

    FlightToSyracuse(long initial) {
        this.initial = initial;
        flightSequence.add(initial);
    }

    static long nextRound(long result) {
        result = result % 2 == 0 ? result / 2 : result * 3 + 1;
        return result;
    }

    public void takeOff() {
        iterate(initial);
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

    private void iterate(long result) {
        while (result > 1) {
            if (isPowerOf2(result)) {
                handlePowersOf2(result);
                break;
            }

            result = nextRound(result);
            flightSequence.add(result);
        }
    }

    //yep, just for the fun of it
    private void handlePowersOf2(long result) {
        long powersOf2 = (long) log2(result);
        for (long i = powersOf2 - 1 ; i >= 0; i--) {
            flightSequence.add((long) pow(2, i));
        }
    }
}
