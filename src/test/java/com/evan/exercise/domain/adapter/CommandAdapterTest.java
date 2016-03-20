package com.evan.exercise.domain.adapter;

import com.evan.exercise.commands.RobotPlacer;
import com.evan.exercise.domain.Facing;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.CardinalDirection;
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
public class CommandAdapterTest {

    @Mock
    private PointValidator pointValidator;

    @Mock
    private RobotPlacer robotPlacer;

    @InjectMocks
    private CommandAdapter subject;

    private MovableRobot robot;



    @Test
    public void process_shouldMoveRobotOneUnitInCurrentDirection_whenCommandIsMove() {
        //Given:
        final int startingX = randomInt();
        final int expectedResult = startingX + Robot.MOVE_UNIT;
        final String placeCommand = String.format("%s %s,%s,%s", "PLACE",  startingX, 1, "EAST");

        robot = new Robot()
                .setCurrentPosition(new Position(pointValidator).setX(startingX))
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        when(pointValidator.isPointWithinTableBounds(expectedResult)).thenReturn(true);

        subject.placeOnBoard(placeCommand);
        subject.process("MOVE");

        //then:
        final int actual = robot.getCurrentPosition().getX();
        assertThat(actual, is(expectedResult));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionLeft_whenCommandIsLeft() {
        //Given:
        final String placeCommand = String.format("%s %s,%s,%s", "PLACE", 1, 1, "EAST");
        robot = new Robot()
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        subject.placeOnBoard(placeCommand);
        subject.process("LEFT");

        //then:
        final Facing actual = robot.getFacing();
        assertThat(actual, is(CardinalDirection.NORTH));
    }

    @Test
    public void process_shouldRotateRobotOneCardinalDirectionRight_whenCommandIsRight() {
        //Given:
        final String placeCommand = String.format("%s %s,%s,%s", "PLACE", 1, 1, "EAST");
        robot = new Robot()
                .setFacing(CardinalDirection.EAST);

        when(robotPlacer.placeRobot(placeCommand)).thenReturn(robot);
        subject.placeOnBoard(placeCommand);
        subject.process("RIGHT");

        //then;
        final Facing actual = robot.getFacing();
        assertThat(actual, is(CardinalDirection.SOUTH));
    }

}