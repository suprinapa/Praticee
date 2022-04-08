package pratice

import grails.gorm.transactions.Transactional
import groovy.sql.Sql

@Transactional
class MemberService {

    def connection() {
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/myapp', 'root',
                'root', 'com.mysql.jdbc.Driver')
        sql.connection.setAutoCommit(false)
        return sql;
    }

    def create() {
        def connection =  connection()
        BigInteger version = 21
        String address = "Ktm"
        String name = "Dai"

      /*  List<Member> list = new ArrayList<>();

        list.add(version)
        list.add(address)
        list.add(name)
        for(int i= 0; i < list.size(); i++){

        }*/

       def sqlStr = "INSERT INTO member(version,address,name) VALUES (${version}, ${address}, ${name})"
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

    def update(){
        def connection =  connection()
            def sqlStr = "UPDATE member SET id = id + 6 WHERE address = 'Ktm'"

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

    def delete() {
        def connection =  connection()
        def sqlStr = "DELETE FROM member WHERE name='Dai'"
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
