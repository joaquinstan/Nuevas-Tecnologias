package turilla

class Artist extends IArtist{

	String alias
    String name
	int rating

	static hasMany = [ activities: Activity ]

	static constraints = {
		alias nullable: true
        rating: nullable: false
    }

    public def rate(){

    }
}
