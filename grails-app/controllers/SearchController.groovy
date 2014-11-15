import com.mysql.fabric.xmlrpc.base.Params;

import java.lang.ref.ReferenceQueue.Null;


import turilla.*

class SearchController {

    def index() {
        Activity[] activities = Activity.getAll()
        [activities: activities]
    }
	def search() {
		Date iniDate = null
		Date finDate = null
		if(params.iniYear && params.iniMonth && params.iniDay) {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(params.iniYear),Integer.parseInt( params.iniMonth), Integer.parseInt(params.iniDay), 0, 0)
			iniDate=c.getTime()
		}
		if(params.finYear && params.finMonth && params.finDay ) {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(params.finYear),Integer.parseInt( params.finMonth), Integer.parseInt(params.finDay), 0, 0)
			finDate=c.getTime()			
		}
		
		def activities = Activity.createCriteria().listDistinct {
			
			ilike("name", "%${params.actName}%")
			
			artists{
				ilike("name", "%${params.artist}%")
			}
			/*ArtistGroup.createCriteria().listDistinct {
				ilike("name", "%${params.group}%")
				projections {
					properties("activities")
				}
			}*/
			establishment{
				ilike("name","%${params.establishment}%")
			}
			if(iniDate!=null){
				ge("startDate", iniDate)
			}
			if(finDate!=null){
				lt("endDate", finDate)
			}
			
		}
		def map = [ activities : activities ]
		render(view:"index", model:map)
		
	}
}
