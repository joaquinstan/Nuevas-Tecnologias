package turilla

class User {
    String name
    String lastName
    String username
    String passwordHash

    def favArtist(IArtist artist){

    }
    def attendActivity(Activity activity){

    }
    def rateActivity(Activity activity){

    }
    def commentActivity(Activity activity){

    }
    
    static hasMany = [ interestTags: Tag, roles: Role, permissions: String, favorites: IArtist, likes: ActivityLike ]

    static constraints = {
		interestTags nullable: true
        username(nullable: false, blank: false, unique: true)
    }
}
