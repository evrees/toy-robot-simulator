package com.evan.exercise.commands;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.CardinalDirection;
import com.evan.exercise.transformer.StringListToRobotTransformer;
import com.evan.exercise.validator.PlaceCommandValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PlaceCommandTest {


    private PlaceCommandValidator placeCommandValidator;
    private StringListToRobotTransformer robotTransformer;
    private PlaceCommand SUBJECT;

    @Before
    public void setUp() {
        robotTransformer = Mockito.mock(StringListToRobotTransformer.class);
        placeCommandValidator = Mockito.mock(PlaceCommandValidator.class);

        SUBJECT = new PlaceCommand(robotTransformer, placeCommandValidator);
    }

    @Test
    public void placeRobot_shouldReturnARobot() {
        final String place = "PLACE";
        final int x = randomInt();
        final int y = randomInt();
        final String facing = "SOUTH";
        final String placeCommand = String.format("%s,%s,%s,%s", place, x, y, facing);
        final List<String> placeCommandParts = Stream.of(placeCommand.split(",")).collect(Collectors.toList());

        final MovableRobot expectedResult = new Robot()
                .setCurrentPosition(new Position().setX(x).setY(y))
                .setFacing(CardinalDirection.valueOf(facing));

        when(robotTransformer.createRobot(placeCommandParts)).thenReturn(expectedResult);
        final MovableRobot actual = SUBJECT.placeRobot(placeCommand);

        assertThat(actual.getCurrentPosition().getX(), is(x));
        assertThat(actual.getCurrentPosition().getY(), is(y));
        assertThat(actual.getFacing(), is(CardinalDirection.SOUTH));
    }

}