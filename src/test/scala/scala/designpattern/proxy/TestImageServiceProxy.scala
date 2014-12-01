package scala.designpattern.proxy

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.net.URL

@RunWith(classOf[JUnitRunner])
class TestImageServiceProxy extends FunSuite {

    test("Test ImageServiceProxy") {
        val imageFileUrl = getClass.getResource("/proxypattern.jpg")
        val proxy = new ImageServiceProxy(imageFileUrl)
        info(proxy.toString)
        val image = proxy.image
        assert(image != null)
    }

}