import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_loginform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/form.gsp" }
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
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('textField','g',26,['name':("loginId"),'value':(user?.loginId)],-1)
printHtmlPart(10)
invokeTag('passwordField','g',31,['name':("password"),'value':(user?.password)],-1)
printHtmlPart(11)
invokeTag('submitButton','g',36,['name':("signin"),'value':("Sign In")],-1)
printHtmlPart(12)
})
invokeTag('form','g',37,['action':("signIn")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',37,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463797543192L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
