package com.evan.exercise.validator
import com.evan.exercise.exception.RobotSimulatorException
import spock.lang.Specification
import spock.lang.Unroll

import static com.evan.exercise.exception.RobotSimulatorException.*

class PlaceCommandValidatorSpec extends Specification {

    final PlaceCommandValidator SUBJECT = new PlaceCommandValidator()

    def "Place command with incorrect number of elements throws exception"() {
        given:
        List<String> placeCommandParts = ["PLACE", '1', '2', 'NORTH', 'Extra Arg']

        when:
        SUBJECT.validate(placeCommandParts)

        then:
        RobotSimulatorException exception = thrown()

        and:
        assert exception.getMessage() == INVALID_PLACE_COMMAND
    }

    @Unroll
    def "Place command with x #xPoint, y #yPoint, facing #facing throws exception with message #expectedExceptionMessage"() {
        given:
        List<String> placeCommandParts = ["PLACE", xPoint, yPoint, facing]

        when:
        SUBJECT.validate(placeCommandParts)

        then:
        RobotSimulatorException exception = thrown()

        and:
        assert exception.getMessage() == expectedExceptionMessage

        where:
        xPoint | yPoint | facing    | expectedExceptionMessage
        'ONE'  | '2'    | 'NORTH'   | INVALID_X
        '1'    | 'TWO'  | 'NORTH'   | INVALID_Y
        '5'    | '2'    | 'NORTH'   | INVALID_X
        '-1'   | '2'    | 'NORTH'   | INVALID_X
        '1'    | '5'    | 'NORTH'   | INVALID_Y
        '1'    | '-1'   | 'NORTH'   | INVALID_Y
        '1'    | '2'    | 'UP'      | INVALID_FACING
    }
}
