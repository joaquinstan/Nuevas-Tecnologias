package turilla

class Establishment {

	String name
	String address
	Double latitude
	Double longitude
	User owner
	User creatorUser
	
    static constraints = {
    	owner nullable: true, unique: true
		latitude nullable: true
		longitude nullable: true
		creatorUser nullable: true
    }
	
	final AVERAGE_SPEED = 10	// km/h
	
	// Returns distance in kilometers
	def getDistanceTo(Double otherLatitude, Double otherLongitude) {
		if (latitude == null || longitude == null)
			return null
			
		if (otherLatitude == null || otherLongitude == null)
			return null
			
			Double theDistance = (Math.sin(Math.toRadians(latitude)) *
				Math.sin(Math.toRadians(otherLatitude)) +
				Math.cos(Math.toRadians(latitude)) *
				Math.cos(Math.toRadians(otherLatitude)) *
				Math.cos(Math.toRadians(longitude - otherLongitude)));
			
			return new Double((Math.toDegrees(Math.acos(theDistance))) * 69.09 * 1.6093 ).intValue();
	}
	
	def getDistanceTo(Establishment establishment) {
		return getDistanceTo(establishment.latitude, establishment.longitude)
	}
	
	def getETA(Double otherLatitude, Double otherLongitude, Double speed) {
		def distance = getDistanceTo(otherLatitude, otherLongitude)
		
		if (distance == null || speed == null)
			return null
			
		return distance/speed
	}
	
	def getETA(Double otherLatitude, Double otherLongitude) {
		return getETA(otherLatitude, otherLongitude, AVERAGE_SPEED)
	}
}
