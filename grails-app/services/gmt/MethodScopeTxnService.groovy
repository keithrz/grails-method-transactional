package gmt

import grails.transaction.Transactional
//import org.springframework.transaction.annotation.Transactional

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
}
