package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.Cause;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {
    /**
     * 사원의 권한을 확인한다.
     *
     * @param empnum empnum
     */
    public String getManager(String empnum);
}
