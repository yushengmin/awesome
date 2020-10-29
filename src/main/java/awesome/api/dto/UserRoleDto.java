package awesome.api.dto;

import awesome.api.entity.Role;
import awesome.api.entity.Users;

public class UserRoleDto extends Role {

    private Integer userId;
    private boolean selected;



    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "userId=" + userId +
                '}';

    }
}
