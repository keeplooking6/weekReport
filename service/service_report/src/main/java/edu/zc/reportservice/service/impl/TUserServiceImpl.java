package edu.zc.reportservice.service.impl;

import edu.zc.reportservice.entity.TUser;
import edu.zc.reportservice.mapper.TUserMapper;
import edu.zc.reportservice.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectAll() {
        tUserMapper.selectAll();
        return null;
    }
}
