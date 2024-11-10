package com.raindown.service.collections;

import com.raindown.model.DeptDto;
import com.raindown.model.UserDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author: RainDown
 * @date: 2023/4/9 0:13
 * @version: 1.0
 */
public class AllList {

    public static void main(String[] args) {


        UserDO.UserDOBuilder userDOBuilder = UserDO.builder().userId("U100").userName("test");
        UserDO user = userDOBuilder.build();
        System.out.println(user);

    }

    public void stream() {

        ArrayList<UserDO> list = new ArrayList();

        //groupingBy   根据deptId分组并将map的values变为计数值
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(UserDO::getDeptId, Collectors.counting()));

        //collectingAndThen   先对着数据进行处理得到结果1  然后对结果1的类型处理并返回方法2的类型
        List<DeptDto> deptDos = list.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(UserDO::getDeptId, Collectors.counting()), DeptDto::getListDeptDto));

    }
}
