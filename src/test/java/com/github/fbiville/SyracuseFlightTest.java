package com.github.fbiville;

import org.junit.Test;

import static com.github.fbiville.SyracuseFlight.nextRound;
import static org.fest.assertions.Assertions.assertThat;

public class SyracuseFlightTest {

    @Test
    public void should_half_2() {
        assertThat(nextRound(2L)).isEqualTo(1L);
    }

    @Test
    public void should_half_4() {
        assertThat(nextRound(4L)).isEqualTo(2L);
    }

    @Test
    public void should_triple_3_and_add_1() {
        assertThat(nextRound(3L)).isEqualTo(10L);
    }

    @Test
    public void should_triple_5_and_add_1() {
        assertThat(nextRound(5L)).isEqualTo(16L);
    }

    @Test
    public void should_store_sequence_of_1_when_start_is_1() {
        SyracuseFlight flight = new SyracuseFlight(1L);
        flight.startFly();
        assertThat(flight.getFlightSequence()).containsExactly(1L);
    }

    @Test
    public void should_store_sequence_of_2_and_1_when_start_is_2() {
        SyracuseFlight flight = new SyracuseFlight(2L);
        flight.startFly();
        assertThat(flight.getFlightSequence()).containsExactly(2L, 1L);
    }

    @Test
    public void should_store_sequence_of_5_16_8_4_2_and_1_when_start_is_5() {
        SyracuseFlight flight = new SyracuseFlight(5L);
        flight.startFly();
        assertThat(flight.getFlightSequence()).containsExactly(5L,16L,8L,4L,2L,1L);
    }

    @Test
    public void should_return_high_flying_time_of_11_for_start_15() {
        SyracuseFlight flight = new SyracuseFlight(15L);
        flight.startFly();
        assertThat(flight.getHighFlyingTime()).isEqualTo(11L);
    }

    @Test
    public void should_return_max_altitude_of_160_for_start_15() {
        SyracuseFlight flight = new SyracuseFlight(15L);
        flight.startFly();
        assertThat(flight.getMaxAltitude()).isEqualTo(160L);
    }

}
