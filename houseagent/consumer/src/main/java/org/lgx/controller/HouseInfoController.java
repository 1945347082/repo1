package org.lgx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lgx.pojo.HouseInfo;
import org.lgx.pojo.HouseType;
import org.lgx.service.HouseInfoService;
import org.lgx.service.HouseTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @PackgeName: org.lgx.controller
 * @ClassName: HouseInfoController
 * @Author: lgx
 * @Date: 2020/8/28 15:30
 * @project name: houseagent
 * @Version: V1.0
 * @Description:
 */
@Controller
public class HouseInfoController {
    @Reference
    private HouseInfoService houseInfoService;

    /**
     * 新增房屋信息
     * @param houseInfo
     * @return
     */
    @PostMapping("/addHouseInfo")
    public void addHouseInfo(HouseInfo houseInfo, HttpServletResponse response) throws IOException {
      int in = houseInfoService.insert(houseInfo);
        if(in >0){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("<script>alert('添加成功')</script>");
            writer.flush();
            writer.close();
        }else{
            throw new RuntimeException("新增异常");
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping ("/getHouseInfoList")
    @ResponseBody
    public List<HouseInfo> getHouseInfoList(){
        List<HouseInfo> houseInfos=houseInfoService.getHouseInfoList();
        return houseInfos;
    }

    /**
     * 通过房屋类型查询
     * @param id
     * @return
     */
    @GetMapping("/getHouseInfoById")
    @ResponseBody
    public HouseInfo getHouseInfoById(@RequestParam Long id){
        return houseInfoService.getHouseInfoById(id);
    }

    /**
     * 获取户型
     * @return
     */
    @GetMapping("/getTypeList")
    @ResponseBody
    public List<HouseType>  getTypeList(){
        List<HouseType> list= houseInfoService.getTypeList();
        return list;
    }

}

