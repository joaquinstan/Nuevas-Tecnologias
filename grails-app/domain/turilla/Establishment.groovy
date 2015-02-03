package turilla

class Establishment {

	String name
	String address
	User owner
	User creatorUser
	
    static constraints = {
    	owner nullable: true, unique: true
		creatorUser nullable: true
    }
}
