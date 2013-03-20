package smoke11;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: nobody_traveler
 * Date: 20/03/13
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
 */
public class DebugViewPanel {
    public static void  CreateWindow(int locX, int locY, int sizeX, int sizeY)
    {

            //Create and set up the debug window.
            JTextArea ta = new JTextArea();
            ta.setSize(sizeX-100,sizeY);
            TextAreaOutputStream taos = new TextAreaOutputStream( ta, Integer.MAX_VALUE );
            PrintStream ps = new PrintStream( taos );
            System.setOut( ps );
            System.setErr( ps );
            JFrame frame2 = new JFrame ("Debug Console");
            frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            JScrollPane jpane = new JScrollPane( ta );
            jpane.setSize(sizeX-100,sizeY);
            frame2.getContentPane().add ( jpane );
            frame2.setVisible (true);
            frame2.setSize(new Dimension(sizeX,sizeY));
            frame2.setLocation(locX,locY);

    }
}
