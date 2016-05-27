package com.eprogrammerz

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(DateTagLib)
class DateTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Conversion of #testName matches #expectNiceDate()"(){
        expect:
        applyTemplate('<hub:dateFromNow date="${date}" />',[date: testDate]) == expectedNiceDate

        where:
        testName | testDate | expectedNiceDate
        "Current time" | new Date() | "Right now"
        "Now -1 day" | new Date().minus(1) | "1 day ago"
        "Now -2 days " | new Date().minus(2) | "2 days ago"
    }
}
