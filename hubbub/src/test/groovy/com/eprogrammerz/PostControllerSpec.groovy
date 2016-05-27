package com.eprogrammerz

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
@Mock([User,Post,LameSecurityInterceptor]) @Unroll
class PostControllerSpec extends Specification {

    def "Get a users timeline given their id"(){
        given:"User with posts in db"
        User yogen = new User(loginId: "yogen_rai", password: "ygnrai")
        yogen.addToPosts(new Post(content: "A first post"))
        yogen.addToPosts(new Post(content: "A second post"))
        yogen.save(faileOnError: true)

        and: "A loginId parameter"
        params.id = yogen.loginId

        when:"the timeline is invoked"
        def model = controller.timeline()

        then: "the user is in returned model"
        model.user.loginId == "yogen_rai"
        model.user.posts.size() == 2
    }

    def "Testing id of #suppliedId redirects to #expectedUrl"(){
        given: params.id = suppliedId

        when: "Controller is invoked"
        controller.home()

        then:
        response.redirectedUrl == expectedUrl

        where:
        suppliedId | expectedUrl
        'joe_cool' | '/post/timeline/joe_cool'
        null | '/post/timeline/chuck_norris'
    }

    def "adding a valid new post to the timeline"(){
        given:"a mock post service"
        def mockPostService = Mock(PostService)
        1*mockPostService.createPost(_,_) >> new Post(content: "Mock post")
        controller.postService = mockPostService

        when:"Controller is invoked"
        def result = controller.addPost("yogen_rai","Posting up a tsunami")

        then: "redirected to timeline, flash message tells us all is well"
        flash.message ==~ /Added new post: Mock.*/
        response.redirectedUrl == '/post/timeline/yogen_rai'
    }

    /*
    //this test should be done in interceptor test class
    def "Exercising security interceptor for unauthenticated user"(){
        when: "When a request is made to action addPost"
        withRequest(controller: 'post', action: "addPost")
        then: "the interceptor does match"
        interceptor.doesMatch()

    }*/

    def setup() {
    }

    def cleanup() {
    }
}
