package scala.designpattern.singleton

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestSessionManager extends FunSuite {

    test("Test SessionManager is a singleton instance") {
        val sessionManagerId = SessionManager.id 
        info("sessionManagerId: " + sessionManagerId)
        info(SessionManager.toString)
    }
    
    test("Test SessonManager Singleton Instance to create new Session") {
        val session = SessionManager.createSession
        info("new Session with Id: " + session.id)        
    }
}