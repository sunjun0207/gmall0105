package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author : SunJun
 * @email : sunjun0207@163.com
 * @create 2020/12/30 21:00
 */

public interface UserMapper extends Mapper<UmsMember> {
  List<UmsMember> selectAllUser();
}
