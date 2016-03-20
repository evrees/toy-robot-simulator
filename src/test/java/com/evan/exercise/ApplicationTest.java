package com.evan.exercise;

import com.evan.exercise.exception.RobotSimulatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApplicationTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void main_shouldThrowException_whenArgsIsEmpty() {
        exception.expect(RobotSimulatorException.class);
        exception.expectMessage(Application.NO_FILE_PROVIDED);
        final String[] emptyArray = {};
        Application.main(emptyArray);
    }

}