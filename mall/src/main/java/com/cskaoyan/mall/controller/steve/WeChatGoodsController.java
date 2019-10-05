package com.cskaoyan.mall.controller.steve;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.service.steve.WechatGoodsServices;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.steve.BrandListVo;
import com.cskaoyan.mall.vo.steve.WeChatCategoryVo;
import com.cskaoyan.mall.vo.steve.WeChatGoodsReceiveData;
import com.cskaoyan.mall.vo.steve.WechatGoodsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steve
 * @date 2019/10/5-14:08
 */
@RestController
public class WeChatGoodsController {

    @Autowired
    WechatGoodsServices wechatGoodsServices;

    @RequestMapping("wx/goods/list")
    public BaseRespVo weChatGoodsList(WeChatGoodsReceiveData weChatGoodsReceiveData){
        //后续这里要修改 这里要通过token查出来userneme,后面需要根据username来查出来userId
        String username = "steve";

        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();

        WechatGoodsList wechatGoodsList = wechatGoodsServices.queryWeChatGoodsList(weChatGoodsReceiveData, username);

        BaseRespVo baseRespVo = BaseRespVo.ok(wechatGoodsList);
        return baseRespVo;
    }

    @RequestMapping("wx/goods/category")
    public BaseRespVo weChatCategoryList(Category category){
        int id = category.getId();

        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();

        WeChatCategoryVo weChatCategoryVo = wechatGoodsServices.queryCategoryList(id);

        BaseRespVo baseRespVo = BaseRespVo.ok(weChatCategoryVo);
        return baseRespVo;
    }

}
