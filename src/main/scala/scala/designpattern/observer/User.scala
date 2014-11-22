package scala.designpattern.observer

class User(var name: String, var pwd: String) extends Observable with Observer {
    def id: String = name
    def receive(event: ObservableEvent) {
        if (!(event.source eq this)) {
            println(name + " received message: \"" + event.message + "\" from " + event.source.id)
        }
    }
}

object User {
    def apply(name: String, pwd: String): User = new User(name, pwd)
}