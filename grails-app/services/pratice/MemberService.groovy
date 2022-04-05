package pratice

import grails.gorm.transactions.Transactional
import groovy.sql.Sql

@Transactional
class MemberService {

/*    def create(params){
        // Creating a connection to the database
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/myapp', 'root',
                'root', 'com.mysql.jdbc.Driver')

        sql.connection.autoCommit = false

        int id = 1
        BigInteger version =20
        String address = "Ktm"
        String name = "Mac"

        def sqlStr = "INSERT INTO member(id,version,address,name) VALUES (${id}, ${version}, ${address}, ${name})"

        try {
            sql.execute(sqlStr);
            sql.commit()
            println("Successfully committed")
        } catch(Exception ex) {
            sql.rollback()
            log.error("---------" +ex.getMessage())
            println("rollback")
        }
        sql.close()
    }*/

}
