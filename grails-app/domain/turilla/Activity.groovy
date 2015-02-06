package turilla

class Activity {

	Establishment establishment
	String name
	String description
	String tags
	Date startDate
	Date endDate
	User creatorUser
	byte[] image
	String imageType
	
    static hasMany = [ artists: IArtist, comments: Comment, likes: ActivityLike ]

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
}
