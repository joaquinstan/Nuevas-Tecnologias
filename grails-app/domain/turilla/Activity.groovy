package turilla

class Activity {

	Establishment establishment
	String name
	Artist artist
	Date startDate
	Date endDate

    static constraints = {
    	establishment nullable: true
    	artist nullable: true
    	startDate nullable: true
    	endDate nullable: true
    }
}
