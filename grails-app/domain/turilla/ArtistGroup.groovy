package turilla

class ArtistGroup implements AbstractArtist{

	String name
	static hasMany = [ artists: Artist, activities: Activity ]

    static constraints = {
    }

    public def rate(){

    }
}
