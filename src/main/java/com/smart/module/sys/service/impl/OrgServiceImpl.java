package com.smart.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.model.Result;
import com.smart.module.sys.entity.Org;
import com.smart.module.sys.entity.Role;
import com.smart.module.sys.mapper.OrgMapper;
import com.smart.module.sys.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author 小柒2012
 * @since 2021-08-16
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

    @Resource
    private OrgMapper OrgMapper;

    @Override
    public Result listPage(Org org) {
        IPage<Org> page = new Page(org.getPageNo(), org.getPageSize());
        QueryWrapper query = new QueryWrapper<>()
                .like(false, "name ", org.getName());
        IPage<Org> list = OrgMapper.selectPage(page, query);
        return Result.ok(list);
    }

    @Override
    public List<Org> select(Long parentId) {
        parentId = parentId==null?0:parentId;
        QueryWrapper query = new QueryWrapper<>().eq(false,"parent_id",parentId);
        List<Org> list = OrgMapper.selectList(query);
        return list;
    }
}
