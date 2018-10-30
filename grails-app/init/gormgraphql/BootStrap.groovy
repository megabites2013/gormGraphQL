package gormgraphql

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        log.info "Populating database..."

        Speaker jeff = new Speaker('Jeff', 'Brown', LocalDate.of(1975, 11, 15), 'brownj@objectcomputing.com', 'Jeff Brown is an author and tech lead at OCI')
        Speaker graeme = new Speaker('Graeme', 'Rocher', LocalDate.of(1978, 1, 1), 'rocherg@objectcomputing.com', 'Graeme Rocher is the tech lead for the Grails project')
        Speaker zak = new Speaker('Zachary', 'Klein', LocalDate.of(1989, 2, 23), 'kleinz@objectcomputing.com')

        jeff.save()
        graeme.save()
        zak.save()

        new Talk('Testing with Grails 3', 90, jeff).save()
        new Talk('Polyglot Development with Grails 3', 90, jeff).save()
        new Talk('GORM Deep Dive', 120, graeme).save()
        new Talk("What's New in Grails 4", 60, graeme).save()
        new Talk('Grails in the Wonderful World of JavaScript Frameworks', 90, zak).save()

    }
    def destroy = {
    }
}
