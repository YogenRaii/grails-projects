package com.eprogrammerz

class LoginController {

    def form(String id){
        [loginId: id]
    }

    def signIn(String loginId, String password){
            def user = User.findByLoginId(loginId)
            if(user && user.password == password){
                session.user = user
                redirect(controller: "user", action: "profile",id:loginId)
            }else{
                flash.message = "Unknown username or password"
                redirect(action: "form")
            }
    }
}
