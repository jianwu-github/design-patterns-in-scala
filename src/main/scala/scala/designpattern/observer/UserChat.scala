package scala.designpattern.observer

class UserChat(val user1: User, val user2: User) {
    private var isChattingFlag = false
  
    def isChatting(): Boolean = isChattingFlag
    
    def startChat {
        user1.observers.append(user2)
        user2.observers.append(user1)
        
        isChattingFlag = true
    }
    
    def from(user: User, message: String) {
        if (isChatting) {
	        if ((user eq user1) || (user eq user2)) {
	           user.send(message)
	        } else throw new IllegalArgumentException("User does not belong to this Chat")
        } else throw new IllegalStateException("Users are not in Chatting")
    }
    
    def stopChat {
        if (isChattingFlag) {
            user1.observers -= user2
            user2.observers -= user1
            isChattingFlag = false
        }
    }
}

object UserChat {
    def apply(user1: User, user2: User): UserChat = { 
        val chat = new UserChat(user1, user2)
        chat.startChat
        chat
    }
    
    def main(args: Array[String]) {
        val user1 = User("jianwu", "jianwu")
        val user2 = User("wujian", "wujian")
        
        val chat = UserChat(user1, user2)
        
        chat.from(user1, "hello this is jianwu")
        chat.from(user2, "hello this is wujian")
        
        chat.stopChat
    }
}