package com.example.purplepeople.mapper;

import com.example.purplepeople.domain.User;
import org.apache.ibatis.annotations.Mapper;
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
     * @return 등록된 사용자의 번호
     */
    public int register(User user);
    /**
     * 동일번호를 가진 계정으로 로그인한다.
     *
     * @param empnum empnum
     * @return 등록된 사용자의 정보
     */
    public User login(@Param("empnum") String empnum);
    /**
     * 동일번호를 가진 계정을 가입 허가한다.
     *
     * @param empnum empnum, key key
     * @return idx
     */
    public int accessEdit(String empnum, char key);

}
