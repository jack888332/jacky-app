package model.business_logic;

import model.bean.User;
import view.bean.LoginForm;

public interface LoginService {
	User checkLoginInfo(LoginForm info);
}
