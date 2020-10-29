package awesome.api.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class RoleModule implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    private Integer moduleId;

    private Long createTime;

    private Long modifyTime;


}
