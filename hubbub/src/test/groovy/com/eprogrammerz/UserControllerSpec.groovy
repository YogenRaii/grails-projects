package com.eprogrammerz

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User, Profile])
class UserControllerSpec extends Specification {

    @Unroll
    def "Registration command object for #loginId validate correctly"() {

        given: "a mocked command object"
        def urc = mockCommandObject(UserRegistrationCommand)

        and: "a set of initial values from the spock test"
        urc.loginId = loginId
        urc.password = password
        urc.passwordRepeat = passwordRepeat
        urc.fullName = "Your Name Here"
        urc.email = "someone@nowhere.net"

        when: "the validator is invoked"
        def isValidRegistration = urc.validate()

        then: "the appropriate fields are flagged as errors"
        isValidRegistration == anticipatedValid
        urc.errors.getFieldError(fieldInError)?.code == errorCode

        where:
        loginId  | password   | passwordRepeat| anticipatedValid   | fieldInError       | errorCode
        "glen"  | "password" | "no-match"   | false               | "passwordRepeat"   | "validator.invalid"
        "peter" | "password" | "password"   | true                | null               | null
        "a"     | "password" | "password"   | false               | "loginId"           | "size.toosmall"

    }

    def "Invoking the new register action via a command object"(){
        given:"A configured command object"
        def urc = mockCommandObject(UserRegistrationCommand)
        urc.with {
            loginId = "yogen_rai"
            fullName = "Yogen Rai"
            email = "ygnrai@gmail.com"
            password= "ygnrai"
            passwordRepeat = "ygnrai"
        }

        and: "which has been validated"
        urc.validate()

        when:"the register action is invoked"
        controller.register2(urc)

        then:"the user is registered and browser redirected"
        !urc.hasErrors()
        response.redirectedUrl == '/'
        User.count() == 1
        Profile.count() == 1
    }



    def setup() {
    }

    def cleanup() {
    }
}
