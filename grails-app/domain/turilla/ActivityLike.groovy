package turilla

class ActivityLike {
	
	private static int LIKE_VALUE = 1;
	private static int DISLIKE_VALUE = -1;
	
	int likeState;
	
	static belongsTo = [ user: User, activity: Activity ]
	
    static constraints = {
    }
}
