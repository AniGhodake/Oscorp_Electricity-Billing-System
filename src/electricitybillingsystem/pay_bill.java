/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package electricitybillingsystem;

/**
 *
 * @author Aniket
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;

public class pay_bill{
    pay_bill(){
  /*      JEditorPane j = new JEditorPane();
        j.setEditable(false);


        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop().browse(new URI("http://www.google.com"));
}
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");

        }

        JScrollPane scrollPane = new JScrollPane(j);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);*/
         String url = "https://paytm.com/";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new pay_bill();
    }
}
/*
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class pay_bill {
    public static void main(String[] args) {

        String url = "https://paytm.com/";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
*/