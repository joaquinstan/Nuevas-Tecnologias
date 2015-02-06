import turilla.User
import org.apache.shiro.SecurityUtils


class ProfileController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		[currentUser : currentUser]
	}
	
	def updateUserData() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		currentUser.setInterestTags(params.interestTags);
		
		currentUser.save(flush: true);
		
		return render(view:"index", model: [currentUser : currentUser, msg:  message(code: 'profileUpdated', args:[])])
	}
}
