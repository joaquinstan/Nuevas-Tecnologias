package turilla

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Establishment)
class EstablishmentSpec extends Specification {

    def setup() {
		return new Establishment(name:"Teatro Colon", address:"Cerca del Obelisco", latitude: -34.60104, longitude: -58.38307)
    }

    def cleanup() {
    }

    void "test correct distance"() {
		when:
			def est = setup()
			
			def distance = est.getDistanceTo(-34.78826, -58.27377)
		then:
		distance > 22.68 && distance < 23.68
    }
	
	void "test distance to establishment"() {
		when:
			def est = setup()
			def est2 = new Establishment(name:"Teatro Colon", address:"Cerca del Obelisco", latitude: -34.78826, longitude: -58.27377)
			def distance = est.getDistanceTo(est2)
		then:
		distance > 22.68 && distance < 23.68
	}
	
	void "test no distance, no latitude at establishment"() {
		when:
			def est = setup()
			est.latitude = null
			def distance = est.getDistanceTo(-34.78826, -58.27377)
		then:
		distance == null
	}
	
	void "test no distance, no longitude at establishment"() {
		when:
			def est = setup()
			est.longitude = null
			def distance = est.getDistanceTo(-34.78826, -58.27377)
		then:
		distance == null
	}
	
	void "test no distance, no latitude at parameters"() {
		when:
			def est = setup()
			def distance = est.getDistanceTo(null, -58.27377)
		then:
		distance == null
	}
	
	void "test no distance, no longitude at parameters"() {
		when:
			def est = setup()
			def distance = est.getDistanceTo(-34.78826, null)
		then:
		distance == null
	}
	
	void "test ETA with default speed"() {
		when:
			def est = setup()
			def ETA = est.getETA(-34.78826, -58.27377)
		then:
		ETA > 2.1 && ETA < 2.5
	}
	
	void "test ETA with custom speed"() {
		when:
			def est = setup()
			def ETA = est.getETA(-34.78826, -58.27377, 15)
		then:
		ETA > 1.3 && ETA < 1.7
	}
	
	void "test ETA with no speed"() {
		when:
			def est = setup()
			def ETA = est.getETA(-34.78826, -58.27377, null)
		then:
		ETA == null
	}
	
	void "test ETA with no latitude at establishment"() {
		when:
			def est = setup()
			est.latitude = null
			def ETA = est.getETA(-34.78826, -58.27377, null)
		then:
		ETA == null
	}
	
	void "test ETA with no longitude at establishment"() {
		when:
			def est = setup()
			est.longitude = null
			def ETA = est.getETA(-34.78826, -58.27377, null)
		then:
		ETA == null
	}
	
	void "test ETA with no latitude at parameters"() {
		when:
			def est = setup()
			def ETA = est.getETA(null, -58.27377, null)
		then:
		ETA == null
	}
	
	void "test ETA with no longitude at parameters"() {
		when:
			def est = setup()
			def ETA = est.getETA(-34.78826, null, null)
		then:
		ETA == null
	}
	
}
