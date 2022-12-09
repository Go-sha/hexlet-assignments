package exercise;

import exercise.connections.Disconnected;
import exercise.connections.Connection;
// BEGIN
public class TcpConnection {
    public Connection connection;
    private final String ip;
    private final int port;
    private String data;

    public TcpConnection(String ip, int port) {
        this.connection = new Disconnected(this);
        this.ip = ip;
        this.port = port;
    }

    public void setConnection(Connection con) {
        this.connection = con;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCurrentState() {
        return this.connection.getState();
    }

    public void connect() {
        this.connection.connect();
    }

    public void disconnect() {
        this.connection.disconnect();
    }

    public void write(String data) {
        this.connection.write(data);
    }
}
// END
