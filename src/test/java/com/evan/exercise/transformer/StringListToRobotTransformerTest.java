package com.evan.exercise.transformer;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.enums.CardinalDirection;
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

public class StringListToRobotTransformerTest {

    private StringListToPositionTransformer stringListToPositionTransformer;
    private StringListToRobotTransformer SUBJECT;

    @Before
    public void setUp() {
        stringListToPositionTransformer = Mockito.mock(StringListToPositionTransformer.class);
        SUBJECT = new StringListToRobotTransformer(stringListToPositionTransformer);
    }

    @Test
    public void createRobot_shouldReturnARobot() {
        final String place = "PLACE";
        final int x = randomInt();
        final int y = randomInt();
        final String facing = "NORTH";
        final String placeCommand = String.format("%s,%s,%s,%s", place, x, y, facing);
        final List<String> placeCommandParts = Stream.of(placeCommand.split(",")).collect(Collectors.toList());

        when(stringListToPositionTransformer.process(placeCommandParts))
                .thenReturn(new Position()
                        .setX(x)
                        .setY(y));

        final MovableRobot actual = SUBJECT.createRobot(placeCommandParts);

        assertThat(actual.getCurrentPosition().getX(), is(x));
        assertThat(actual.getCurrentPosition().getY(), is(y));
        assertThat(actual.getFacing(), is(CardinalDirection.NORTH));
    }
}