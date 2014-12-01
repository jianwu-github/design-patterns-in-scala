package scala.designpattern.proxy

import javax.swing.ImageIcon
import java.net.URL

/**
 * This is adopted from "Scala Design Patterns" by John Hunt
 */
trait Proxy 

trait Service

trait ImageProvider {
  val fileUrl: URL
  def image: ImageIcon
}

private class RealImageService(val fileUrl: URL) extends Service with ImageProvider {
  private val imageIcon = new ImageIcon(fileUrl)
  def image: ImageIcon = imageIcon
}

class ImageServiceProxy(imageFileUrl: URL) extends Proxy with ImageProvider {
  val fileUrl = imageFileUrl
  private lazy val imageService = new RealImageService(imageFileUrl)
  def image: ImageIcon = imageService.image
  override def toString = "ImageServiceProxy for: " + imageFileUrl.toString()
}

