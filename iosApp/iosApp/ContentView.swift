import SwiftUI
import krot

struct ContentView: View {
    var body: some View {
        let status = Client().askServerStatus()
        return Text("Hello, World! \(status)")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
