package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.User;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 주어진 유저 코드를 가진 사용자 정보를 되돌린다.
     *
     * @param idx idx
     * @return 사용자 정보
     */
    public User get(@Param("idx") Long idx);

    /**
     * 주어진 사원번호를 가진 사용자 정보를 되돌린다.
     *
     * @param empnum empnum
     * @return 사용자 정보
     */
    public User getByEmpnum(@Param("empnum") String empnum);
    /**
     * 주어진 이름을 가진 사용자 정보를 되돌린다.
     *
     * @param name name
     * @return 사용자 정보
     */
    public User getByName(@Param("name") String name);

    /**
     * 사용자를 등록한다.
     *
     * @param user 사용자 정보
     * @return 등록된 사용자의 idx
     */
    public int register(User user);
}
