package com.evan.exercise.transformer;

import com.evan.exercise.domain.Position;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.evan.exercise.test.util.RandomUtil.randomInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringListToPositionTransformerTest {

    private final StringListToPositionTransformer SUBJECT = new StringListToPositionTransformer();

    @Test
    public void process_shouldReturnAPosition_withCorrectXAndYPoints() {
        final String place = "PLACE";
        final String x = String.valueOf(randomInt());
        final String y = String.valueOf(randomInt());
        final String facing = "NORTH";

        final List<String> placeCommandParts = Stream.of(place, x, y, facing).collect(Collectors.toList());

        final Position actual = SUBJECT.process(placeCommandParts);
        assertThat(String.valueOf(actual.getX()), is(x));
        assertThat(String.valueOf(actual.getY()), is(y));
    }


}