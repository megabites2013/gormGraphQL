package gormgraphql

import grails.rest.Resource

@Resource(uri='/talk')
class Talk {

    String title
    int duration

    static graphql = true

    static belongsTo = [speaker: Speaker]

    Talk( String title, int duration,speaker) {
        this.speaker = speaker
        this.title = title
        this.duration = duration
    }
}