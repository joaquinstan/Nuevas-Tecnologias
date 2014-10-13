package turilla

class Activity {

	Establishment establishment
	String name
	String description
	Artist artist
	Date startDate
	Date endDate

    static constraints = {
    	establishment nullable: true
		description nullable: true
    	artist nullable: true
    	startDate nullable: true
    	endDate nullable: true
    }
}
