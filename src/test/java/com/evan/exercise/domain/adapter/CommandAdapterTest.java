package com.evan.exercise.domain.adapter;

import com.evan.exercise.cardinaldirections.East;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.Facing;
import com.evan.exercise.validator.PointValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class CommandAdapterTest {

    private PointValidator pointValidator;
    private MovableRobot robot;
    private CommandAdapter SUBJECT;

    @Before
    public void setUp() {
        pointValidator = Mockito.mock(PointValidator.class);
    }

    @Test
    public void process_shouldMoveRobotOneUnitInCurrentDirection_whenCommandIsMove() {
        final int startingX = randomInt();
        final int expectedResult = startingX + Robot.MOVE_UNIT;

        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);
        robot = new Robot()
                .setCurrentCardinalDirection(new East())
                .setCurrentPosition(new Position(pointValidator).setX(startingX));

        SUBJECT = new CommandAdapter(robot);
        SUBJECT.process("MOVE");

        final int actual = robot.getCurrentPosition().getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionLeft_whenCommandIsLeft() {
        robot = new Robot()
                .setCurrentCardinalDirection(new East());

        SUBJECT = new CommandAdapter(robot);
        SUBJECT.process("LEFT");

        final Facing actual = robot.getCurrentCardinalDirection().getFacing();
        assertThat(actual, is(Facing.NORTH));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionRight_whenCommandIsRight() {
        robot = new Robot()
                .setCurrentCardinalDirection(new East());

        SUBJECT = new CommandAdapter(robot);
        SUBJECT.process("RIGHT");

        final Facing actual = robot.getCurrentCardinalDirection().getFacing();
        assertThat(actual, is(Facing.SOUTH));
    }

}