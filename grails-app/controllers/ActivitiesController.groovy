import com.mysql.fabric.xmlrpc.base.Params;
import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.apache.shiro.SecurityUtils
import turilla.Activity
import turilla.Establishment
import turilla.Tag
import turilla.User
import turilla.IArtist

class ActivitiesController {

	def getBaseMap() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		def ownActivities = Activity.findAllByCreatorUser(currentUser);
		
		[ tags: Tag.getAll(), artists: IArtist.getAll() ,establishments : Establishment.getAll(), ownActivities : ownActivities ]
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
		CommonsMultipartFile file = request.getFile("photo")

		Activity activity
        def tags = []
        if(params.tags!=""){
            tags = Tag.generateTags(params.list("tags"))
        }

		if (params.id.equals("")) {
			User currentUser = User.findByUsername(SecurityUtils.subject.principal)
			 activity = new Activity( artists: params.artists, name: params.name, description: params.description,
                     tags: tags, establishment : Establishment.get( params.establishment ), creatorUser: currentUser,
                     image: file?.bytes, imageType: file?.contentType,startDate:params.fromDate, endDate: params.untilDate);
		} else {
			activity = Activity.get(params.id)
			activity.setArtists(params.artists)
			activity.setName(params.name)
			activity.setDescription(params.description)
			activity.setTags(tags)
			activity.setEstablishment( Establishment.get(params.establishment) )
			activity.setImage(file?.bytes)
			activity.setImageType(file?.contentType)
            activity.setEndDate(params.untilDate)
            activity.setStartDate(params.fromDate)
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
