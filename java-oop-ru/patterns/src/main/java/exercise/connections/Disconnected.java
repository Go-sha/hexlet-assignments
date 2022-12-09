package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    private final TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }
    @Override
    public void connect() {
        this.connection.setConnection(new Connected(this.connection));
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error ! Connection already disconnected.");
    }

    @Override
    public String getState() {
        return "disconnected";
    }
    @Override
    public void write(String data) {
        System.out.println("Error! Cannot write while disconnected.");
    }
}
// END
