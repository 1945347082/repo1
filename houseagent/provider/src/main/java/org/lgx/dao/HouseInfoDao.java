package org.lgx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lgx.pojo.HouseInfo;
import org.lgx.pojo.HouseType;

import java.util.List;

/**
 * (Houseinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-28 14:51:51
 */
@Mapper
public interface HouseInfoDao {

    /**
     * 新增数据
     *
     * @param houseInfo 实例对象
     * @return 影响行数
     */
    int insert(HouseInfo houseInfo);

    /**
     * 查询所有房屋信息
     * @return
     */
    List<HouseInfo> getHouseInfoList ();

    /**
     * 按户型查询
     * @param typeId
     * @return
     */
    HouseInfo getHouseInfoById(@Param(value = "typeId") Long typeId);

    /**
     * 获得户型列表
     * @return
     */
    List<HouseType> getTypeList ();
}