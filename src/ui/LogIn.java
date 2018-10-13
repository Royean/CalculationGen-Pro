package ui;

import javax.swing.*;
/*
* 该类是主登陆窗口类
*/
public class LogIn extends JPanel{
    private JFrame frame;

    //初始化登录界面
    public void init(){
        frame = new JFrame("登陆");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        placeComponents(this);
        frame.setVisible(true);
    }

    //添加登陆界面的布局 label和button等。
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //标题
        JLabel label_head=new JLabel("欢迎使用QuestionBank");
        label_head.setBounds(95, 25, 400, 25);
        label_head.setFont(new  java.awt.Font("Dialog",1,25));
        panel.add(label_head);

        //账户
        JLabel userLabel = new JLabel("账户:");
        userLabel.setBounds(100, 75, 80, 25);
        panel.add(userLabel);

        //账户输入框
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 75, 160, 25);
        panel.add(userText);

        //密码
        JLabel label_password = new JLabel("密码:");
        label_password.setBounds(100, 120, 80, 25);
        panel.add(label_password);

        //密码输入框
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 120, 160, 25);
        panel.add(passwordText);

        //登陆按钮
        JButton loginButton = new JButton("登陆");
        loginButton.setBounds(120, 180, 80, 25);
        //loginButton.addActionListener(listener);
        panel.add(loginButton);

        //清空按钮
        JButton btn_clear= new JButton("注册");
        btn_clear.setBounds(220, 180, 80, 25);
        //loginButton.addActionListener(listener);
        panel.add(btn_clear);

        //添加按键监听
        LogListener listener=new LogListener(userText,passwordText,frame);
        loginButton.addActionListener(listener);
        btn_clear.addActionListener(listener);
    }

}
