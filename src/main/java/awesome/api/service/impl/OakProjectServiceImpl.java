package awesome.api.service.impl;

import awesome.api.entity.OakProject;
import awesome.api.mapper.OakProjectMapper;
import awesome.api.service.IOakProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试项目管理表 服务实现类
 * </p>
 *
 * @author yu
 * @since 2020-08-10
 */
@Service
public class OakProjectServiceImpl extends ServiceImpl<OakProjectMapper, OakProject> implements IOakProjectService {

}
