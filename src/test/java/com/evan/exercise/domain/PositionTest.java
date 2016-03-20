package com.evan.exercise.domain;

import com.evan.exercise.validator.PointValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PositionTest {

    private PointValidator pointValidator;

    private Position SUBJECT;

    @Before
    public void setUp() {
        pointValidator = Mockito.mock(PointValidator.class);
        SUBJECT = new Position(pointValidator);
    }

    @Test
    public void setX_shouldReturnAPositionWithXSetTo_input() {
        final int input = 3;
        SUBJECT = new Position()
                .setX(input);

        final int actual = SUBJECT.getX();
        assertThat(actual, is(input));
    }

    @Test
    public void setY_shouldReturnAPositionWithYSetTo_input() {
        final int input = 2;
        SUBJECT = new Position()
                .setY(input);

        final int actual = SUBJECT.getY();
        assertThat(actual, is(input));
    }


    @Test
    public void moveNorth_shouldIncreaseYPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = 3;
        final int expectedResult = input + moveUnit;
        SUBJECT.setY(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.incrementY(moveUnit);
        final int actual = SUBJECT.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveSouth_shouldDecreaseYPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = 2;
        final int expectedResult = input - moveUnit;
        SUBJECT.setY(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.decrementY(moveUnit);
        final int actual = SUBJECT.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveEast_shouldIncreaseXPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = 0;
        final int expectedResult = input + moveUnit;
        SUBJECT.setX(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.incrementX(moveUnit);
        final int actual = SUBJECT.getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void moveWest_shouldDecreaseXPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = 1;
        final int expectedResult = input - moveUnit;
        SUBJECT.setX(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.decrementX(moveUnit);
        final int actual = SUBJECT.getX();
        assertThat(actual, is(expectedResult));
    }
}