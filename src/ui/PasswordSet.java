package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 注册完之后要输入密码，该类是设置密码窗口类
 */
public class PasswordSet extends JPanel {
    private JTextField firstInput;
    private JFrame frame;
    private JTextField secondInput;
    private String phoneNum;

    public PasswordSet(String phoneNum){
        this.phoneNum=phoneNum;
    }
    public void init() {
        frame = new JFrame("密码设置");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        placeComponents(this);
        frame.setVisible(true);
    }


    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        //显示请输入密码
        JLabel label_user = new JLabel("请输入密码：");
        label_user.setBounds(80, 40, 100, 25);
        panel.add(label_user);

//        JLabel loguser=new JLabel(user);
//        loguser.setBounds(80,10,80,25);
//        panel.add(loguser);

        //输入密码框
        JPasswordField firstInput = new JPasswordField(20);
        firstInput.setBounds(200, 40, 120, 25);
        panel.add(firstInput);


        //显示确认密码
        JLabel label_num = new JLabel("确认密码:");
        label_num.setBounds(80, 110, 150, 25);
        panel.add(label_num);

        //再次输入的密码框
        JPasswordField vericationCode = new JPasswordField(20);
        vericationCode.setBounds(200, 110, 120, 25);
        panel.add(vericationCode);

        //确认按钮
        JButton switchButton = new JButton("确定");
        switchButton.setBounds(200, 140, 120, 25);
        //loginButton.addActionListener(listener);
        panel.add(switchButton);

        PasswordListener pl=new PasswordListener(frame,firstInput,vericationCode,phoneNum);
        switchButton.addActionListener(pl);
    }
}
