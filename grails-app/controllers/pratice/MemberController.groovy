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
        memberService.update()
        render("Updated")
    }

    def delete(){
        memberService.delete(1)
        render("Deleted")
    }
}