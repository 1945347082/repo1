package org.lgx.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackgeName: org.lgx.service
 * @ClassName: HouseTypeImpl
 * @Author: lgx
 * @Date: 2020/8/28 14:55
 * @project name: houseagent
 * @Version: V1.0
 * @Description:
 */
@Service(interfaceClass= HouseTypeService.class)
@Transactional
public class HouseTypeServiceImpl implements HouseTypeService {


}
