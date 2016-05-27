import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_useradvSearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/advSearch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('textField','g',20,['name':("fullName")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("email")],-1)
printHtmlPart(8)
invokeTag('textField','g',28,['name':("homepage")],-1)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(it.radio)
printHtmlPart(11)
expressionOut.print(it.label)
printHtmlPart(12)
})
invokeTag('radioGroup','g',34,['name':("queryType"),'labels':(['And','Or','Not']),'values':(['and','or','not']),'value':("and")],3)
printHtmlPart(13)
invokeTag('submitButton','g',42,['name':("search"),'value':("Search")],-1)
printHtmlPart(14)
})
invokeTag('form','g',44,['action':("advResults")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',44,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463685427494L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
