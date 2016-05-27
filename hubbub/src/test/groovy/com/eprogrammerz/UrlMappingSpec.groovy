package com.eprogrammerz

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import hubbub.UrlMappings
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UrlMappings)
@Mock(PostController)
class UrlMappingSpec extends Specification {

    def "Ensure basic mapping operations fro user permalink"(){
        expect:
        assertForwardUrlMapping(url, controller: expectCtrl, action: expectAction){
            id = expectId
        }

        where:
        url | expectCtrl| expectAction | expectId
        '/users/glen' | 'post' | 'timeline' | 'glen'
//        '/timeline/chuck_norris'| 'post' | 'timeline' | 'chuck_norris'
    }

    def setup() {
    }

    def cleanup() {
    }
}
