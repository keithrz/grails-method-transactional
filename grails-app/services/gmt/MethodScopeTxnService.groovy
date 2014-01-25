package gmt

import gmt.domain.MyDomain
//import grails.transaction.Transactional
import org.springframework.transaction.annotation.Transactional

class MethodScopeTxnService {
    @Transactional
    def saveMyDomain(MyDomain myDomain) {
        myDomain.save(failOnError: true)

//		// delete old promotion scopes
//		getChildren(myDomain).each {
//			it.delete()
//		}
//
//		// create new promotion scopes
//		childValues.each { value ->
//			def child = new MyChild(myDomain, value)
//			child.save()
//		}
    }

    @Transactional(readOnly = true)
    def getFirstDomain() {
        helperMethod()
        MyDomain.first()
    }

//	@Transactional(readOnly = true)
//	List<MyChild> getChildren(MyDomain myDomain) {
//		MyChild.findAllByMyDomain(myDomain)
//	}

    def helperMethod() {
        def purpose = "include a method with no annotation"
        purpose
    }
}
