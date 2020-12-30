import SwiftUI
import krot

struct ContentView: View {
    @ObservedObject var updater = Updater()
    
    var body: some View {
        VStack() {
            Text("Status: \(updater.serverStatus)").padding()
            HStack{
                TextField("Enter user id",text: $updater.userId).padding()
                Button(action: {enterGame(updater)}){Text("Enter Game").padding()}
                Spacer()
            }
            List(updater.logs, id: \.id) { log in
                Text(log.text)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


class Updater: ObservableObject, ClientListener {
    @Published var serverStatus = "0"
    @Published var userId = ""
    @Published var logs: [Log] = []
    
    //let client = Client.init(root: "https://bored-passenger-290806.oa.r.appspot.com", tellTime: {0})
    let client = Client.init(root: "http://localhost:8080",tellTime: {getTime()});
    
    init() {
        client.addListener(listener: self)
        
        DispatchQueue.main.async() {
            self.client.askServerStatus(){
                status,_ in
                self.serverStatus = status ?? "no value"
            }
        }
    }
    
    func onAnyEvent(event: String, data: [String : Any]?) {
        addLog(self, event + " : " + String(describing: data))
    }

    func onChallenge(question: String) {
        addLog(self, question)
    }
    
    func onError(message: String) {
        addErrorLog(self, message)
    }
    
    func onGameEnded(message: String) {
        addLog(self, message)
    }
    
    func onGameStarted(message: String) {
        addLog(self, message)
    }
}

func enterGame(_ updater: Updater){
    updater.client.enterGame(
        player: Player(
            id: updater.userId,
            nickName: updater.userId,
            fcmToken: "000",
            lat: 0.0,
            long: 0.0,
            radius: 0.0),
        completionHandler: {result,error in
            if(result != nil){
                addLog(updater, (result as! ResSuccess<NSString>))
            }
            if(error != nil){
                addErrorLog(updater, (error as! ResError))
            }
        })
}

func addLog(_ updater: Updater,_ result: ResSuccess<NSString>) {
    let log = Log.init(id: updater.logs.count, text: result.data! as String)
    updater.logs.append(log)
}


func addLog(_ updater: Updater,_ message: String) {
    let log = Log.init(id: updater.logs.count, text: message)
    updater.logs.append(log)
}

func addErrorLog(_ updater: Updater, _ error: String) {
    let log = Log.init(id: updater.logs.count, text: error)
    updater.logs.append(log)
}

func addErrorLog(_ updater: Updater, _ error: ResError) {
    let log = Log.init(id: updater.logs.count, text: error.message as String)
    updater.logs.append(log)
}

func getTime() -> KotlinLong {
    return KotlinLong(nonretainedObject: Date().millisecondsSince1970)
}

extension Date {
    var millisecondsSince1970:Int64 {
        return Int64((self.timeIntervalSince1970 * 1000.0).rounded())
    }

    init(milliseconds:Int64) {
        self = Date(timeIntervalSince1970: TimeInterval(milliseconds) / 1000)
    }
}


struct Log: Hashable, Codable, Identifiable {
    var id: Int
    var text: String
}
