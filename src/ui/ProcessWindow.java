package ui;

import javax.swing.*;
/*
* 这个类是处理生成题目的窗口类
**/
public class ProcessWindow extends JPanel implements Users{
    private JFrame frame;
    public static String user;

    public ProcessWindow(String user){
        this.user=user;
    }

    public void init() {
        frame = new JFrame("计算题目生成器");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        placeComponents(this);
        frame.setVisible(true);
    }

    //布局信息
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label_user=new JLabel("当前账户：");
        label_user.setBounds(10,10,80,25);
        panel.add(label_user);

        JLabel loguser=new JLabel(user);
        loguser.setBounds(80,10,80,25);
        panel.add(loguser);

        JLabel label_num = new JLabel("请输入要生成的题目数量:");
        label_num.setBounds(90, 50, 150, 25);
        panel.add(label_num);

        JTextField userText = new JTextField(20);
        userText.setBounds(250, 50, 50, 25);
        panel.add(userText);

        JLabel label_gradeSel = new JLabel("切换题目类型:");
        label_gradeSel.setBounds(100, 110, 110, 25);
        panel.add(label_gradeSel);

        String[] items=new String[]{"小学","初中","高中"};
        JComboBox<String> grade=new JComboBox<String>(items);
        grade.setBounds(210,110,80,25);
        panel.add(grade);

        JLabel label_show=new JLabel("当前选择的生成题目类型：");
        label_show.setBounds(90,155,160,25);
        panel.add(label_show);

        JLabel label_state=new JLabel("小学");
        label_state.setBounds(260,155,80,25);
        panel.add(label_state);

        JButton loginButton = new JButton("生成题目");
        loginButton.setBounds(95, 200, 90, 25);
        //loginButton.addActionListener(listener);
        panel.add(loginButton);

        JButton switchButton = new JButton("切换账号");
        switchButton.setBounds(200, 200, 90, 25);
        //loginButton.addActionListener(listener);
        panel.add(switchButton);

        WinListener winListener=new WinListener(loginButton,switchButton,label_state,userText,user,frame);
        switchButton.addActionListener(winListener);
        loginButton.addActionListener(winListener);
        grade.addActionListener(winListener);
    }
}

