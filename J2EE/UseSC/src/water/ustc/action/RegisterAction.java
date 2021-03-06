package water.ustc.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterAction extends HttpServlet {
    private String userName;
    private String password;
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;

    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String handleRegister(HttpServletRequest request, HttpServletResponse response){
        boolean flag = true;
        setUserName(request.getParameter("id"));
        setPassword(request.getParameter("password"));
        System.out.println("-----注册用户信息-----");
        System.out.println("--用户名："+userName);
        System.out.println("--密码："+password);
        Pattern passwd_pattern = Pattern.compile("[0-9]*");
        Pattern user_pattern = Pattern.compile("[A-Z]*");
        Matcher isPassOK = passwd_pattern.matcher(password);
        Matcher isUserOk = user_pattern.matcher(userName);
        if(!isPassOK.matches()){
            System.out.println("password illegal, try another!");
            flag = false;
        }else if(!isUserOk.matches()){
            System.out.println("username illegal, try another!");
            flag = false;
        }
        if(flag){
            return "success";
        }else{
            return "failure";
        }
    }



}
