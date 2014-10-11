package turilla

class Plan {

	String name
	static hasMany = [ activities: Activity ]

    static constraints = {
    }
}
