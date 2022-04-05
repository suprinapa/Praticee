package pratice

import grails.gorm.transactions.ReadOnly
import groovy.sql.Sql

@ReadOnly
class MemberController {

    def create(params){
        def member = MemberService.newInstance()
        member.create(params)
        render("Created")
    }
    def getAllData(){
        // Creating a connection to the database
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/myapp', 'root',
                'root', 'com.mysql.jdbc.Driver')

        sql.eachRow("SELECT * FROM member") { rs ->
            assert(rs.id)
            assert(rs.version)
            assert(rs.address)
            assert(rs.name)
        }
        sql.close()
    }
}