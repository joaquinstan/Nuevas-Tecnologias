import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Activity
import turilla.Establishment

class ActivitiesController {

    def index() { 
		[ establishments : Establishment.getAll() ]
	}
	
	def addNewActivity() {
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : message(code:"nameObligatory", args:[]), establishments : Establishment.getAll() ])
		
		Activity activity = new Activity( name: params.name, description: params.description, establishment : Establishment.get( params.establishment ));
		activity.save()
		
		def map = [ msg : message(code:"activityCreated", args:[]), establishments : Establishment.getAll() ]
		return render(view:"index", model: map)
	}
}
