package hubbub

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/timeline"{
            controller="post"
            action="personal"
        }

        "/users/${id}"{
            controller="post"
            action="timeline"
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
