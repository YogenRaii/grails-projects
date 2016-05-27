package com.eprogrammerz

class PostController {

    static scaffold = Post

    static defaultAction = "home"

    def postService

    static navigation = [
            [group:'tabs',action: 'personal', title: 'My Timeline', order: 0],
            [action: 'global', title: 'Global Timeline', order: 1]
    ]

    def home(){
        if(!params.id){
            params.id = "chuck_norris"
        }
        redirect(action: 'timeline',params: params)
    }

    def timeline(){
        def user = User.findByLoginId(params.id);
        if(!user){
            response.sendError(404)
        }
        [user: user]
    }

    def personal(){
        if(!session.user){
            redirect(controller: "login",action: "form")
            return
        }
        render view: "timeline",model: [user: session.user.refresh()]
    }

    def global(){
        [posts: Post.list(params), postCount: Post.count()]
    }

    def addPostAjax(String content){
        try {
            def newPost = postService.createPost(session.user.loginId, content)
            def recentPosts = Post.findAllByUser(session.user,[sort: 'dateCreated', order: 'desc',max:20])
            render template: 'postEntry',collection: recentPosts, var: 'post'
        }catch (PostException pe){
            render {
                div(class:'errors',pe.message)
            }
        }
    }

    def addPost(String id, String content){
        try {
            def newPost = postService.createPost(id,content)
            flash.message = "Added new post: ${newPost.content}"
        }catch (PostException pe){
            flash.message = pe.message
        }
        redirect(action: 'timeline',id: id)
    }

    def tinyUrl(String fullUrl){
        def origUrl = fullUrl?.encodeAsURL();
        def tinyUrl = new URL("http://tinyurl.com/api-create.php?url=${origUrl}").text
        render(contentType: 'application/json'){
            urls(small: tinyUrl, full: fullUrl)
        }
    }

}
