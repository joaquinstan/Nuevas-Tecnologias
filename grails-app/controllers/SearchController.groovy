import com.mysql.fabric.xmlrpc.base.Params;

import java.lang.ref.ReferenceQueue.Null;


import turilla.*

class SearchController {

    def index() {
        [activities: Activity.getAll(), allArtists: IArtist.getAll(), establishments: Establishment.getAll()]
    }

	def search() {

		def activities = Activity.createCriteria().listDistinct {

			ilike("name", "%${params.actName}%")

			if(params.artists != ""){
                artists{
                    idEq(params.artists.toLong())
                }
            }

            if(params.establishment != ""){
                establishment{
                    ilike("name","%${params.establishment}%")
                }
            }

			if(params.fromDate != null){
				ge("startDate", params.fromDate)
			}

            if( params.untilDateCheckBox!=null && params.untilDate != null){
                lt("endDate", params.untilDate)
            }
		}
        def map = [activities : activities, allArtists: IArtist.getAll(), establishments: Establishment.getAll()]
		render(view:"index", model:map)
	}
}
