package ui;

import javax.swing.*;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 该类是注册窗口类
 */
public class Register extends  JPanel{
    private JFrame frame;
    private String type;
    private String user;

    public void init() {
        frame = new JFrame("注册");
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

        //输入手机号
        JLabel label_user=new JLabel("请输入手机号：");
        label_user.setBounds(80,40,100,25);
        panel.add(label_user);

//        JLabel loguser=new JLabel(user);
//        loguser.setBounds(80,10,80,25);
//        panel.add(loguser);

        //手机号输入框
        JTextField phoneNum = new JTextField(20);
        phoneNum.setBounds(200, 40, 120, 25);
        panel.add(phoneNum);

        //发送验证码按钮
        JButton loginButton = new JButton("发送验证码");
        loginButton.setBounds(200, 70, 120, 25);
        //loginButton.addActionListener(listener);
        panel.add(loginButton);


        //显示请输入验证码
        JLabel label_num = new JLabel("请输入验证码:");
        label_num.setBounds(80, 110, 150, 25);
        panel.add(label_num);

        //验证码输入框
        JTextField  vericationCode= new JTextField(20);
        vericationCode.setBounds(200, 110, 120, 25);
        panel.add(vericationCode);


        //确认按钮
        JButton switchButton = new JButton("确定");
        switchButton.setBounds(200, 140, 120, 25);
        //loginButton.addActionListener(listener);
        panel.add(switchButton);

        RegisterListener registerListener=new RegisterListener(frame,phoneNum,vericationCode);
        switchButton.addActionListener(registerListener);
        loginButton.addActionListener(registerListener);

    }
}
