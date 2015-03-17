import turilla.Activity
import turilla.User
import org.apache.shiro.SecurityUtils


class SuggestedActivitiesController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
        if(currentUser.interestTags.isEmpty()) {
            return [ activities: [] ]
        }

        def activities = Activity.createCriteria().listDistinct {
            println(currentUser.interestTags)
            tags{
                'in' ("id", currentUser.interestTags.getAt("id"))
            }
        }

        println(activities)
		return [ activities: activities ]
	}


}
