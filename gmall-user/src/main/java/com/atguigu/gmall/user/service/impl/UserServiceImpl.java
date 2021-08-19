package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.service.UserService;//gmall-api
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Author : SunJun
 * @email : sunjun0207@163.com
 * @create 2020/12/30 20:56
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;
  @Autowired
  UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

  @Override
  public List<UmsMember> getAllUser() {
    List<UmsMember> umsMemberList = userMapper.selectAll(); //userMapper.selectAllUser();
    return umsMemberList;
  }

  @Override
  public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
    //高级写法
    Example e = new Example(UmsMemberReceiveAddress.class);
    e.createCriteria().andEqualTo("memberId", memberId);
    List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(e);

    //普通写法
//    UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
//    umsMemberReceiveAddress.setMemberId(memberId);
//    List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
    return umsMemberReceiveAddresses;
  }

  @Override
  public String removeReceiveAddressById(String id) {
    int i = umsMemberReceiveAddressMapper.deleteByPrimaryKey(id);
    if(i != 0){
      return "根据id删除MemberReceiveAddress信息成功!!!";
    }else{
      return "根据id删除MemberReceiveAddress信息失败!!!";
    }
  }

  @Override
  public String modificationReceiveAddressById(UmsMemberReceiveAddress umsMemberReceiveAddress) {
    int i = umsMemberReceiveAddressMapper.updateByPrimaryKey(umsMemberReceiveAddress);
    if(i != 0){
      return "根据memberId修改ReceiveAddress成功!!!";
    }else{
      return "根据memberId修改ReceiveAddress失败!!!";
    }
  }

  @Override
  public String addReceiveAddressByMemberId(UmsMemberReceiveAddress umsMemberReceiveAddress) {
    int i = umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);
    if(i == 0){
      return "根据memberId新增ReceiveAddress失败!!!";
    }else{
      return "根据memberId新增ReceiveAddress成功!!!";
    }
  }

  @Override
  public List<UmsMemberReceiveAddress> getAllReceiveAddress() {
    List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectAll();
    return umsMemberReceiveAddresses;
  }

  @Override
  public String removeById(String id) {
    Example e = new Example(UmsMember.class);
    e.createCriteria().andEqualTo("id", id);
    int i = userMapper.deleteByExample(e);
    if(i != 0){
      return "根据id删除User信息成功!!!";
    }else{
      return "根据id删除User信息失败!!!";
    }
  }

  @Override
  public String modificationUserById(UmsMember umsMember) {
    umsMember.setCreateTime(new Date());
    int i = userMapper.updateByPrimaryKey(umsMember);
    if(i != 0){
      return "根据id修改User成功!!!";
    }else{
      return "根据id修改User失败!!!";
    }

  }

  @Override
  public String addUser(UmsMember umsMember) {
    umsMember.setCreateTime(new Date());
    int flag = userMapper.insert(umsMember);
    if(flag == 0){
      return "新增user失败！！";
    }else{
      return "新增user成功！！";
    }
  }

  @Override
  public UmsMember getUserById(String id) {
    UmsMember umsMember = new UmsMember();
    umsMember.setId(id);
    UmsMember one = userMapper.selectOne(umsMember);
    return one;
  }
}
