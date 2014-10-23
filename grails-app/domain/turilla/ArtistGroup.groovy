package turilla

class ArtistGroup extends IArtist{

	String name
	static hasMany = [ artists: Artist, activities: Activity ]

    static constraints = {
    }

    public def rate(){

    }
}
