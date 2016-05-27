package com.eprogrammerz

class UserController {

    static scaffold = User

    static navigation = [
            [group: 'tabs', action: 'search', order: 90],
            [action: 'advSearch', title: 'Advanced Search', order: 95],
            [action: 'register', order: 99, isVisible: { true }]
    ]

    def search() {}

    def results(String loginId) {

        def users = User.where {
            loginId =~ "%${loginId}%"
        }.list()
        return [users     : users,
                term      : params.loginId,
                totalUsers: User.count()]
    }

    def advSearch() {}

    def advResults() {
        def profileProps = Profile.metaClass.properties*.name
        def profiles = Profile.withCriteria {
            "${params.queryType}" {
                params.each {
                    field, value ->
                        if (profileProps.contains(field) && value) {
                            ilike field, "%${value}%"
                        }
                }
            }
        }
        return [profiles: profiles]
    }

    def register() {
        if (request.method == "POST") {
            def user = new User(params)
            if (user.validate()) {
                user.save()
                flash.message = "Successfully Created User"
                redirect(uri: '/')
            } else {
                flash.message = "Error Registering User"
                return [user: user]
            }
        }
    }

    def register2(UserRegistrationCommand urc) {
        if (urc.hasErrors()) {
            render(view: "register", model: [user: urc])
        } else {
            def user = new User(urc.properties)
            user.profile = new Profile(urc.properties)

            if (user.validate() && user.save()) {
                welcomeEmail(urc.email)
                flash.message = "Welcome aboard, ${urc.fullName ?: urc.loginId}"
                redirect(uri: "/")
            } else {
                return [user: urc]
            }
        }
    }

    def profile(String id) {
        def user = User.findByLoginId(id)
        if (user) {
            return [profile: user.profile]
        } else {
            response.sendError(404)
        }
    }

    def mailService

    def welcomeEmail(String email) {
        if (email) {
            mailService.sendMail {
                from "Hubbub@gmail.com"
                to email
                subject "Welcome to our site!"
                html view:"/user/welcomeEmail",model: [email: email]
            }
            flash.message = "Welcome aboard"
        }
        redirect(uri: "/")
    }
}


class UserRegistrationCommand implements grails.validation.Validateable {
    String loginId
    String password
    String passwordRepeat
    byte[] photo
    String fullName
    String bio
    String homepage
    String email
    String timezone
    String country
    String jabberAddress

    static constraints = {
        importFrom(Profile)
        importFrom(User)
        password(size: 6..8, blank: false,
                validator: { passwd, urc ->
                    return passwd != urc.loginId
                })
        passwordRepeat(nullable: false,
                validator: { passwd2, urc ->
                    return passwd2 == urc.password
                })
    }
}
