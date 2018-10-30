package gormgraphql

import grails.rest.Resource
import org.grails.gorm.graphql.entity.dsl.GraphQLMapping
import java.time.LocalDate
import java.time.Period

@Resource(uri='/speaker')
class Speaker {

    String firstName
    String lastName
    String name
    String email
    String bio
    LocalDate birthday

    static hasMany = [talks: Talk]

    //this is customizing schema
    static graphql = GraphQLMapping.build {

        property 'lastName', order: 1
        property 'firstName', order: 2
        property 'email', order: 3

        exclude 'birthday'

        property 'name', deprecationReason: 'To be removed Dec 1st, 2018'

        property('bio') {
            order 4
            dataFetcher { Speaker speaker ->
                speaker.bio ?: "No biography provided"
            }
        }

        add('age', Integer) {
            dataFetcher { Speaker speaker ->
                Period.between(speaker.birthday, LocalDate.now()).years
            }
            input false
        }
    }

    static constraints = {
        email nullable: true, email: true
        bio nullable: true
    }

    static mapping = {
        bio type: 'text'
        name formula: 'concat(FIRST_NAME,\' \',LAST_NAME)'
        talks sort: 'id'
    }

    Speaker(String firstName, String lastName, LocalDate birthday,String email, String bio ) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.bio = bio
        this.birthday = birthday
    }
    Speaker(String firstName, String lastName, LocalDate birthday,String email  ) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
         this.birthday = birthday
    }
}
