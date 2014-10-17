package turilla

class ArtistGroup implements IArtist{

	String name
	static hasMany = [ artists: Artist, activities: Activity ]

    static constraints = {
    }

    public def rate(){

    }
}
