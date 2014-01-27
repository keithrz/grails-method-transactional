package gmt

import grails.transaction.Transactional
//import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class TypeScopeReadOnlyTxnService {
    def emptyMethod() {
    }
}
