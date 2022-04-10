package pratice

import grails.gorm.transactions.ReadOnly

@ReadOnly
class MemberController {

    MemberService memberService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Member.list(params), model:[memberCount: Member.count()]
    }

    def create(){
        Member member = new Member()
        member.version = 10
        member.name = "Suprina"
        member.address = "Lalitpur"
        memberService.create(member)
          render("Created")
        redirect action:"index", method:"GET"
         // [member: flash.redirectParams]
    }

    def getData() {
        def list = Member.list()
        [list: list]
      if (!response) {
            redirect(controller: "home", action: "index")
        } else {
            [member: response]
        }
    }

    def update() {
        def member = Member.get(params.id)
        // update properties in the employee
        member.name = params.name
        member.address = params.address
        member.save()
        memberService.update(member,params)
        render("Updated")
        redirect action:"index", method:"GET"
    }

    def delete(Long id){
        memberService.delete(id)
        render("Deleted")
        redirect action:"index", method:"GET"
    }
}