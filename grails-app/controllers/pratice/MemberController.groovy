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
          memberService.update()
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
        memberService.delete()
        render("Deleted")
    }
}