package com.evan.exercise.validator

import spock.lang.Specification
import spock.lang.Unroll

class PointValidatorSpec extends Specification {

    PointValidator SUBJECT = new PointValidator();

    @Unroll()
    def 'isPointWithinTableBounds should return #result when input is #input'() {
        when:
        boolean actual = SUBJECT.isPointWithinTableBounds(input)

        then:
        assert actual == result

        where:
        input   | result
        -1      | false
        5       | false
        0       | true
        4       | true

    }
}
