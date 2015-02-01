import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Artist

class ArtistsController {

    def index() { 
		[]
	}
	
	def addNewArtist() {
		if (params.alias == null || params.alias.equals("")) 
			return render(view:"index", model: [msg : "El nombre de pila es obligatorio."])
		
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : "El nombre es obligatorio."] )
		
		Artist artist = new Artist( alias: params.alias, name: params.name)
		artist.save()
		
		def map = [ msg : "Artista creado! :D" ]
		return render(view:"index", model:map)
	}
}
