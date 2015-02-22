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
}
