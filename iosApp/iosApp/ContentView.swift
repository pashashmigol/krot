import SwiftUI
import krot

struct ContentView: View {
    @ObservedObject var updater = Updater()
    
    var body: some View {
        Text("Value is: \(updater.serverStatus)")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


class Updater: ObservableObject {
    @Published var serverStatus = "0"
    
//    let client = Client.init(root: "https://bored-passenger-290806.oa.r.appspot.com", tellTime: {0})
    
    let client = Client.init(root: "http://localhost:8080", tellTime: {0})
    
    init() {
        DispatchQueue.main.async() {
            self.client.askServerStatus(){
                status,_ in
                self.serverStatus = status ?? "no value"
            }
        }
    }
}
