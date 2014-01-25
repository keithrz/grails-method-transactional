package gmt

//import grails.transaction.Transactional
//import org.springframework.transaction.annotation.Transactional

//@Transactional
class TypeScopeTxnService {
    static transactional = true

    def save(myDomain) {
        myDomain.save(failOnError: true)
    }

    def getFirstDomain(domainClass) {
        domainClass.first()
    }

}
