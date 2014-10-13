import turilla.*

class ActivityController {

	def index = {
		Activity activity = Activity.getAll().get(0)
		[activity: activity]		
	}
	
}
