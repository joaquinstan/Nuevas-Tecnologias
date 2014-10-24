import turilla.*

class SearchController {

    def index() {
        Activity[] activities = Activity.getAll()
        [activities: activities]
    }
}
