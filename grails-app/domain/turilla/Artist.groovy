package turilla

class Artist {

	String alias
    String name
    String lastName
	int rating

	static hasMany = [ activities: Activity ]

	static constraints = {
		alias nullable: true
        rating: nullable: false
    }
}
