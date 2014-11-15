import org.hibernate.criterion.Distinct;

import turilla.*

class HomeController{
    def index() { 
		Activity[] activities = Activity.getAll()
		[ activities: activities ]
		
    }   
	
	def search = {
		
		def activities = Activity.createCriteria().listDistinct {
			or{
				ilike("name", "%${params.busquedaIntroducida}%")
				
				artists{
					ilike("name", "%${params.busquedaIntroducida}%")
				}
				
				establishment{
					ilike("name","%${params.busquedaIntroducida}%")
				}
				
				ilike("description", "%${params.busquedaIntroducida}%")
			}
		}
		def map = [ activities : activities ]
		render(view:"index", model:map)
		
		
		/*TODO: Lo dejo como historial de referencia, borrar despues antes de entrega
		ArrayList<Activity>activities =  Activity.findAllByNameLike("${params.busquedaIntroducida}%")
		ArrayList<Activity>activitiesFromDesc =  Activity.findAllByDescriptionLike("%${params.busquedaIntroducida}%")
		if(activitiesFromDesc != null){
			 activities.addAll(activitiesFromDesc)
		}
		activities.
		//allActivities+=Activity.findByEstablishment(params.busquedaIntroducida)
		//allActivities+=Activity.findByStartDateGreaterThanAndEndDateLessThanEquals(params.busquedaIntroducida)
		def map = [ activities : activities ]
		render(view:"index", model:map)
		*/
	}
}
