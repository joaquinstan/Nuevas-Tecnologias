import com.mysql.fabric.xmlrpc.base.Params;

import java.lang.ref.ReferenceQueue.Null;


import turilla.*

class SearchController {

    def index() {
        Activity[] activities = Activity.getAll()
        [activities: activities]
    }
	def search() {
		Date iniDate = new Date()
		Date finDate = null
		
		if(params.iniYear && params.iniMonth && params.iniDay) {
			Calendar c = new GregorianCalendar()
			
			if(params.iniHour && params.iniMinutes){
				c.set(Integer.parseInt(params.iniYear),Integer.parseInt(params.iniMonth), Integer.parseInt(params.iniDay), Integer.parseInt(params.iniHour), Integer.parseInt(params.iniMinutes))
			} else {
				c.set(Integer.parseInt(params.iniYear),Integer.parseInt(params.iniMonth), Integer.parseInt(params.iniDay), 0, 0)
			}
			iniDate = c.getTime()
		}
		
		if(params.finYear && params.finMonth && params.finDay ) {
			Calendar c = new GregorianCalendar()
			c.set(Integer.parseInt(params.finYear),Integer.parseInt(params.finMonth), Integer.parseInt(params.finDay), 0, 0)
			finDate = c.getTime()
		}
		
		def activities = Activity.createCriteria().listDistinct {
			
			ilike("name", "%${params.actName}%")
			
			artists{
				ilike("name", "%${params.artist}%")
			}
			artists{
				ilike("name", "%${params.group}%")
			}
			/*
			 * artists{
				ilike("name", "%${params.artist}%")
				like("class",ArtistGroup.class) //http://stackoverflow.com/questions/19771530/criteria-that-filters-by-subclass-of-filed-declared-by-super-class-in-domain-cla
				}
			 */
			/*ArtistGroup.createCriteria().listDistinct {
				ilike("name", "%${params.group}%")
				projections {
					properties("activities")
				}
			}*/
			establishment{
				ilike("name","%${params.establishment}%")
			}
			if(iniDate != null){
				ge("startDate", iniDate)
			}
			if(finDate != null){
				lt("endDate", finDate)
			}
			
		}
		def map = [ activities : activities ]
		render(view:"index", model:map)
		
	}
}
