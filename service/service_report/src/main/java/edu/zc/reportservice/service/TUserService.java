package edu.zc.reportservice.service;

import edu.zc.reportservice.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
public interface TUserService extends IService<TUser> {
    public TUser selectAll();
}
