package edu.zc.reportservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.zc.reportservice.entity.TReport;
import edu.zc.reportservice.mapper.TReportMapper;
import edu.zc.reportservice.service.TReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王晓玲
 * @since 2021-07-07
 */
@Service
public class TReportServiceImpl extends ServiceImpl<TReportMapper, TReport> implements TReportService {

    @Autowired
    private TReportMapper tReportMapper;

    public List<TReport> getUser(String username) {
        QueryWrapper<TReport> wrapper = new QueryWrapper<>();
        wrapper.like("name",username);
        List<TReport> all = baseMapper.selectList(wrapper);
        return all;
    }


//    @Override
//    public List<TReport> getList(Map<String,String> param) {
//        List<TReport> tReports = tReportMapper.getList2(param);
//        return tReports;
//    }
}
