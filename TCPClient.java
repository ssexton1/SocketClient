import java.io.*;
import java.net.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;

public class TCPClient {
    private static final Logger logger = Logger.getLogger(TCPClient.class.getName());

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.valueOf(args[1]);

        Level logLevel = Level.INFO;
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        // Check for command-line flag to set logging level
        if (args.length > 2 && args[args.length - 1].substring(0, 2).equals("--")) {
            logLevel = Level.parse(args[args.length - 1].substring(2).toUpperCase());
        }

        logger.setLevel(logLevel);

        try {
            Socket socket = new Socket(host, port);
            logger.log(Level.INFO, "Socket created");

            // Create a new thread for command-line I/O
            Thread cliThread = new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String line;
                    while ((line = in.readLine()) != null) {
                        OutputStream out = socket.getOutputStream();
                        logger.log(Level.INFO, "Output stream created");

                        out.write((line + "\n").getBytes());
                        logger.log(Level.INFO, "Data sent to server", line);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            cliThread.start();
            logger.log(Level.FINE, "Thread started");

            InputStream in = socket.getInputStream();
            logger.log(Level.INFO, "Input stream created");

            // Modify the existing thread to handle socket I/O
            int nextByte = in.read();
            logger.log(Level.FINE, "Read first byte");

            while (nextByte != -1) {
                System.out.write(nextByte);
                logger.log(Level.FINER, "Write byte");

                nextByte = in.read();
                logger.log(Level.FINEST, "Read byte");
            }
            socket.close();
            logger.log(Level.INFO, "Socket closed");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
