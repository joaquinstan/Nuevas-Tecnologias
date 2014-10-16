package turilla

class Artist implements AbstractArtist{

	String alias
    String name
    String lastName
	int rating


	static hasMany = [ activities: Activity, favorites: AbstractArtist ]

	static constraints = {
		alias nullable: true
        rating: nullable: false
    }

    public def rate(){

    }
}
