package edu.zc.reportservice.mapper;

import edu.zc.reportservice.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    void selectAll();
}
