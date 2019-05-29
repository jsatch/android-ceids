package pe.edu.ulima.comicsstore.model;

public class UserManager {
    public void login(String user, String password, LoginListener listener){
        if (user.equals("ceids") && password.equals("123")){
            listener.onOk();
        }else{
            listener.onError("Login Error");
        }

    }

    public interface LoginListener{
        public void onOk();
        public void onError(String error);
    }
}
