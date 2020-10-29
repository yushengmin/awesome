package awesome.api.dto;

import awesome.api.entity.Role;

import javax.validation.constraints.NotBlank;

public class RoleDto extends Role {


    @NotBlank(message = "模块名称不能为空")
    private String roleName;

    private String description;




    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
