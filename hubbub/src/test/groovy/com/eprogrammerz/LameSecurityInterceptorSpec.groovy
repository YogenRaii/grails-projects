package com.eprogrammerz


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LameSecurityInterceptor)
class LameSecurityInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test lameSecurity interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"lameSecurity")

        then:"The interceptor does match"
            !interceptor.doesMatch()
    }

    def "Exercising security interceptor for unauthenticated user"(){
        when: "When a request is made to action addPost"
        withRequest(controller: 'post', action: "addPost")
        then: "the interceptor does match"
        interceptor.doesMatch()

    }
}
