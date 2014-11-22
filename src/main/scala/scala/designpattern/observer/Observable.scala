package scala.designpattern.observer

import scala.collection.mutable

case class ObservableEvent(val source: Observable, val message: String)

trait Observable {
    val observers = mutable.ListBuffer[Observer]()
    
    def id: String
    def send(message: String) = {
        val event = ObservableEvent(this, message)
        observers.foreach(observer => observer.receive(event))
    }
}

trait Observer {
    def receive(event: ObservableEvent)
}