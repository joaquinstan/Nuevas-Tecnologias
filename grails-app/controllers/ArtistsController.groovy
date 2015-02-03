import com.mysql.fabric.xmlrpc.base.Params;
import org.apache.shiro.SecurityUtils
import turilla.Artist
import turilla.User

class ArtistsController {
	
	def getBaseMap() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		def ownArtists = Artist.findAllByCreatorUser(currentUser);
		
		[ ownArtists : ownArtists ]
	}
	
    def index() {
		getBaseMap()
	}
	
	def addNewArtist() {
		def map = getBaseMap()
		
		if (params.alias == null || params.alias.equals("")) {
			map['msg'] = message(code:"aliasObligatory", args:[])
			return render(view:"index", model: map)
		}
		
		if (params.name == null || params.name.equals("")) {
			map['msg'] = message(code:"nameObligatory", args:[])
			return render(view:"index", model: map )
		}
		
		Artist artist
		if (params.id.equals("")) {
			User currentUser = User.findByUsername(SecurityUtils.subject.principal)
			artist = new Artist( alias: params.alias, name: params.name, creatorUser: currentUser)
		} else {
			artist = Artist.get(params.id)
			artist.setAlias(params.alias);
			artist.setName(params.name);
		}
		artist.save(flush: true)
		
		map = getBaseMap()	// To add new artist
		
		String messageKey = params.id.equals("") ? "artistCreated" : "artistModified";
		map['msg'] = message(code: messageKey, args:[])
		return render(view:"index", model : map)
	}
	
	def modifyArtist() {
		def map = getBaseMap()
		
		Artist artist = Artist.get(params.id)
		map['artist'] = artist
		
		return render(view:"index", model : map)
	}
	
	def deleteArtist() {
		Artist artist = Artist.get(params.id)
		artist.delete(flush: true)
		
		def map = getBaseMap()
		return render(view:"index", model : map)
	}
}
