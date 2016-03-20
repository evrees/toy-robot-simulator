package com.evan.exercise.domain.adapter;

import com.evan.exercise.commands.RobotPlacer;
import com.evan.exercise.domain.Facing;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.CardinalDirection;
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
    private RobotPlacer robotPlacer;
    private MovableRobot robot;
    private CommandAdapter SUBJECT;

    @Before
    public void setUp() {
        pointValidator = Mockito.mock(PointValidator.class);
        robotPlacer = Mockito.mock(RobotPlacer.class);
        SUBJECT = new CommandAdapter(robotPlacer);
    }

    @Test
    public void process_shouldMoveRobotOneUnitInCurrentDirection_whenCommandIsMove() {
        final int startingX = randomInt();
        final int expectedResult = startingX + Robot.MOVE_UNIT;
        final String placeCommand = String.format("%s,%s,%s,%s", "PLACE", startingX, 1, "EAST");

        robot = new Robot()
                .setCurrentPosition(new Position(pointValidator).setX(startingX))
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        SUBJECT.placeOnBoard(placeCommand);
        SUBJECT.process("MOVE");

        final int actual = robot.getCurrentPosition().getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionLeft_whenCommandIsLeft() {
        final String placeCommand = String.format("%s,%s,%s,%s", "PLACE", 1, 1, "EAST");
        robot = new Robot()
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        SUBJECT.placeOnBoard(placeCommand);
        SUBJECT.process("LEFT");

        final Facing actual = robot.getFacing();
        assertThat(actual, is(CardinalDirection.NORTH));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionRight_whenCommandIsRight() {
        final String placeCommand = String.format("%s,%s,%s,%s", "PLACE", 1, 1, "EAST");
        robot = new Robot()
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        SUBJECT.placeOnBoard(placeCommand);
        SUBJECT.process("RIGHT");

        final Facing actual = robot.getFacing();
        assertThat(actual, is(CardinalDirection.SOUTH));
    }

}