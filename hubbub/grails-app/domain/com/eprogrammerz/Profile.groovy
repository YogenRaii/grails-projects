package com.eprogrammerz

class Profile {
//    User user
    static belongsTo = [user: User]
    byte[] photo
    String fullName
    String bio
    String homepage
    String email
    String timezone
    String country
    String jabberAddress

    String skin

    static constraints = {
        fullName blank: false
        bio nullable: true, maxSize: 1000
        homepage url: true, nullable: true
        email email: true, blank: false
        photo nullable: true, maxSize: 2 * 1024 * 1024
        country nullable: true
        timezone nullable: true
        jabberAddress email: true, nullable: true
        skin(nullable: true,blank: true,inList: ['blues','nighttime'])
    }

    String toString(){
        return "Profile of $fullName (id: $id)"
    }

    String getDisplayString(){ return fullName }
}
