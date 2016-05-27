package com.eprogrammerz

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PostService)
@Mock([Post,User])
class PostServiceSpec extends Specification {

    def "Valid posts get saved and adde to the user"(){
        given: "A new user in db"
        new User(loginId: 'yogen_rai',password: 'ygnrai').save(failOnError: true)

        when: "new post is created by service"
        def newPost =  service.createPost("yogen_rai","Awesome post!")

        then: "post returned and added to user"
        newPost.content == "Awesome post!"
        User.findByLoginId("yogen_rai").posts.size() == 1
    }

    def "Invalid posts generate exceptional outcomes"(){
        given: "A new user in the db"
        new User(loginId: "yogen_rai",password: "ygnrai")

        when: "an invalid post is attempted"
        def newPost = service.createPost("yogen_rai",null)

        then: "an exception is thrown and no post is saved"
        thrown(PostException)
    }

    def setup() {
    }

    def cleanup() {
    }
}
