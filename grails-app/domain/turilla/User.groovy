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
    
    static hasMany = [ roles: Role, permissions: String, favorites: IArtist ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
