package awesome.api.dto;

import awesome.api.entity.Module;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModuleDto extends Module {

    @NotNull(message = "父模块不能为空")
    private Integer parentId;

    @NotBlank(message = "模块编码不能为空")
    private String code;

    @NotBlank(message = "模块名称1不能为空")
    private String name;

    @NotBlank(message = "模块路径不能为空")
    private String path;

    private String description;

    @Override
    public Integer getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
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
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
