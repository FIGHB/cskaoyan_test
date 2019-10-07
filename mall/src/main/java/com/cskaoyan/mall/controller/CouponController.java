package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.CouponUser;
import com.cskaoyan.mall.service.CouponService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    CouponService couponService;

    @RequestMapping("/admin/coupon/list")
    @RequiresPermissions("admin:coupon:list")
    public BaseRespVo couponList(int page, int limit, Coupon coupon){
        BaseRespVo baseRespVo = couponService.queryCouponByCondition(page,limit,coupon);
        return baseRespVo;
    }

    @RequestMapping("/admin/coupon/delete")
    @RequiresPermissions("admin:coupon:delete")
    public BaseRespVo delete(@RequestBody Coupon coupon){
        BaseRespVo delete = couponService.delete(coupon);
        return delete;
    }

    @RequestMapping("/admin/coupon/read")
    @RequiresPermissions("admin:coupon:read")
    public BaseRespVo read(int id){
        BaseRespVo read = couponService.read(id);
        return read;
    }

    @RequestMapping("/admin/coupon/listuser")
    @RequiresPermissions("admin:coupon:listuser")
    public BaseRespVo listuser(int page, int limit, CouponUser couponUser){
        BaseRespVo baseRespVo = couponService.queryCouponUserByCondition(page, limit, couponUser);
        return baseRespVo;
    }

    @RequestMapping("/admin/coupon/create")
    @RequiresPermissions("admin:coupon:create")
    public BaseRespVo create(@RequestBody Coupon coupon){
        BaseRespVo insert = couponService.insert(coupon);
        return insert;
    }

}
