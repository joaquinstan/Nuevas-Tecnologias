import turilla.*

class HomeController{
    def index() { 
		Activity[] activities = Activity.getAll()
		[activities: activities]
		
    }   
	
	def search(){
		def map = [ activities :  Activity.findAllByNameLike("jo%")]
		render(view:"index", model:map)
	}
}
