package pratice

import grails.gorm.transactions.ReadOnly

@ReadOnly
class MemberController {

    MemberService memberService

    def index() {

        def response = memberService.getData()
        [memberList: response]
     /*   def response = memberService.getData()
       // [memberList: response.list, total:response.count]*/
    }

    def create(){
        Member member = new Member()
        member.version = 10
        member.name = "Suprina"
        member.address = "Lalitpur"
        memberService.create(member)
       /* render("Created")*/
        [member: flash.redirectParams]
        //redirect action:"index", method:"GET"
    }
/*    def getData() {
        def list = Member.list()
        [list: list]
*//*      if (!response) {
            redirect(controller: "home", action: "index")
        } else {
            [member: response]
        }*//*
    }*/

    def update(params) {
        def member = Member.get(params.id)
        // update properties in the employee
        member.name = "Suprina"
        member.save()
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