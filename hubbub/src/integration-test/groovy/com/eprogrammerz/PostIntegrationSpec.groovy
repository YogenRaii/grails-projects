package com.eprogrammerz


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class PostIntegrationSpec extends Specification {

    def "Adding post to user"(){
        given: "New user"
        def user = new User(loginId: 'joe', password: 'seceret')
        user.save(failOnError: true)

        when: "When several posts are added by user"
        user.addToPosts(new Post(content: "Post 1"))
        user.addToPosts(new Post(content: "Post 2"))
        user.addToPosts(new Post(content: "Post 3"))

        then: "user has list of posts"
        3 == User.get(user.id).posts.size()
    }

    /*def "Ensure post for user can be retrieved"(){
        given: "user and posts"
        def user = new User(loginId: 'joe', password: 'secret')
        user.addToPosts(new Post(content:  "First"))
        user.addToPosts(new Post(content:  "Third"))
        user.addToPosts(new Post(content:  "Second"))
        user.save(failOnError: true)

        when: "user is retrieved by id"
        def foundUser = User.get(user.id)
        def sortedPosts = foundUser.posts.collect {
            it.content
        }.sort()
        then:"Post appears in alphabetical order"
        sortedPosts == ['First','Second','Third']
    }

    def "Taggin posts with tags"(){
        given: "A user with tags"
        def user = new User(loginId: 'yogen', password: 'secret')
        def tagGroovy = new Tag(name: 'groovy')
        def tagGrails = new Tag(name: 'grails')
        user.addToTags(tagGroovy)
        user.addToTags(tagGrails)
        user.save(failOnError: true)

        when: "A user tags two fresh posts"
        def groovyPost = new Post(content: 'A groovy post')
        user.addToPosts(groovyPost)
        groovyPost.addToTags(tagGroovy)

        def bothPost = new Post(content: 'A groovy and grails post')
        user.addToPosts(bothPost)
        bothPost.addToTags(tagGroovy)
        bothPost.addToTags(tagGrails)

        then:
        user.tags*.name.sort() == ['grails','groovy']
        1 == groovyPost.tags.size()
        2 == bothPost.tags.size()
    }
*/
    def setup() {
    }

    def cleanup() {
    }
}
