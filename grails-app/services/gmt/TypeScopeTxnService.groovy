package gmt

import gmt.domain.MyDomain
//import grails.transaction.Transactional
//import org.springframework.transaction.annotation.Transactional

//@Transactional
class TypeScopeTxnService {
	static transactional = true

	def saveMyDomain(MyDomain myDomain) {
		myDomain.save(failOnError: true)
	}
}
