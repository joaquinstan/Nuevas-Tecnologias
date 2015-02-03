package turilla

class Artist extends IArtist{

	String alias
    String name
	int rating
	User creatorUser
	
	static hasMany = [ activities: Activity ]
	
	static constraints = {
		alias nullable: true
		creatorUser nullable: true
        rating: nullable: false
    }

    public def rate(){

    }
}
