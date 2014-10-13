import turilla.*

class HomeController{

    def index() { 
    	Activity[] activities = Activity.getAll()
    	[activities: activities]
    }   

}
