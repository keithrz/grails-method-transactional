package gmt

import gmt.domain.MyGrailsDomain
import gmt.domain.MyJpaDomain

class MyController {

    MethodScopeTxnService methodScopeTxnService
    TypeScopeTxnService typeScopeTxnService
    TypeScopeReadOnlyTxnService typeScopeReadOnlyTxnService

    def method() {
        if(params.writeMethodFirst) {
            methodScopeTxnService.emptyMethodWithTransaction()
        }
        saveAndRenderAllDomainInstances(methodScopeTxnService)
    }

    def type() {
        if(params.readMethodFirst) {
            typeScopeReadOnlyTxnService.emptyMethod()
        }
        saveAndRenderAllDomainInstances(typeScopeTxnService)
    }

    private saveAndRenderAllDomainInstances(txnService) {
        MyJpaDomain myJpaDomain = getInstanceAndSave(MyJpaDomain, 'myJpaProperty', txnService)
        MyGrailsDomain myGrailsDomain = getInstanceAndSave(MyGrailsDomain, 'myGrailsProperty', txnService)
        render(
            view: "index",
            model: [
                myJpaProperty: myJpaDomain.myProperty,
                myGrailsProperty: myGrailsDomain.myProperty
            ]
        )
    }

    private getInstanceAndSave(Class domainClass, String paramName, txnService) {
        def myDomain = txnService.getFirstDomain(domainClass)
        if(!myDomain) {
            myDomain = domainClass.newInstance()
            myDomain.myProperty = 1
            txnService.save(myDomain)
        }
        myDomain.myProperty = params.int(paramName) ?: myDomain.myProperty

        txnService.save(myDomain)

        myDomain
    }
}
