package com.evan.exercise.commands;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.CardinalDirection;
import com.evan.exercise.transformer.StringListToRobotTransformer;
import com.evan.exercise.validator.PlaceCommandValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RobotPlacerTest {

    @Mock
    private PlaceCommandValidator placeCommandValidator;

    @Mock
    private StringListToRobotTransformer robotTransformer;

    @InjectMocks
    private RobotPlacer subject;

    @Test
    public void placeRobot_shouldReturnARobot() {
        final String place = "PLACE";
        final int x = randomInt();
        final int y = randomInt();
        final String facing = "SOUTH";
        final String placeCommand = String.format("%s %s,%s,%s", place, x, y, facing);
        final List<String> placeCommandParts = Stream.of(placeCommand.split(",| ")).collect(Collectors.toList());

        //Given:
        final MovableRobot expectedResult = new Robot()
                .setCurrentPosition(new Position().setX(x).setY(y))
                .setFacing(CardinalDirection.valueOf(facing));

        when(robotTransformer.createRobot(placeCommandParts)).thenReturn(expectedResult);

        final MovableRobot actual = subject.placeRobot(placeCommand);

        //then:
        assertThat(actual.getCurrentPosition().getX(), is(x));
        assertThat(actual.getCurrentPosition().getY(), is(y));
        assertThat(actual.getFacing(), is(CardinalDirection.SOUTH));
    }

}