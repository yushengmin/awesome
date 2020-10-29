package awesome.api.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试项目管理表
 * </p>
 *
 * @author yu
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OakProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父项目
     */
    private Integer parent;

    /**
     * 代码
     */
    private String code;

    /**
     * 项目名称
     */
    private String pname;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 修改时间
     */
    private Long mtime;


}
