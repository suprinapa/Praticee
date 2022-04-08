package pratice

class Member {

    String name
    String address

    static constraints = {
        name maxSize: 255
        address inList: ['Ktm', 'Lalitpur','Bhaktapur' ]
    }
}
