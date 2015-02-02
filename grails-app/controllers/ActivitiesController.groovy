import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Activity
import turilla.Establishment

class ActivitiesController {

    def index() { 
		[ establishments : Establishment.getAll() ]
	}
	
	def addNewActivity() {
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : "El nombre es obligatorio.", establishments : Establishment.getAll() ])
		
		Activity activity = new Activity( name: params.name, description: params.description, establishment : Establishment.get( params.establishment ));
		activity.save()
		
		def map = [ msg : "Actividad creada! :D", establishments : Establishment.getAll() ]
		return render(view:"index", model: map)
	}
}
