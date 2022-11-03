package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.Grant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GrantMapper {
    /**
     * 허가여부를 등록한다.
     *
     * @param grant grant
     */
    public void register(Grant grant);
    /**
     * 허가여부를 삭제한다.
     *
     * @param idx idx
     */
    public void delete(Long idx);
}
