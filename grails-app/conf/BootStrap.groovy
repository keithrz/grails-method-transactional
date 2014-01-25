import gmt.domain.MyDomain
import gmt.TypeScopeTxnService

class BootStrap {

    TypeScopeTxnService typeScopeTxnService

    def init = { servletContext ->
//
//        MyDomain myDomain = new MyDomain()
//        myDomain.myProperty = 1
//
//        typeScopeTxnService.saveMyDomain(myDomain, true)
    }
    def destroy = {
    }
}
