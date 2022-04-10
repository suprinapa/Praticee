package pratice

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import groovy.sql.Sql

@Transactional
class MemberService {

    def connection() {
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/myapp', 'root',
                'root', 'com.mysql.jdbc.Driver')
        sql.connection.setAutoCommit(false)
        return sql;
    }

    def create(Member member) {
        def connection =  connection()
       def sqlStr = "INSERT INTO member(version,address,name) VALUES (${member.version}, ${member.address}, ${member.name})"
        try {
            connection.execute(sqlStr);
            connection.commit()
            println("Successfully committed")
        } catch (Exception ex) {
            connection.rollback()
            log.error("---------" + ex.getMessage())
            println("rollback")
        }
       connection.close()
    }

    def getData() {
        def connection =  connection()
        connection.eachRow('select * from member') {
            tp ->
                println([tp.id, tp.version, tp.address, tp.name])
        }
        connection.close()
    }

    def update(Member member,GrailsParameterMap params){
        def connection =  connection()
        member.properties = params
            def sqlStr = "UPDATE member {$params} WHERE {$params}=" +params
            try {
                connection.execute(sqlStr);
                connection.commit()
                println("Successfully committed")
            }catch(Exception ex) {
                connection.rollback()
                println("Transaction rollback")
            }
            connection.close()
        }

    def delete(id) {
        def connection =  connection()
        def sqlStr = "DELETE FROM member WHERE id="+id
        try {
            connection.execute(sqlStr);
            connection.commit()
            println("Successfully committed")
        } catch (Exception ex) {
            connection.rollback()
            println("Transaction rollback")
        }
        connection.close()
    }
}
