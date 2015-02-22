import turilla.Activity
import turilla.User
import org.apache.shiro.SecurityUtils


class SuggestedActivitiesController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
        def activities = Activity.createCriteria().listDistinct {
            tags{
                or{
                    it in currentUser.interestTags
                }
            }
        }
		return [ activities: activities ]
	}


}
