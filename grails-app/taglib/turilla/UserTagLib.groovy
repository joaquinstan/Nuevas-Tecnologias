package turilla
import org.apache.shiro.SecurityUtils

class UserTagLib {
    static defaultEncodeAs = [taglib:'html']
    def userName = { attrs, body ->
        out << SecurityUtils.subject.principal
    }

    def displayName = { attrs, body ->
        def username  = SecurityUtils.subject?.principal
        def user = User.findByUsername(username)
        out << user.name +" "+user.lastName

    }
}
