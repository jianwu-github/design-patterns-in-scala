package scala.designpattern.factory

trait Car {
    def manufacture: String
    def model: String
}

class Camry(val id: String) extends Car {
    def manufacture = "Toyota"
    def model = "Camry"
}

class Sonatra(val id: String) extends Car {
    def manufacture = "Hundai"
    def model = "Sonatra"
}

object CarFactory {
    def create(manufacture: String) = manufacture match {
        case "Toyota" => new Camry("TC-" + System.currentTimeMillis())
        case "Hundai" => new Sonatra("HS-" + System.currentTimeMillis())
    }
}