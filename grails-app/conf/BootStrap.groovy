import java.lang.invoke.LambdaForm.Name;

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

        def art1 = new Artist(name: "John Williams")
        art1.save()

        def art2 = new Artist(name: "Juan Gabriel")
        art2.save()
		
		def grupo_los_charchaleros = new ArtistGroup(name: "los charchaleros", artists:[art1,art2])
		grupo_los_charchaleros.save()
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015,12,1, 0, 0)
		def fechaDeFinAct1 = cal.getTime()
		
		cal = Calendar.getInstance();
		cal.set(2015,6,1, 0, 0)
		def fechaDeInicioFutura = cal.getTime()
		
        def act1 = new Activity(name:"John Williams en el Teatro Colon!", description:"Descripcion de john wiliams en el teatro color", startDate: fechaDeInicioFutura,endDate: fechaDeFinAct1, artists: [art1], establishment: est1)
        act1.save()

        def act2 = new Activity(name:"Juan Gabriel en el Teatro Opera!", description:"Descripcion de Juan Gabriel en el Teatro Opera", startDate: fechaDeInicioFutura, artists:[art2], establishment: est2)
        act2.save()
		
		def act3 = new Activity(name:"los charchaleros en vivo!", description:"Descripcion de el evento los chalchaleros", artists:[grupo_los_charchaleros], startDate: fechaDeInicioFutura, endDate: fechaDeFinAct1 ,establishment: est2) 
		act3.save()
		
		/*def actLike1 = new ActivityLike(likeState: ActivityLike.LIKE_VALUE)
		fq.addToLikes(actLike1);
		act1.addToLikes(actLike1);*/
    }
    def destroy = {
    }
}
