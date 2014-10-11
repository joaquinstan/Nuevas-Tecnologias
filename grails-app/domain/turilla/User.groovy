package turilla

class User {
	
	String name
	String lastName
	Preferences preferences
	Artist artist

    static constraints = {
    	preferences nullable: true, unique: true
    	artist nullable: true, unique: true
    }
}
