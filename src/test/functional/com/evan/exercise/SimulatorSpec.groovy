package com.evan.exercise

import com.evan.exercise.domain.Robot
import com.evan.exercise.domain.enums.CardinalDirection
import spock.lang.Specification
import spock.lang.Unroll

class SimulatorSpec extends Specification {

    final Simulator SUBJECT = new Simulator()

    def 'process should not create a CommandAdapter when Place Command is not present'() {
        given:
        def commands = commandsWithoutPlacement();

        when:
        SUBJECT.process(commands);

        then:
        assert SUBJECT.commandAdapter.isPresent() == false;
    }


    @Unroll('Position: #expectedX, #expectedY. Facing: #expectedFacing')
    def 'process should create a completed CommandAdapter with Robot when commands are valid'() {
        when:
        SUBJECT.process(commands);

        then:
        Robot actual = SUBJECT.commandAdapter.get().robot
        assert actual.currentPosition.getX() == expectedX;
        assert actual.currentPosition.getY() == expectedY;
        assert actual.facing == expectedFacing;

        where:
        commands                    | expectedX | expectedY | expectedFacing
        basicCommandList()          | 1         | 1         | CardinalDirection.EAST
        complexCommandList()        | 3         | 2         | CardinalDirection.SOUTH
        testMaxBoundaryCommands()   | 4         | 4         | CardinalDirection.EAST
        testMinBoundaryCommands()   | 0         | 0         | CardinalDirection.SOUTH
        firstPlacementOverwritten() | 4         | 4         | CardinalDirection.WEST;
    }

    def commandsWithoutPlacement() {
        return ['MOVE',
                'RIGHT',
                'MOVE',
                'REPORT']
    }

    def basicCommandList() {
        return ['PLACE 0,0,NORTH',
                'MOVE',
                'RIGHT',
                'MOVE',
                'REPORT']
    }

    def complexCommandList() {
        return ['PLACE 1,2,EAST',
                'MOVE',
                'MOVE',
                'LEFT',
                'MOVE',
                'RIGHT',
                'RIGHT',
                'MOVE',
                'REPORT']
    }

    def testMaxBoundaryCommands() {
        return ['PLACE 4,4,NORTH',
                'MOVE',
                'RIGHT',
                'MOVE',
                'REPORT']
    }

    def testMinBoundaryCommands() {
        return ['PLACE 0,0,WEST',
                'MOVE',
                'LEFT',
                'MOVE',
                'REPORT']
    }

    def firstPlacementOverwritten() {
        return ['PLACE 0,0,EAST',
                'MOVE',
                'PLACE 4,4,WEST',
                'REPORT']
    }
}
