import org.apache.shiro.crypto.hash.Sha256Hash
import turilla.*

class BootStrap {

    def init = { servletContext ->
        def js = new ShiroUser(username: "joaquinstankus", passwordHash: new Sha256Hash("password").toHex())
        js.addToPermissions("*:*")
        js.save()

        def fq = new ShiroUser(username: "federicoquevedo", passwordHash: new Sha256Hash("password").toHex())
        fq.addToPermissions("*:*")
        fq.save()

        def jc = new ShiroUser(username: "jorgecollinet", passwordHash: new Sha256Hash("password").toHex())
        jc.addToPermissions("*:*")
        jc.save()

        def est1 = new Establishment(name:"Teatro Colon", address:"Cerca del Obelisco")
        est1.save()

        def art1 = new Artist(name: "John",lastName: "Williams")
        art1.save()

        def act1 = new Activity(name:"John Williams en el Teatro Colon!",startDate: new Date(), artist: art1, establishment: est1)
        act1.save()

    }
    def destroy = {
    }
}
