package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 这是对结果显示窗口的监听和响应
 * */
public class DisplayListener implements ActionListener {
    private JFrame frame;

    public DisplayListener(JFrame frame){
        this.frame=frame;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("重新测试")){
            ProcessWindow pw=new ProcessWindow(ProcessWindow.user);
            pw.init();
        }
        frame.dispose();
    }
}
