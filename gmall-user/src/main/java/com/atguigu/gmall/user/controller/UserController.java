package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : SunJun
 * @email : sunjun0207@163.com
 * @create 2020/12/30 20:55
 */
@Controller
public class UserController {

  @Autowired
  UserService userService;

  //根据Id删除用户收获地址
  @RequestMapping(value = "removeReceiveAddressById", method = RequestMethod.POST)
  @ResponseBody
  public String removeReceiveAddressById(@RequestParam("id") String id){
    String result = userService.removeReceiveAddressById(id);
    return result;
  }

  //根据Id修改用户收获地址
  @RequestMapping(value = "modificationReceiveAddressById", method = RequestMethod.POST)
  @ResponseBody
  public String modificationReceiveAddressById(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){
    String result = userService.modificationReceiveAddressById(umsMemberReceiveAddress);
    return result;
  }

  //根据memberId新增用户收货地址
  @RequestMapping(value = "addReceiveAddressByMemberId", method = RequestMethod.POST)
  @ResponseBody
  public String addReceiveAddressByMemberId(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){
    String result = userService.addReceiveAddressByMemberId(umsMemberReceiveAddress);
    return result;
  }

  //根据memberId查询用户收获地址
  @RequestMapping("getReceiveAddressByMemberId")
  @ResponseBody
  public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@RequestParam("memberId") String memberId){
    List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
    return umsMemberReceiveAddresses;
  }
  //查询所有用户收获地址
  @RequestMapping(value = "getAllReceiveAddress", method = RequestMethod.GET)
  @ResponseBody
  public List<UmsMemberReceiveAddress> getAllReceiveAddress(){
    return userService.getAllReceiveAddress();
  }


  //根据id删除用户信息
  @RequestMapping(value = "removeById", method = RequestMethod.GET)
  @ResponseBody
  public String removeById(@RequestParam("id") String id){
    String result = userService.removeById(id);
    return result;
  }

  //根据id修改用户信息
  @RequestMapping(value = "modificationUserById", method = RequestMethod.POST)
  @ResponseBody
  public String modificationUserById(@RequestBody UmsMember umsMember){
    String result = userService.modificationUserById(umsMember);
    return result;
  }
  //新增用户
  @RequestMapping(value = "addUser", method = RequestMethod.POST)
  @ResponseBody
  public String addUser(@RequestBody UmsMember umsMember){
    String result = userService.addUser(umsMember);
    return result;
  }

  //根据id查询用户信息
  @RequestMapping("getUserById")
  @ResponseBody
  public UmsMember getUserById(@RequestParam("id") String id){
    UmsMember umsMember = userService.getUserById(id);
    return umsMember;
  }
  //查询所有用户信息
  @RequestMapping("getAllUser")
  @ResponseBody
  public List<UmsMember> getAllUser(){
    List<UmsMember> umsMembers = userService.getAllUser();
    return umsMembers;
  }
  //测试
  @RequestMapping("index")
  @ResponseBody
  public String index(){
    return "hello user";
  }
}
