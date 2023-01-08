/**
 * @BelongsProject: Java_study
 * @BelongsPackage: PACKAGE_NAME
 * @Author: yuan wang
 * @CreateTime: 2023-01-08  15:04
 * @Description: TODO
 * @Version: 1.0
 */
public class Info {
	private int id;
	private String account;
	private String password;
	private String nickname;

	public Info() {
	}

	public Info(int id, String account, String password, String nickname) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Info{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}
}
