package com.eprogrammerz


class LameSecurityInterceptor {

    LameSecurityInterceptor(){
        println "In constructor"
        match controller: 'post', action: 'addPost'
    }
    boolean before() {
        println "before"
        if(params.impersonateId){
            session.user = User.findByLoginId(params.impersonateId)
        }
        if(!session.user){
            println "in before block"
            redirect(controller: 'login',action: 'form')
            return false
        }
    }

    boolean after() { true
    }

    void afterView() {
        log.debug("Finished running ${controllerName} - ${actionName}")
    }
}
