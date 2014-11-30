package turilla

class Activity {

	Establishment establishment
	String name
	String description
	Date startDate
	Date endDate

    static hasMany = [ artists: IArtist, comments: Comment, likes: ActivityLike ]

    static belongsTo = IArtist

    static constraints = {
    	establishment nullable: true
		description nullable: true
    	startDate nullable: true
    	endDate nullable: true
    }
	
	def getUserLike(String userName) {
		for ( like in likes ) {
			if (like.getUser().getUsername().equals(userName))
				return like.getLikeState();
		}
		
		return 0;
	}
}
