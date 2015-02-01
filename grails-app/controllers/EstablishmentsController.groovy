import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Artist
import turilla.Establishment

class EstablishmentsController {

    def index() { 
		[]
	}
	
	def addNewEstablishment() {
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : "El nombre es obligatorio."])
		
		if (params.address == null || params.address.equals("")) 
			return render(view:"index", model: [msg : "La dirección es obligatorio."] )
		
		Establishment establishment = new Establishment( name: params.name, address: params.address)
		establishment.save()
		
		def map = [ msg : "Establecimiento creado! :D" ]
		return render(view:"index", model:map)
	}
}
