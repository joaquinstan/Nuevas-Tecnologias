import com.mysql.fabric.xmlrpc.base.Params;
import turilla.Artist
import turilla.Establishment

class EstablishmentsController {

    def index() { 
		[]
	}
	
	def addNewEstablishment() {
		if (params.name == null || params.name.equals("")) 
			return render(view:"index", model: [msg : message(code:"nameObligatory", args:[])])
		
		if (params.address == null || params.address.equals("")) 
			return render(view:"index", model: [msg : message(code:"addressObligatory", args:[])] )
		
		Establishment establishment = new Establishment( name: params.name, address: params.address)
		establishment.save()
		
		def map = [ msg : message(code:"establishmentCreated", args:[]) ]
		return render(view:"index", model:map)
	}
}
