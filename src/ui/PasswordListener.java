package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 这是对设置密码窗口的监听和响应
 * */
public class PasswordListener implements ActionListener,Users {
    private JPasswordField firstInput;
    private JPasswordField secondInput;
    private String phoneNum;
    private JFrame frame;

    public PasswordListener(JFrame frame,JPasswordField firstInput,JPasswordField secondInput,String phoneNum){
        this.frame=frame;
        this.firstInput=firstInput;
        this.secondInput=secondInput;
        this.phoneNum=phoneNum;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("确定")){
           //密码输入一致
            String first=new String(firstInput.getPassword());
            String second=new String(secondInput.getPassword());
            if(first.equals(second)){
               if(passwordJudge(first)){
//                   nameList.put(phoneNum,firstInput.getText());
                   try(BufferedWriter bw=new BufferedWriter(new FileWriter("account.txt",true))){
                       bw.write(phoneNum+"  "+first+"\r\n");
                   } catch (IOException e1) {
                       e1.printStackTrace();
                   }
                   ProcessWindow pw=new ProcessWindow(phoneNum);
                   pw.init();
                   frame.dispose();
               }
               //密码不符合规范
               else{
                   JOptionPane.showMessageDialog(null,"密码不符合规范，必须包含大小写字母和数字。");
                   firstInput.setText("");
                   secondInput.setText("");
               }
           }
           //两次密码输入不一致
           else{
                JOptionPane.showMessageDialog(null,"两次密码输入不一致");
                firstInput.setText("");
                secondInput.setText("");
           }
        }
    }
    //检查密码的规范性
    public boolean passwordJudge(String password){
        boolean Upper=false,Lower=false,number=false;
        if(password.length()>=6 && password.length()<=10){
            for(int i=0;i<password.length();i++){
                char c=password.charAt(i);
                if(c>='A' && c<='Z') Upper=true;
                else if(c>='a' && c<='z') Lower=true;
                else if(c>='0' && c<='9') number=true;
            }
        }
        return Upper&Lower&number;
    }
}
