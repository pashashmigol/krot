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
    
    init() {
        DispatchQueue.main.async() {
            Client().enterGame(){
                status,_ in
                self.serverStatus = status ?? "no value"
            }
        }
    }
}
