package pipihorse.Pojo;
import java.util.Date;

/**
 * @Author 皮皮马
 * @create 2020-12-14 16:25
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String Email;
    private String image;
    private int hasActive;

    public int getHasActive() {
        return hasActive;
    }

    public void setHasActive(int hasActive) {
        this.hasActive = hasActive;
    }

    private String registerDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", Email='" + Email + '\'' +
                ", image='" + image + '\'' +
                ", hasActive=" + hasActive +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
