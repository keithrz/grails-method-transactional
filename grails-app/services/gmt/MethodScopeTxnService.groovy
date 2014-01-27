package gmt

import grails.transaction.Transactional
//import org.springframework.transaction.annotation.Transactional
import gmt.domain.*

class MethodScopeTxnService {

    @Transactional
    def save(myDomain) {
        myDomain.save(failOnError: true)
    }

    @Transactional(readOnly = true)
    def getFirstDomain(domainClass) {
        helperMethod()
        domainClass.first()
    }

    def helperMethod() {
        def purpose = "include a method with no annotation"
        purpose
    }

    @Transactional
    def emptyMethodWithTransaction() {
        def purpose = "test calling this method before the readOnly method"
        //this method needs to retrieve the instance used in save
        // in order for the save to persist
        // if it does not retrieve the instance, the instance will be retrieved
        // when MyController calls getFirstDomain(), which has a read-only transaction
        MyJpaDomain.all
        // commenting/uncommenting the following lines do not make any difference
        // when calling save() from MyController
        //MyJpaDomain.findByMyProperty(100)
        //MyOtherJpaDomain.all
        //MyGrailsDomain.all
        purpose
    }
}
