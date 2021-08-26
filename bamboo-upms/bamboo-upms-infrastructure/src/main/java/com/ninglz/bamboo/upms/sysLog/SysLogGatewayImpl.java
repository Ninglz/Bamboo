package com.ninglz.bamboo.upms.sysLog;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.ninglz.bamboo.upms.domain.sysLog.SysLog;
import com.ninglz.bamboo.upms.domain.sysLog.gateway.SysLogGateway;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SysLog网关实现
 * @author ninglz
 */
@Slf4j
@Component
public class SysLogGatewayImpl implements SysLogGateway {

    @Resource
    SysLogMapper logMapper;


    @Override
    public boolean save(SysLog sysLog) {
        SysLogDO sysLogDO = SysLogConvertor.toDataObject(sysLog);
        return SqlHelper.retBool(logMapper.insert(sysLogDO));
    }

    @Override
    public boolean saveBatch(List<SysLog> sysLogs) {
        List<SysLogDO> collect =sysLogs.stream().collect(ArrayList::new,
                (list,sysLog) -> list.add(SysLogConvertor.toDataObject(sysLog)),
                ArrayList::addAll);

        String sqlStatement =  SqlHelper.getSqlStatement(logMapper.getClass(), SqlMethod.INSERT_ONE);
        return SqlHelper.executeBatch(SysLogDO.class, LogFactory.getLog(getClass()), collect, 1000,
                (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));
    }

    @Override
    public boolean remove(Serializable id) {
        return SqlHelper.retBool(logMapper.deleteById(id));
    }

//    @Override
//    public Page selectPage(Page page, LambdaQueryWrapper<SysLog> wrapper) {
//        LambdaQueryWrapper<SysLogDO> wrapper = Wrappers.lambdaQuery();
//        if (StrUtil.isNotBlank(sysLog.getType())) {
//            wrapper.eq(SysLogDO::getType, sysLog.getType());
//        }
//
//        if (ArrayUtil.isNotEmpty(sysLog.getCreateTime())) {
//            wrapper.ge(SysLog::getCreateTime, sysLog.getCreateTime()[0]).le(SysLog::getCreateTime,
//                    sysLog.getCreateTime()[1]);
//        }
//        return logMapper.selectPage(page, wrapper);
//    }

}
