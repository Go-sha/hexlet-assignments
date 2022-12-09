package exercise.connections;

public interface Connection {
    // BEGIN
    void connect();
    void disconnect();
    String getState();
    void write(String data);
    // END
}
