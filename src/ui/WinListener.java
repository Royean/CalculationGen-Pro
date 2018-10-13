package ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/*
* 事件监听类，负责对生成题目窗口的鼠标键盘等事件的监听和响应
* */
public class WinListener implements ActionListener {
    private JFrame frame;
    private JButton loginButton;
    private JButton switchButton;
    private JLabel label_state;
    private JTextField user;
    private String username;

    public WinListener(JButton loginButton,JButton switchButton,JLabel label_state,JTextField user,String username,JFrame frame){
        this.frame=frame;
        this.loginButton=loginButton;
        this.switchButton=switchButton;
        this.label_state=label_state;
        this.user=user;
        this.username=username;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("生成题目")){
        	int problemNum=Integer.parseInt(user.getText());

            //题目数量输入判定
        	if(problemNum>30 || problemNum<10) {
                JOptionPane.showMessageDialog(null,"请输入10-30间的题目数量");
                user.setText("");
        	}else{
                QuesPro qp=new QuesPro(label_state.getText(),problemNum);
                qp.init();
                frame.dispose();

            }
        }

        //账号切换按钮
        else if(e.getActionCommand().equals("切换账号")){
            String[] options={"确定","取消"};
            if(JOptionPane.showOptionDialog(null, "确定要切换账号吗？",
                    "注销",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0])==0){
                LogIn logIn=new LogIn();
                logIn.init();
                frame.dispose();
            }
        }
        //下拉框响应
        else if(e.getSource() instanceof JComboBox){
            JComboBox<String> cbItem = (JComboBox<String>) e.getSource();// 获取事件源对象
            label_state.setText(cbItem.getSelectedItem().toString());
        }
    }
}
