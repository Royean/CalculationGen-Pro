package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


/*
* 这是对登陆窗口的监听和响应，逻辑较为简单，只有几个事件
* */
public class LogListener implements ActionListener,Users {
    private HashMap<String,String> nameList;
    private JComboBox<String> combo_gradeSel;
    private JTextField user;
    private JPasswordField passwordField;
    private JFrame frame;

    public LogListener(JTextField user,JPasswordField passwordField,JFrame frame){
        this.user=user;
        this.passwordField=passwordField;
        this.frame=frame;
    }

    //登录时密码输入情况的判断
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("登陆")){
            String tmp=new String(passwordField.getPassword());
            String line="";
            String tag="\\s+";
            String passw="";
            try (BufferedReader br = new BufferedReader(new FileReader("account.txt"))) {
                while((line=br.readLine())!=null){
                    String[] content=line.split(tag);
                    if(content[0].equals(user.getText())){
                        passw=content[1];
                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if(passw.equals(tmp)){
                JOptionPane.showMessageDialog(null,"登陆成功");
                ProcessWindow win=new ProcessWindow(user.getText());
                win.init();
                frame.dispose();
            }
            else if(passw.equals("")){
                JOptionPane.showMessageDialog(null,"账户不存在！");
            }
            else if(!passw.equals(tmp)){
                JOptionPane.showMessageDialog(null,"密码错误！");
            }

        }
        //跳转到注册界面
        else if(e.getActionCommand().equals("注册")){
            Register re=new Register();
            re.init();
            frame.dispose();
        }
    }
}
