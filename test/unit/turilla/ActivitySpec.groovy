package turilla

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activity)
class ActivitySpec extends Specification {

    def setup() {
		def art1 = new Artist(name: "John Williams")
		def est1 = new Establishment(name:"Teatro Colon", address:"Cerca del Obelisco")
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015,12,1, 0, 0)
		def fechaDeFinAct1 = cal.getTime()
		
		cal = Calendar.getInstance();
		cal.set(2015,6,1, 0, 0)
		def fechaDeInicioFutura = cal.getTime()
		
		return new Activity(name:"John Williams en el Teatro Colon!", description:"Descripcion de john wiliams en el teatro color", startDate: fechaDeInicioFutura,endDate: fechaDeFinAct1, artists: [art1], establishment: est1)
    }

    def cleanup() {
    }

    void "test 0 attendants"() {
		when:
			def act1 = setup()
			
		then:
			act1.currentAttendants == 0
    }
	
	void "test 1 attendant"() {
		when:
			def act1 = setup()
			act1.addAttendant()
			
		then:
			act1.currentAttendants == 1
	}
	
	void "test reach MaxCapacity with 0 attendants"() {
		when:
			def act1 = setup()
			
		then:
			act1.reachMaxCapacity() == false
	}
	
	void "test reach MaxCapacity with 1 attendants"() {
		when:
			def act1 = setup()
			act1.addAttendant()
			
		then:
			act1.reachMaxCapacity() == false
	}
	
	void "test reach MaxCapacity with 0 attendants and 2 capacity"() {
		when:
			def act1 = setup()
			act1.maxCapacity = 2
			
		then:
			act1.reachMaxCapacity() == false
	}
	
	void "test reach MaxCapacity with 1 attendants and 2 capacity"() {
		when:
			def act1 = setup()
			act1.maxCapacity = 2
			act1.addAttendant()
			
		then:
			act1.reachMaxCapacity() == false
	}
	
	void "test reach MaxCapacity with 2 attendants and 2 capacity"() {
		when:
			def act1 = setup()
			act1.maxCapacity = 2
			act1.addAttendant()
			act1.addAttendant()
			
		then:
			act1.reachMaxCapacity() == true
	}
	
	void "test reach add 2 attendants"() {
		when:
			def act1 = setup()
			act1.addAttendant(2)
			
		then:
			act1.currentAttendants == 2
	}
}
