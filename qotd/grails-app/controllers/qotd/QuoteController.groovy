package qotd

class QuoteController {

    static scaffold = Quote

    def quoteService
//    def index() { }
    static defaultAction = "random"

    def random(){
        def randomQuote = quoteService.getRandomQuote()
        [quote: randomQuote]
    }

    def ajaxRandom(){
        def randomQuote = quoteService.getRandomQuote()
        [quote: randomQuote]
        /*render {
            q(randomQuote.content)
            p(randomQuote.author)
        }*/
    }

}
