import qotd.Quote

class BootStrap {

    def init = { servletContext ->

        def q1 = new Quote(author: "Pratima Rai", content: "Life is not about never falling, it is about rising every time you fall!")
        def q2 = new Quote(author: "Dr. Sesus", content: "Don't cry because it's over, smile because it happened.")
        def q3 = new Quote(author: "Marilyn Monroe", content: "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.")
        def q4 = new Quote(author: "Oscar Wilde", content: "Be yourself; everyone else is already taken.")
        def quotes = [q1, q2, q3, q4]
        Quote.saveAll(quotes)
    }
    def destroy = {
    }
}
