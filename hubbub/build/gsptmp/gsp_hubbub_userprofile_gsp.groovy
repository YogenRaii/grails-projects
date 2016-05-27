import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_userprofile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/profile.gsp" }
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
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (profile.photo)) {
printHtmlPart(6)
expressionOut.print(createLink(controller: 'image', action: 'renderImage', id: profile.user.loginId))
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(profile.fullName)
printHtmlPart(9)
expressionOut.print(profile.bio)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',20,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463784573845L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
