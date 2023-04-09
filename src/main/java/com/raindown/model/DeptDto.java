package com.raindown.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class DeptDto {
        private String deptId;
        private Long count;

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public static List<DeptDto> getListDeptDto(Map<String, Long> map){
            ArrayList<DeptDto> list = new ArrayList<>();
            for (String s: map.keySet()){
                DeptDto deptDto = new DeptDto();
                deptDto.setDeptId(s);
                deptDto.setCount(map.get(s));
                list.add(deptDto);
            }
            return list;
        }
    }