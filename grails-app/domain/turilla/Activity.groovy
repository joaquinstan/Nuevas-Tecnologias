package turilla

class Activity {

	Establishment establishment
	String name
	String description
	Date startDate
	Date endDate
	User creatorUser
	byte[] image
	String imageType
	Integer maxCapacity;
	Integer currentAttendants = 0;
	
    static hasMany = [ tags: Tag, artists: IArtist, comments: Comment, likes: ActivityLike ]

    static belongsTo = IArtist

    static constraints = {
    	establishment nullable: true
		description nullable: true
		tags nullable: true
    	startDate nullable: true
    	endDate nullable: true
    	imageType nullable: true
    	image nullable: true, maxSize: 1024 * 1024 * 10
		creatorUser nullable: true
		maxCapacity nullable: true
    }
	
	def getUserLike(String userName) {
		for ( like in likes ) {
			if (like.getUser().getUsername().equals(userName))
				return like;
		}
		
		return null;
	}
	
	def getUserLikeState(String username) {
		ActivityLike like = getUserLike(username)
		
		if (like == null) 
			return 0
		
		return like.getLikeState()
	}
	
	def addAttendant() {
		currentAttendants++
	}
	
	def addAttendant(Integer quantity) {
		currentAttendants = currentAttendants + quantity
	}
	
	def reachMaxCapacity() {
		if (maxCapacity != null)
			return (currentAttendants >= maxCapacity)
		
		// If no capacity was setted then it can never reach maxCapacity
		return false
	}
	
	/*def hasAnyTag(List<String> tagsToFind) {
		if (tags == null || tagsToFind == null)
			return false;
			
		for (String tag in tagsToFind)
			if (tags.find(tag) != null) 
				return true
		
		return false
	}
	
	def hasTag(String tag) {
		if (tags == null || tag == null)
			return false;
			
		return (tags.find(tag) != null)
	}*/
}
