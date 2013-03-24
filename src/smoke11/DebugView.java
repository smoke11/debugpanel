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
public class DebugView {
    private static int debugLevel;//0-no debug, 1-errors, 2-most important info, 3-less and etc.
    public static final int DEBUGLVL_ERRORS = 1;
    public static final int DEBUGLVL_LESSINFO = 2;
    public static final int DEBUGLVL_MOREINFO = 3;

    public static JFrame createWindow(int locX, int locY, int sizeX, int sizeY, int debuglevel)
    {
        //Create and set up the debug window.
        debugLevel=debuglevel;
        JTextArea ta = new JTextArea();
        ta.setSize(sizeX-100,sizeY);
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, Integer.MAX_VALUE );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );
        JFrame window = new JFrame ("Debug Console");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jpane = new JScrollPane( ta );
        jpane.setSize(sizeX-100,sizeY);
        window.getContentPane().add ( jpane );
        window.setVisible(true);
        window.setSize(new Dimension(sizeX, sizeY));
        window.setLocation(locX, locY);
        System.out.println("Initializing Debug Window.");
        System.out.println("Showing messages for debug level == "+ debugLevel);
        System.out.println("------");
        return window;
    }
    public static JPanel createPanel(int sizeX, int sizeY, int debuglevel)
    {
        //Create and set up the debug window.
        debugLevel=debuglevel;
        JTextArea ta = new JTextArea();
        ta.setSize(sizeX-100,sizeY);
        TextAreaOutputStream taos = new TextAreaOutputStream( ta, Integer.MAX_VALUE );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );
        JScrollPane jpane = new JScrollPane( ta );
        jpane.setSize(sizeX-100,sizeY);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(sizeX,sizeY));
        panel.add(jpane);
        System.out.println("Initializing Debug Window.");
        System.out.println("Showing messages for debug level == "+ debugLevel);
        System.out.println("------");
        return panel;
    }
    public static void writeDebug(int level, String classname, String message)
    {
        if(level<=debugLevel)
            System.out.println(classname+": "+message);
    }
}
