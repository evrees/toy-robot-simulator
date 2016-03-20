package com.evan.exercise.domain.adapter;

import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.enums.CardinalDirection;
import com.evan.exercise.validator.PointValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PositionUpdateAdapterTest {

    private final int MOVE_UNIT = 1;
    private final PositionUpdateAdapter SUBJECT = new PositionUpdateAdapter(MOVE_UNIT);

    private PointValidator pointValidator;

    @Before
    public void setUp() {
        pointValidator = Mockito.mock(PointValidator.class);
    }

    @Test
    public void moveInCurrentDirection_shouldIncrementY_whenFacingIsNorth() {
        final CardinalDirection facing = CardinalDirection.NORTH;
        final int startingY = randomInt();
        final int expectedResult = startingY + MOVE_UNIT;
        final Position currentPosition = new Position(pointValidator).setY(startingY);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.moveInCurrentDirection(currentPosition, facing);
        int actual = currentPosition.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveInCurrentDirection_shouldDecrementY_whenFacingIsSouth() {
        final CardinalDirection facing = CardinalDirection.SOUTH;
        final int startingY = randomInt();
        final int expectedResult = startingY - MOVE_UNIT;
        final Position currentPosition = new Position(pointValidator).setY(startingY);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.moveInCurrentDirection(currentPosition, facing);
        int actual = currentPosition.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveInCurrentDirection_shouldIncrementX_whenFacingIsEast() {
        final CardinalDirection facing = CardinalDirection.EAST;
        final int startingX = randomInt();
        final int expectedResult = startingX + MOVE_UNIT;
        final Position currentPosition = new Position(pointValidator).setX(startingX);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.moveInCurrentDirection(currentPosition, facing);
        int actual = currentPosition.getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveInCurrentDirection_shouldDecrementX_whenFacingIsWest() {
        final CardinalDirection facing = CardinalDirection.WEST;
        final int startingX = randomInt();
        final int expectedResult = startingX - MOVE_UNIT;
        final Position currentPosition = new Position(pointValidator).setX(startingX);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.moveInCurrentDirection(currentPosition, facing);
        int actual = currentPosition.getX();
        assertThat(actual, is(expectedResult));
    }

}