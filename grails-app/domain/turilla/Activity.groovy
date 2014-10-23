package turilla

class Activity {

	Establishment establishment
	String name
	String description
	Date startDate
	Date endDate

    static hasMany = [ artists: IArtist, comments: Comment ]

    static belongsTo = IArtist

    static constraints = {
    	establishment nullable: true
		description nullable: true
    	startDate nullable: true
    	endDate nullable: true
    }
}
