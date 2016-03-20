package com.evan.exercise.domain;

import com.evan.exercise.validator.PointValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PositionTest {

    @Mock
    private PointValidator pointValidator;

    @InjectMocks
    private Position subject;

    @Test
    public void setX_shouldReturnAPositionWithXSetTo_input() {
        final int input = randomInt();
        subject.setX(input);

        final int actual = subject.getX();
        assertThat(actual, is(input));
    }

    @Test
    public void setY_shouldReturnAPositionWithYSetTo_input() {
        final int input = randomInt();
        subject.setY(input);

        final int actual = subject.getY();
        assertThat(actual, is(input));
    }

    @Test
    public void incrementY_shouldIncreaseYPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = randomInt();
        final int expectedResult = input + moveUnit;
        subject.setY(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        subject.incrementY(moveUnit);
        final int actual = subject.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void decrementY_shouldDecreaseYPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = randomInt();;
        final int expectedResult = input - moveUnit;
        subject.setY(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        subject.decrementY(moveUnit);
        final int actual = subject.getY();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void incrementX_shouldIncreaseXPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = randomInt();;
        final int expectedResult = input + moveUnit;
        subject.setX(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        subject.incrementX(moveUnit);
        final int actual = subject.getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void decrementX_shouldDecreaseXPointByOneMoveUnit() {
        final int moveUnit = randomInt();
        final int input = randomInt();;
        final int expectedResult = input - moveUnit;
        subject.setX(input);

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        subject.decrementX(moveUnit);
        final int actual = subject.getX();
        assertThat(actual, is(expectedResult));
    }
}