package com.ninglz.bamboo.upms.sysLog;

import com.ninglz.bamboo.common.core.util.CopyUtiil;
import com.ninglz.bamboo.upms.domain.sysLog.SysLog;

public class SysLogConvertor {


    public static SysLogDO toDataObject(SysLog sysLog) {
        SysLogDO logDO = new SysLogDO();
        CopyUtiil.copy(sysLog,logDO);
        return logDO;
    }

    public static SysLog toEntity(SysLogDO sysLogDO) {
//        SysLog sysLog = new SysLog();
//        userEntity.setId(userDO.getId());
//        userEntity.setUsername(userDO.getUsername());
//        userEntity.setPassword(userDO.getPassword());
//        userEntity.setSalt(userDO.getSalt());
//        userEntity.setName(userDO.getName());
//        if (userDO.getUserInfoDO() != null) {
//            userEntity.setPhoneNo(userDO.getUserInfoDO().getPhoneNo());
//            userEntity.setGender(userDO.getUserInfoDO().getGender());
//            userEntity.setBirthday(userDO.getUserInfoDO().getBirthday());
//            userEntity.setDescription(userDO.getUserInfoDO().getDescription());
//        }

        return null;
    }

//    public static void mergeDataObject(UserEntity userEntity, UserDO userDO) {
//        userDO.setUsername(userEntity.getUsername());
//        userDO.setName(userEntity.getName());
//        userDO.getUserInfoDO().setPhoneNo(userEntity.getPhoneNo());
//        userDO.getUserInfoDO().setGender(userEntity.getGender());
//        userDO.getUserInfoDO().setBirthday(userEntity.getBirthday());
//        userDO.getUserInfoDO().setDescription(userEntity.getDescription());
//    }
//
//    public static UserVO toValueObject(UserEntity userEntity) {
//        UserVO userVO = new UserVO();
//        userVO.setId(userEntity.getId());
//        userVO.setUsername(userEntity.getUsername());
//        userVO.setName(userEntity.getName());
//        userVO.setPhoneNo(userEntity.getPhoneNo());
//        userVO.setGender(userEntity.getGender());
//        userVO.setBirthday(userEntity.getBirthday());
//        userVO.setDescription(userEntity.getDescription());
//
//        return userVO;
//    }
}
