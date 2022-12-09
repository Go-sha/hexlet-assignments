package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private final TcpConnection connection;

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already connected.");
    }

    @Override
    public void disconnect() {
        this.connection.setConnection(new Disconnected(this.connection));
        System.out.println("disconnected");
    }

    @Override
    public String getState() {
        return "connected";
    }

    @Override
    public void write(String data) {
        this.connection.setData(data);
    }
}
// END
