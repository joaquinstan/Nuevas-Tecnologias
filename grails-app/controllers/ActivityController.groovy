import turilla.*

class ActivityController {

	def index = {
		Activity activity = Activity.get(params.id)
		[activity: activity]		
	}
	
}
