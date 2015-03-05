import turilla.Tag
import turilla.User
import org.apache.shiro.SecurityUtils


class ProfileController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		[currentUser : currentUser, allTags: Tag.getAll(), userTags: currentUser.getInterestTags() ]
	}

	def updateUserData() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)

        if(params.interestTags!="") {
            currentUser.interestTags.clear()
            currentUser.interestTags.addAll( Tag.generateTags(params.list("interestTags")) )
            currentUser.save(flush: true);
        }

		return render(view:"index", model: [currentUser : currentUser, allTags: Tag.getAll(),userTags: currentUser.getInterestTags(), msg:  message(code: 'profileUpdated', args:[])])
	}
}
