package com.eprogrammerz

class UtilTagLib {
//    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "hub"

    def tinyThumbnail = {
        attrs ->
            def loginId = attrs.loginId
            out<< "<img src='"
            out<<g.createLink(action: "tinyl",controller: "image", id: loginId)
            out<<"' alt='${loginId}'"
    }

    def certainBrowser = {
        attr, body ->
            if (request.getHeader('User-Agent') =~ attr.userAgent) {
                out << body
            }
    }
}
