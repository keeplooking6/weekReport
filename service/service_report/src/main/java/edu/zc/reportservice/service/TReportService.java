package edu.zc.reportservice.service;

import edu.zc.reportservice.entity.TReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
public interface TReportService extends IService<TReport> {
        List<TReport> getUser(String name);

}
