import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject
import turilla.*

class ActivityController {
	
	def index = {
		Activity activity = Activity.get(params.id)
		String currentUser = SecurityUtils.subject.principal
		
		[activity: activity, currentUser: currentUser ]		
	}
	
	def updateLike = {
		String currentUsername = SecurityUtils.subject.principal
		User user = User.findByUsername(currentUsername)
		Activity activity = Activity.get(params.id)
		ActivityLike currentLike = activity.getUserLike(currentUsername);
		
		if (currentLike == null) {
			def like = new ActivityLike(likeState: params.likeState)
			user.addToLikes(like)
			activity.addToLikes(like)
			
			like.save()
		} else {
			currentLike.setLikeState(params.int("likeState"))
			
			currentLike.save(flush: true)
		}
	}
	
}
