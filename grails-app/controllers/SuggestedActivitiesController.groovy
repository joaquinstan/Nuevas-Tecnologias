import turilla.Activity
import turilla.User
import org.apache.shiro.SecurityUtils


class SuggestedActivitiesController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		if (currentUser.getInterestTags() != null) {
			List<String> tags = currentUser.getInterestTags().split(" ")
			
			Activity[] activities = Activity.createCriteria().listDistinct {
				or{
					for (tag in tags) {
						ilike("tags", "%${tag}%")
					}
				}
			}
			
			return [ activities: activities ]
		}
		
		[]
	}
}
