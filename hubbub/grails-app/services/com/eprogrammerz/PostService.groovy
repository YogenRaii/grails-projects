package com.eprogrammerz

import grails.transaction.Transactional

class PostException extends RuntimeException{
    String message
    Post post
}

@Transactional
class PostService {

    Post createPost(String loginId,String content) {
        def user = User.findByLoginId(loginId)
        if(user){
            def post = new Post(content: content)
            user.addToPosts(post)
            if(post.validate() && user.save()){
                return post
            }else {
                throw new PostException(message: "Invalid or Empty post",post: post)
            }
        }else {
            throw new PostException(message: "Invalid User Id")
        }
    }
}
