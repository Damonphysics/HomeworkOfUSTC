package water.ustc.bean;

import water.ustc.dao.UserDao;

import java.sql.Connection;
import java.sql.Statement;

public class UserBean {
    private String userId;
    private String userName;
    private String userPass;

    public void setUserId(String ID){
        this.userId = ID;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserPass(String pass){
        this.userPass = pass;
    }
    public String getUserPass(){
        return userPass;
    }

    public boolean signIn(){
        UserDao userDao = new UserDao();
        String loginSql = "SELECT * FROM user WHERE userName='" + this.userName
                + "';";
        Connection connection = userDao.openDBConnection();
        Statement ss = userDao.getStatement();
        System.out.println("---------");
        UserBean user =  userDao.query(loginSql);
        userDao.closeDBConnection();
        return this.userPass.equals(user.userPass);
    }
}
