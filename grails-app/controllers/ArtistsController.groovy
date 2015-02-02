import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Artist

class ArtistsController {

    def index() { 
		[]
	}
	
	def addNewArtist() {
		if (params.alias == null || params.alias.equals("")) 
			return render(view:"index", model: [msg : message(code:"aliasObligatory", args:[])])
		
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : message(code:"nameObligatory", args:[])] )
		
		Artist artist = new Artist( alias: params.alias, name: params.name)
		artist.save()
		
		def map = [ msg : message(code:"artistCreated", args:[]) ]
		return render(view:"index", model:map)
	}
}
