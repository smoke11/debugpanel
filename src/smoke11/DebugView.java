package smoke11;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: nobody_traveler
 * Date: 20/03/13
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
 */
public class DebugView{
    private static int debugLevel=2;//0-no debug, 1-errors, 2-most important info, 3-less and etc.
    private static JTextField find;
    private static JTextArea textArea;
    private static String lastFind="";
    private static int lastIndex=0;
    public static final int DEBUGLVL_ERRORS = 1;
    public static final int DEBUGLVL_LESSINFO = 2;
    public static final int DEBUGLVL_MOREINFO = 3;
    private static Date date;

    public static JFrame createWindow(int locX, int locY, int sizeX, int sizeY, int debuglevel)
    {
        //Create and set up the debug window.
        debugLevel=debuglevel;
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setFocusable(true);
        TextAreaOutputStream taos = new TextAreaOutputStream( textArea, Integer.MAX_VALUE );
        PrintStream ps = new PrintStream( taos );
        System.setOut( ps );
        System.setErr( ps );

        JFrame window = new JFrame ("Debug Console");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        find = new JTextField("Find Text");
        find.setSize(200, 20);
        find.setBackground(Color.BLACK);
        find.setForeground(Color.GREEN);
        find.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {       //if enter pressed, find typed word
                //To change body of implemented methods use File | Settings | File Templates.
                if(e.getKeyChar()==KeyEvent.VK_ENTER)
                {

                   String text = textArea.getText();
                   String findtext = find.getText();
                    findWords(findtext,text);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        JScrollPane jpane = new JScrollPane( textArea );
        jpane.setSize(sizeX-100,sizeY);
        jpane.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textArea.repaint();
                find.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                textArea.repaint();
                find.repaint();
            }
        });
        jpane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                textArea.repaint();
                find.repaint();
            }
        });
        jpane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                textArea.repaint();
                find.repaint();
            }
        });
        window.getContentPane().add(find);
        window.getContentPane().add ( jpane );
        window.setVisible(true);
        window.setSize(new Dimension(sizeX, sizeY));
        window.setLocation(locX, locY);

        System.out.println("------");
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
        System.out.println("------");
        System.out.println("Initializing Debug Panel.");
        System.out.println("Showing messages for debug level == "+ debugLevel);
        System.out.println("------");
        return panel;
    }
    public static void setDebugLevel(int level)  {debugLevel=level; System.out.println("Showing messages for debug level == "+ debugLevel);}

    public static void writeDebug(int level, String classname, String message)
    {
        date = new Date();
        if(level<=debugLevel)
            System.out.println(date.getTime()+"[L"+level+"] "+classname+": "+message);
    }
    private static void findWords(String findtext,String text)
    {

        int start=0,  end=text.length(), endfind = findtext.length(), i=0, caretposition=-1;
        Highlighter h = textArea.getHighlighter();
        h.removeAllHighlights();
        if(findtext.equals(lastFind))
            lastIndex++;
        else
        {
            lastFind=findtext;
            lastIndex=0;
        }
        while(start<end)
        {
            start=text.indexOf(findtext,start);
            if(start==-1)
                break;
            Highlighter.HighlightPainter painter;
            if(lastIndex==i)
            {
                caretposition=start;
                painter = new DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);
            }
            else
                painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);

            try {
                h.addHighlight(start, start+endfind, painter);
            } catch (BadLocationException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            textArea.setSelectionStart(start);
            textArea.setSelectionEnd(end);
            start+=endfind;
            i++;
        }
        if(caretposition>0)
            textArea.setCaretPosition(caretposition);
    }

}

