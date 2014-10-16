package turilla

class User {
    String name
    String lastName
    String username
    String passwordHash
    
    static hasMany = [ roles: Role, permissions: String, artists: Artist ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
