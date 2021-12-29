import java.io.Serializable;
import java.util.Objects;

public class Userinfo implements Serializable {

    private String account;
    private String password;

    public Userinfo(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Userinfo userinfo = (Userinfo) object;
        return Objects.equals(account, userinfo.account) && Objects.equals(password, userinfo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }
}
