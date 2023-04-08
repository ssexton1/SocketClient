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
            OutputStream out = socket.getOutputStream();
            logger.log(Level.INFO, "Output stream created");
            
            if (args.length > 2) {
      
               String msg = "";
              
               for (int i = 2; i < args.length; i++) {
                  if (!args[i].substring(0, 2).equals("--")) {
                        msg += " " + args[i];
                  }
               }
               msg += "\n";
               out.write(msg.getBytes());
               logger.log(Level.INFO, "Data sent to server", msg);
             }      


            // Create a new thread for command-line I/O
            Thread cliThread = new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String line;
                    
                    while ((line = in.readLine()) != null) {
                        out.write((line + "\n").getBytes());
                        logger.log(Level.INFO, "Data sent to server", line);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            cliThread.start();
            logger.log(Level.FINE, "Thread started");

            InputStream inputStream = socket.getInputStream();
            logger.log(Level.INFO, "Input stream created");

            // Modify the existing thread to handle socket I/O
            int nextByte = inputStream.read();
            logger.log(Level.FINE, "Read first byte");

            while (nextByte != -1) {
                System.out.write(nextByte);
                logger.log(Level.FINER, "Write byte");

                nextByte = inputStream.read();
                logger.log(Level.FINEST, "Read byte");
            }
            socket.close();
            logger.log(Level.INFO, "Socket closed");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
