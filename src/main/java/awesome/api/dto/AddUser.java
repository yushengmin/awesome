package awesome.api.dto;

import awesome.api.entity.Users;

import javax.validation.constraints.NotBlank;

public class AddUser extends Users {

    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String name;

    private String email;

    private String phone;

    private Boolean disable;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Boolean getDisable() {
        return disable;
    }

    @Override
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "AddUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", disable=" + disable +
                '}';
    }
}
