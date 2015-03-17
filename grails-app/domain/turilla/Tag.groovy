package turilla

/**
 * Created by jorge on 20/02/15.
 */
class Tag {
    String valor

    static hasMany = [activities: Activity]
    static belongsTo = Activity

    static constraints = {
        valor nullable: false
    }
    static generateTags(valuesOfTags) {
            valuesOfTags.findAll{it != ""}.collect{ valueOfTag ->
                Tag.findByValor(valueOfTag)?:new Tag(valor: valueOfTag).save(failOnError: true)
            }
        }

        /*TODO: eliminar esto antes de la entrega*/
        /*
        def tags = []
        for (stringTag in list) {
            if(stringTag !=""){
                if ( Tag.findByValor(stringTag) ) {
                    tags.add(Tag.findByValor(stringTag.toString()))
                } else {
                    Tag nuevoTag = new Tag(valor: stringTag.toString())
                    nuevoTag.save()
                    tags.add(nuevoTag)
                }
            }
        }
        return tags
         */


}

