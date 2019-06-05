package de.leonlatsch.olivia.dto;

public class UserDTO extends BaseDTO {

    private int uid;
    private String username;
    private String email;
    private String password;
    private String profilePic;

    public UserDTO() {}

    public UserDTO(int uid, String username, String email, String password, String profilePic) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
