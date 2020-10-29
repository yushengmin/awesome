package awesome.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import awesome.api.entity.Users;


public class UpdateUserDto extends Users {
    @NotBlank(message = "userId不能为空")
    private Integer userId;
    
    @NotBlank(message = "名称不能为空")
    private String name;
    
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;
    
    @NotBlank(message = "手机号不能为空")
    private String phone;

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
    public String toString() {
        return "UpdateUserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
