package scala.designpattern.singleton

case class Session(val id: Long)

object SessionManager {
    val id = "sessionmanager"
    override def toString = "SessionManager Singleton Instance"  
      
    def createSession: Session = Session(System.currentTimeMillis())  
}