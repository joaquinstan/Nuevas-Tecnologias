import org.apache.shiro.crypto.hash.Sha256Hash
import turilla.*

class BootStrap {

    def init = { servletContext ->
        def js = new User(name:"Joaquin",lastName:"Stankus",username: "joaquinstankus", passwordHash: new Sha256Hash("password").toHex())
        js.addToPermissions("*:*")
        js.save()

        def fq = new User(name:"Fede",lastName:"Champion", username: "federicoquevedo", passwordHash: new Sha256Hash("password").toHex())
        fq.addToPermissions("*:*")
        fq.save()

        def jc = new User(name:"Jorge",lastName:"Collinet",username: "jorgecollinet", passwordHash: new Sha256Hash("password").toHex())
        jc.addToPermissions("*:*")
        jc.save()

        def est1 = new Establishment(name:"Teatro Colon", address:"Cerca del Obelisco")
        est1.save()

        def est2 = new Establishment(name:"Teatro Opera", address:"Masomeno cerca del obelisco")
        est2.save()

        def art1 = new Artist(name: "John",lastName: "Williams")
        art1.save()

        def art2 = new Artist(name: "Juan",lastName: "Gabriel")
        art2.save()


        def act1 = new Activity(name:"John Williams en el Teatro Colon!",startDate: new Date(), artist: art1, establishment: est1)
        act1.save()

        def act2= new Activity(name:"Juan Gabriel en el Teatro Opera!", startDate: new Date(), artist:art2, establishment: est2)
        act2.save()

    }
    def destroy = {
    }
}
