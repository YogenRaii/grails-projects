package com.eprogrammerz


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserIntegrationSpec extends Specification {

    def "welcome email"(){
        given:"inbox"
        def userController = new UserController()
        when:" a welcome email is sent"
        userController.welcomeEmail("ygnrai@gmail.com")
        then:"appears in email"
    }
    /*def "Saving our first user to the database"(){
        given: "A brand new user"
        def joe = new User(loginId: 'joe',password: 'secret')
        when: "the user is saved"
        joe.save()

        then: "it saved successfully and can be found in db"
        joe.errors.errorCount == 0
        joe.id != null
        User.get(joe.id).loginId == joe.loginId
    }

    def "Updating a saved user changes its properties"(){
        given:"An existing user"
        def existingUser = new User(loginId: 'joe',password: 'secret')
        existingUser.save(failOnError:true)

        when: "A property is changed"
        def foundUser = User.get(existingUser.id)
        foundUser.password = 'yogenn'
        foundUser.save(failOnError: true)

        then: "The change is reflected in the database"
        User.get(existingUser.id).password == 'yogenn'
    }

    def "Deleting a saved user"(){
        given: "A saved user"
        def existingUser = new User(loginId: 'joe',password: 'secret')
        existingUser.save(failOnError: true)

        when: "User is deleted"
        def foundUser = User.get(existingUser.id)
        foundUser.delete(flush: true)

        then: "User is removed from db"
        !User.exists(foundUser.getId())
    }

    def "Saving our a user with invalid properties cause an error"(){
        given: "A brand new user with invalid properties"
        def user = new User(loginId: 'joe', password: 'tiny')
        when: "the user is validated"
        user.validate()

        then: "it errors associated with each properties is printed.."
        "size.toosmall" == user.errors.getFieldError("password").code
        "tiny" == user.errors.getFieldError("password").rejectedValue
    }
*/
    def setup() {
    }

    def cleanup() {
    }
}
