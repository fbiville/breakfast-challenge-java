package com.github.fbiville;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlaneToLongTest {

    @Test
    public void should_return_length_0_for_empty_string() {
        assertThat(new PlaneToLong().convert("")).isEqualTo(0L);
    }

    @Test
    public void should_return_length_1057_for_enterprise() {
        assertThat(new PlaneToLong().convert("Enterprise")).isEqualTo(1057L);
    }

    @Test
    public void should_return_length_1057_for_fauconmillenium() {
        assertThat(new PlaneToLong().convert("FauconMillenium")).isEqualTo(1544L);
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_exception_with_null_name() {
        new PlaneToLong().convert(null);
    }
}
