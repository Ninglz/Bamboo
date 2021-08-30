package com.ninglz.bamboo.upms.sysLog;

import com.ninglz.bamboo.upms.domain.sysLog.SysLog;

public class SysLogConvertor {


    public static SysLogDO toDataObject(SysLog sysLog) {
        return SysLogDO.builder().createBy(sysLog.getCreateBy())
                .exception(sysLog.getException())
                .method(sysLog.getMethod())
                .params(sysLog.getParams())
                .remoteAddr(sysLog.getRemoteAddr())
                .requestUri(sysLog.getRequestUri())
                .serviceId(sysLog.getServiceId())
                .time(sysLog.getTime())
                .title(sysLog.getTitle())
                .type(sysLog.getType())
                .userAgent(sysLog.getUserAgent())
                .build();

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
