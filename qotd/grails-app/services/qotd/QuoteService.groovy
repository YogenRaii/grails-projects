package qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def getStaticQuote() {
            return new Quote(author: 'Yogen',content: 'Welcome to Grails...')
    }

    def getRandomQuote(){
        def allQuotes = Quote.listOrderById()
        def randomQuote
        if(allQuotes.size() > 0){
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        }else {
            randomQuote = getStaticQuote()
        }
        return randomQuote
    }
}
