import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_posttimeline_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/timeline.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(3)
expressionOut.print(user.profile ? user.profile.fullName : user.loginId)
printHtmlPart(2)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',14,['library':("jquery"),'src':("jquery-2.2.0.min.js")],-1)
printHtmlPart(4)
if(true && (user.profile?.skin)) {
printHtmlPart(3)
invokeTag('stylesheet','asset',17,['src':("${user.profile.skin}.css")],-1)
printHtmlPart(2)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',37,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',38,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(user.profile ? user.profile.fullName : user.loginId)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(user.profile.fullName)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('textArea','g',54,['name':("content"),'id':("postContent"),'cols':("50"),'rows':("3")],-1)
printHtmlPart(14)
invokeTag('submitToRemote','g',62,['name':("post"),'value':("Post"),'url':([controller: 'post', action: 'addPostAjax']),'update':("allPosts"),'onSuccess':("clearPost(data)"),'onLoading':("showSpinner(true)"),'onComplete':("showSpinner(false)")],-1)
printHtmlPart(15)
invokeTag('image','asset',65,['src':("spinner.gif"),'style':("display: none;")],-1)
printHtmlPart(3)
})
invokeTag('form','g',66,[:],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('textField','g',68,['name':("fullUrl")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',70,['name':("submit"),'value':("Make Tiny")],-1)
printHtmlPart(3)
})
invokeTag('formRemote','g',71,['name':("tinyUrlForm"),'url':([action: 'tinyUrl']),'onSuccess':("addTinyUrl(data)")],2)
printHtmlPart(18)
invokeTag('render','g',86,['template':("postEntry"),'collection':(user.posts),'var':("post")],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1464210868156L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
