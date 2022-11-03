package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Grant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CauseMapper {
    /**
     * 사유를 등록한다.
     *
     * @param cuase cuase
     */
    public void register(Cause cuase);
    /**
     * 사유를 삭제한다.
     *
     * @param idx idx
     */
    public void delete(Long idx);
}
