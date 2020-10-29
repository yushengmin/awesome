package awesome.api.service;

import awesome.api.dto.ModuleDto;
import awesome.api.dto.RoleDto;
import awesome.api.entity.Module;
import awesome.response.ResponseCommonData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yu
 * @since 2020-01-23
 */
public interface IModuleService extends IService<Module> {
    public ResponseCommonData<HashMap> modulelist(Integer pag, Integer pagesize);
    public ResponseCommonData addmodule(ModuleDto module);
    public ResponseCommonData editmodule(ModuleDto module);
    public ResponseCommonData delmodule(Integer moduleId);


}
