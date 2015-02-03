import com.mysql.fabric.xmlrpc.base.Params;
import org.apache.shiro.SecurityUtils
import turilla.Activity
import turilla.Establishment
import turilla.User

class ActivitiesController {

	def getBaseMap() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		def ownActivities = Activity.findAllByCreatorUser(currentUser);
		
		[ establishments : Establishment.getAll(), ownActivities : ownActivities ]
	}
	
    def index() { 
		getBaseMap()
	}
	
	def addNewActivity() {
		def map = getBaseMap()
		
		if (params.name == null || params.name.equals("")) {
			map['msg'] = message(code:"nameObligatory", args:[])
			return render(view:"index", model: map)
		}
		
		Activity activity
		if (params.id.equals("")) {
			User currentUser = User.findByUsername(SecurityUtils.subject.principal)
			 activity = new Activity( name: params.name, description: params.description, establishment : Establishment.get( params.establishment ), creatorUser: currentUser);
		} else {
			activity = Activity.get(params.id)
			activity.setName(params.name)
			activity.setDescription(params.description)
			activity.setEstablishment( Establishment.get(params.establishment) )
		}
		activity.save(flush: true)
		
		map = getBaseMap()	// To add the new artist
		
		String messageKey = params.id.equals("") ? "activityCreated" : "activityModified";
		map['msg'] = message(code: messageKey, args:[])
		return render(view:"index", model: map)
	}
	
	def modifyActivity() {
		def map = getBaseMap()
		
		Activity activity = Activity.get(params.id)
		map['activity'] = activity
		
		return render(view:"index", model : map)
	}
	
	def deleteActivity() {
		Activity activity = Activity.get(params.id)
		activity.delete(flush: true)
		
		def map = getBaseMap()
		map['msg'] = message(code:"activityDeleted", args:[])
		return render(view:"index", model : map)
	}
	
}
