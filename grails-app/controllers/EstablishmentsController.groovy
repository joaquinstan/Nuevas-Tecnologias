import com.mysql.fabric.xmlrpc.base.Params;
import org.apache.shiro.SecurityUtils
import turilla.Establishment
import turilla.User

class EstablishmentsController {

	def getBaseMap() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		def ownEstablishments = Establishment.findAllByCreatorUser(currentUser);
		
		[ ownEstablishments : ownEstablishments ]
	}
	
    def index() { 
		getBaseMap()
	}
	
	def addNewEstablishment() {
		def map = getBaseMap()
		
		if (params.name == null || params.name.equals("")) {
			map['msg'] = message(code:"nameObligatory", args:[])
			return render(view:"index", model: map)
		}
		
		if (params.address == null || params.address.equals("")) {
			map['msg'] = message(code:"addressObligatory", args:[])
			return render(view:"index", model: map )
		}
		
		if (params.latitude == null || params.longitude == null) {
			map['msg'] = message(code:"mapAddressObligatory", args:[])
			return render(view:"index", model: map )
		}
		
		Establishment establishment
		if (params.id.equals("")) {
			User currentUser = User.findByUsername(SecurityUtils.subject.principal)
			establishment = new Establishment( name: params.name, address: params.address, latitude:params.latitude, longitude:params.longitude,creatorUser: currentUser)
		} else {
			establishment = Establishment.get(params.id)
			establishment.setName(params.name)
			establishment.setAddress(params.address);
		}
		establishment.save(flush: true)
		
		map = getBaseMap()	// To add the new establishment
		
		String messageKey = params.id.equals("") ? "establishmentCreated" : "establishmentModified";
		map['msg'] = message(code: messageKey, args:[])
		return render(view:"index", model : map)
	}
	
	def modifyEstablishment() {
		def map = getBaseMap()
		
		Establishment establishment = Establishment.get(params.id)
		map['establishment'] = establishment
		
		return render(view:"index", model : map)
	}
	
	def deleteEstablishment() {
		Establishment establishment = Establishment.get(params.id)
		establishment.delete(flush: true)
		
		def map = getBaseMap()
		map['msg'] = message(code:"establishmentDeleted", args:[])
		return render(view:"index", model : map)
	}
}
