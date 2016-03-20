package com.evan.exercise.factory;

import com.evan.exercise.cardinaldirections.*;
import com.evan.exercise.domain.enums.Facing;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CardinalDirectionFactoryTest {

    private final CardinalDirectionFactory SUBJECT = new CardinalDirectionFactory();

    @Test
    public void create_shouldReturnCardinalDirectionNorth() {
        final String facing = "NORTH";
        final CardinalDirection actual = SUBJECT.get(facing);
        assertThat(actual, instanceOf(North.class));
        assertThat(actual.getFacing(), is(Facing.NORTH));
    }

    @Test
    public void create_shouldReturnCardinalDirectionSouth() {
        final String facing = "SOUTH";
        final CardinalDirection actual = SUBJECT.get(facing);
        assertThat(actual, instanceOf(South.class));
        assertThat(actual.getFacing(), is(Facing.SOUTH));
    }

    @Test
    public void create_shouldReturnCardinalDirectionEast() {
        final String facing = "East";
        final CardinalDirection actual = SUBJECT.get(facing);
        assertThat(actual, instanceOf(East.class));
        assertThat(actual.getFacing(), is(Facing.EAST));
    }

    @Test
    public void create_shouldReturnCardinalDirectionWest() {
        final String facing = "west";
        final CardinalDirection actual = SUBJECT.get(facing);
        assertThat(actual, instanceOf(West.class));
        assertThat(actual.getFacing(), is(Facing.WEST));
    }
}