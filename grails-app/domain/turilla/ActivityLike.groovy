package turilla

class ActivityLike {
	int likeValue;
	int dislikeValue;
	
	static belongsTo = [ user: User, activity: Activity ]
	
    static constraints = {
    }
}
