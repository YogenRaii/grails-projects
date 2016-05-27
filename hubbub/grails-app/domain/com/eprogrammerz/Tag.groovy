package com.eprogrammerz

class Tag {
    String name
    User user

    static constraints = {
        name blank: false
    }

    static hasMany = [posts: Post]
    static belongsTo = [User, Post]

    String toString(){
        return "Tag - ${name}"
    }
}
