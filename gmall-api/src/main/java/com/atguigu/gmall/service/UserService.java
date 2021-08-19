package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @Author : SunJun
 * @email : sunjun0207@163.com
 * @create 2020/12/30 20:55
 */
public interface UserService {
  String addReceiveAddressByMemberId(UmsMemberReceiveAddress umsMemberReceiveAddress);

  String addUser(UmsMember umsMember);

  List<UmsMemberReceiveAddress> getAllReceiveAddress();

  List<UmsMember> getAllUser();

  List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

  UmsMember getUserById(String id);

  String modificationReceiveAddressById(UmsMemberReceiveAddress umsMemberReceiveAddress);

  String modificationUserById(UmsMember umsMember);

  String removeById(String id);

  String removeReceiveAddressById(String id);
}
