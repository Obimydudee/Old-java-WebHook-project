import java.io.OutputStream;
import java.io.IOException; 
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import javax.swing.*;

class JavaHookV3{

    public static class TextURL
    {
        private static final int BUFFER_SIZE = 1024 * 10;
        private static final int ZERO = 0;
        private final byte[] dataBuffer = new byte[BUFFER_SIZE];
        private final URL urlObject;

        public TextURL(String urlString) throws MalformedURLException
        {
            this.urlObject = new URL(urlString);
        }

        public String read() 
        {
            final StringBuilder sb = new StringBuilder();

            try
            {
                final BufferedInputStream in =
                        new BufferedInputStream(urlObject.openStream());

                int bytesRead = ZERO;

                while ((bytesRead = in.read(dataBuffer, ZERO, BUFFER_SIZE)) >= ZERO)
                {
                    sb.append(new String(dataBuffer, ZERO, bytesRead));
                }
            }
            catch (UnknownHostException e)
            {
                return null;
            }
            catch (IOException e)
            {
                return null;
            }

            return sb.toString();
       }
    }


    public static void main(String[] args) throws MalformedURLException
	{ 
        
        String fuckmeuwu = args[0];
        String bruh = fuckmeuwu;//args.toString();
        String madeby = "Have a great day~<3";
        String imigurl = "";
        String imageurlbulshit = "";
        String tokenWebhook = "https://ptb.discord.com/api/webhooks/1021607797718269972/cU-YGfvvFCz2onJBmQXGvYBe5rCHp_sbUCiMX_gW0N11rsveUjmkwwZ6LrKGEGErJsP6";//"https://discord.com/api/webhooks/1021607797718269972/cU-YGfvvFCz2onJBmQXGvYBe5rCHp_sbUCiMX_gW0N11rsveUjmkwwZ6LrKGEGErJsP6";//webhooker.nextLine();
        String message = bruh;//msg.nextLine();       
        String nobo = "Built in Java";//title.nextLine();
        String ImageEmbedO = "https://media.discordapp.net/attachments/815474046003183617/1015771515901444106/cat-what.gif";//ImageEmbed.nextLine();
        String jsonBrut = "";
        jsonBrut += "{\"embeds\": [{"
                + "\"title\": \""+ nobo +"\","
                + "\"description\": \""+ message +"\","
                + "\"color\": 11155435" + ","
                + "\"footer\": { \"text\": \"" + madeby +"\"}" + ","
                + "\"thumbnail\": { \"url\": \"" + imigurl +"\"}" + ","
                + "\"image\": { \"url\": \"" + ImageEmbedO +"\"}"
                + "}]}";
        try {
            URL url = new URL(tokenWebhook);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.addRequestProperty("User-Agent", "JavaHookV3-By-Obi-1_");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            OutputStream stream = con.getOutputStream();
            stream.write(jsonBrut.getBytes());
            stream.flush();
            stream.close();
            con.getInputStream().close();
            con.disconnect();
            CheckRealTimeProtectionState();
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,
            "Failed to send webhook because: " + e,
                "PopUp Dialog",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
}   