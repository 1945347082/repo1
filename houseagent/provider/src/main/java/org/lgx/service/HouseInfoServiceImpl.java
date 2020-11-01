package org.lgx.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.lgx.dao.HouseInfoDao;
import org.lgx.pojo.HouseInfo;
import org.lgx.pojo.HouseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Houseinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-08-28 14:51:52
 */
@Service(interfaceClass = HouseInfoService.class )
@Transactional
public class HouseInfoServiceImpl implements HouseInfoService {
    @Autowired
    private HouseInfoDao houseinfoDao;

    /**
     * 查询所有房屋信息
     *
     * @return
     */
    @Override
    public List<HouseInfo> getHouseInfoList () {

        return houseinfoDao.getHouseInfoList();
    }

    /**
     * 获得户型列表
     *
     * @return
     */
    @Override
    public List<HouseType> getTypeList () {
        return houseinfoDao.getTypeList();
    }

    /**
     * 新增数据
     *
     * @param houseinfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert (HouseInfo houseinfo) {
        int num = houseinfoDao.insert(houseinfo);
        return num;
    }

    /**
     * 按户型查询
     *
     * @param id
     * @return
     */
    @Override
    public HouseInfo getHouseInfoById (Long id) {
        return houseinfoDao.getHouseInfoById(id);
    }
}