package gmt

import gmt.domain.MyDomain

class MyController {

    MethodScopeTxnService methodScopeTxnService
    TypeScopeTxnService typeScopeTxnService

    private getMyDomain() {
        MyDomain myDomain = methodScopeTxnService.firstDomain
        if(!myDomain) {
            myDomain = new MyDomain(myProperty: 1)
            typeScopeTxnService.saveMyDomain(myDomain)
        }
        myDomain
    }

    def method() {
        MyDomain myDomain = getMyDomain()
        myDomain.myProperty = params.int('myProperty') ?: myDomain.myProperty

        methodScopeTxnService.saveMyDomain(myDomain)

//        MyDomain.withNewSession {
//            myDomain = methodScopeTxnService.firstDomain
////            myDomain.refresh()
//        }
        render(view: "index", model: [myProperty: myDomain.myProperty])
    }

    def type() {
        MyDomain myDomain = getMyDomain()
        myDomain.myProperty = params.int('myProperty') ?: myDomain.myProperty

        typeScopeTxnService.saveMyDomain(myDomain)

//        MyDomain.withNewSession {
//            myDomain = methodScopeTxnService.firstDomain
////            myDomain.refresh()
//        }
        render(view: "index", model: [myProperty: myDomain.myProperty])
    }
}
