import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_userregister_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/register.gsp" }
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
createTagBody(2, {->
printHtmlPart(6)
invokeTag('renderErrors','g',16,['bean':(user),'as':("list")],-1)
printHtmlPart(7)
})
invokeTag('hasErrors','g',18,[:],2)
printHtmlPart(0)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(0)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('textField','g',30,['name':("loginId"),'value':(user?.loginId)],-1)
printHtmlPart(11)
invokeTag('passwordField','g',35,['name':("password")],-1)
printHtmlPart(12)
invokeTag('passwordField','g',40,['name':("passwordRepeat")],-1)
printHtmlPart(13)
invokeTag('textField','g',45,['name':("fullName"),'value':(user?.fullName)],-1)
printHtmlPart(14)
invokeTag('textArea','g',50,['name':("bio"),'value':(user?.bio)],-1)
printHtmlPart(15)
invokeTag('textField','g',55,['name':("email"),'value':(user?.email)],-1)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
invokeTag('message','g',58,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',59,['bean':(user),'field':("email")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',59,['bean':(user),'field':("email")],3)
printHtmlPart(20)
invokeTag('countrySelect','g',67,['name':("country"),'noSelection':(['':'Choose your country...'])],-1)
printHtmlPart(21)
invokeTag('timeZoneSelect','g',71,['name':("timezone")],-1)
printHtmlPart(22)
invokeTag('select','g',83,['name':("referrer"),'from':(com.eprogrammerz.Profile.list()),'optionKey':("id"),'optionValue':("fullName"),'noSelection':(['null':'Please Choose...'])],-1)
printHtmlPart(23)
invokeTag('checkBox','g',87,['name':("spamMe"),'checked':("true")],-1)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(it.label)
printHtmlPart(25)
expressionOut.print(it.radio)
printHtmlPart(16)
})
invokeTag('radioGroup','g',96,['name':("emailFormat"),'labels':(['Plain','HTML']),'values':(['P', 'H']),'value':("H")],3)
printHtmlPart(26)
invokeTag('submitButton','g',101,['name':("register"),'value':("Register")],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',104,['controller':("post")],3)
printHtmlPart(29)
})
invokeTag('uploadForm','g',104,['action':("register2")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',105,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463952437065L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
