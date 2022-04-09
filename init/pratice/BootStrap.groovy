package pratice

class BootStrap {

    def init = { servletContext ->
        new Practice.Member(version: 20,name: "Dai", address:"Ktm").save()
        new Practice.Member(version: 21,name: "Didi", address:"Lalitpur").save()
    }
    def destroy = {
    }
}
