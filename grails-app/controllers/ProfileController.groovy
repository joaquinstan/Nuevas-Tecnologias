import turilla.Tag
import turilla.User
import org.apache.shiro.SecurityUtils


class ProfileController {

    def index() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)
		
		[currentUser : currentUser, tags: currentUser.getInterestTags() ]
	}

	def updateUserData() {
		User currentUser = User.findByUsername(SecurityUtils.subject.principal)

        def tags = [] as Set
        if(params.interestTags!=""){
            for (it in params.interestTags) {
                println("tag: "+it)
                if(it !=""){
                    if ( Tag.findByValor(it) ) {
                        println("el tag ya estaba creado")
                        tags.add(Tag.findByValor(it.toString()))
                        println(tags)
                    } else {
                        Tag nuevoTag = new Tag(valor: it.toString())
                        println("se ha creado un nuevo tag")
                        println(nuevoTag.valor)
                        nuevoTag.save()
                        tags.add(nuevoTag)
                    }
                }
            }
        }
        currentUser.interestTags+=tags
		currentUser.save(flush: true);
		
		return render(view:"index", model: [currentUser : currentUser, tags: currentUser.getInterestTags(), msg:  message(code: 'profileUpdated', args:[])])
	}
}
