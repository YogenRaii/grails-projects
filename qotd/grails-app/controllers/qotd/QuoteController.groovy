package qotd

class QuoteController {

    static scaffold = Quote

    def quoteService
//    def index() { }
    static defaultAction = "random"

    def random(){
//        def staticAuthor ="Anonymous"
//        def staticContent = "Real Programmers do not eat Quiche"
//        [author:staticAuthor,content:staticContent]

        def randomQuote = quoteService.getRandomQuote()
        [quote: randomQuote]
    }

    def ajaxRandom(){
        def randomQuote = quoteService.getRandomQuote()
        render {
            q(randomQuote.content)
            p(randomQuote.author)
        }
    }

}
