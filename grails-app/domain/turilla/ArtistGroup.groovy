package turilla

class ArtistGroup {


	String name
	String lastName
	static hasMany = [ artists: Artist, activities: Activity ]

    static constraints = {
    }
}
