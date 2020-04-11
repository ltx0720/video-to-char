import javax.swing.*;
import java.awt.*;

/**
 * @Author ltx
 * @Date 0:02 2020/4/11
 */
public class Frame {

    public static JFrame jFrame = null;
    public static JTextArea textArea = null;

    static {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(100, 100, Config.WIDTH, Config.HEIGHT);
        jFrame.setResizable(false);
        //去掉边框
        jFrame.setUndecorated(true);
        //设置窗口位置
        jFrame.setLocation(Config.OFFSETX, Config.OFFSETY);

        textArea = new JTextArea(3, 3);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setBounds(0, 0, Config.WIDTH, Config.HEIGHT);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 13));
        jFrame.add(textArea);
        jFrame.setVisible(true);
    }

    public static void replaceRow(int lineNum, String str){
        int start =  (Config.COLUMNS+1) * (lineNum-1);
        int end = start + Config.COLUMNS;

        textArea.replaceRange(str, start, end);
    }

    public static void replaceOne(int lineNum, int index, String s) {
        // 播放太快，耗时操作
//        int x = 999;
//        int y = 999;
//        while (x > 0){
//          while (y > 0){
//              y--;
//          }
//          x--;
//        }

        int start =  (Config.COLUMNS+1) * lineNum + index;
        int end = start + 1;

        textArea.replaceRange(s, start, end);
    }

    public static void append(String s){
        textArea.append(s);
    }

    public static void append(){
        textArea.append("\n");
    }

}



























