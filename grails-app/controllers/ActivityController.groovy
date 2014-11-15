import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject
import turilla.*

class ActivityController {
	
	def index = {
		Activity activity = Activity.get(params.id)
		String currentUser = SecurityUtils.subject.principal
		
		[activity: activity, currentUser: currentUser ]		
	}
	
}
