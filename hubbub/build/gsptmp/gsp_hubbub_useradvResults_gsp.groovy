import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_useradvResults_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/advResults.gsp" }
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
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(term)
printHtmlPart(6)
expressionOut.print(profiles.size())
printHtmlPart(7)
for( profile in (profiles) ) {
printHtmlPart(8)
createTagBody(3, {->
expressionOut.print(profile.fullName)
})
invokeTag('link','g',23,['controller':("profile"),'action':("show"),'id':(profile.id)],3)
printHtmlPart(9)
}
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',23,['action':("advSearch")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',23,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463685792426L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
