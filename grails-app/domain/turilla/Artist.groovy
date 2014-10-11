package turilla

class Artist {

	String alias
	int rating

	static hasMany = [ activities: Activity ]

	static constraints = {
		alias nullable: true
    }
}
