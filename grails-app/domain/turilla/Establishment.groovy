package turilla

class Establishment {

	String name
	String address
	User owner

    static constraints = {
    	owner nullable: true, unique: true
    }
}
