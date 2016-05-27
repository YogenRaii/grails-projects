import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_hubbub_postglobal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/global.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textArea','g',25,['name':("content"),'id':("postContent"),'cols':("50"),'rows':("3")],-1)
printHtmlPart(10)
invokeTag('submitButton','g',26,['name':("post"),'value':("Post")],-1)
printHtmlPart(11)
})
invokeTag('form','g',26,['action':("addPost"),'id':(params.id)],2)
printHtmlPart(12)
invokeTag('render','g',30,['template':("postEntry"),'collection':(posts),'var':("post")],-1)
printHtmlPart(13)
invokeTag('paginate','g',33,['action':("global"),'total':(postCount),'max':("25")],-1)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',33,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1464014263717L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
