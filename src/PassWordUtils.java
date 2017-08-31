import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public class PassWordUtils {

    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    public boolean checkForNewPassword(  List<String> prePassword ,String password){
        return prePassword.contains(password);
    }
}
