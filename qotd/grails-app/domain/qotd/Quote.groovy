package qotd

class Quote {
    String author
    String content
    Date date = new Date()

    static constraints = {
        author(blank: false)
        content(maxSize: 1000,blank: false)
    }
}
