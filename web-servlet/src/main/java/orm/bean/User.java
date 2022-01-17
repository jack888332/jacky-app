package orm.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Date regdate;

	public User() {
	}

	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		setRegdate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd kk:mm", new Locale("zh", "CN"));
		return sdf.format(this.regdate);
	}

	public void setRegdate() {
		this.regdate = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", regdate=" + regdate + "]";
	}

}
