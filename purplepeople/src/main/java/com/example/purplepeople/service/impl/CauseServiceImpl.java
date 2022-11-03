package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Grant;
import com.example.purplepeople.mapper.CauseMapper;
import com.example.purplepeople.mapper.GrantMapper;
import com.example.purplepeople.service.CauseService;
import com.example.purplepeople.service.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CauseServiceImpl implements CauseService {

    @Autowired
    private CauseMapper causeMapper;

    @Override
    public void register(Cause cause) {
        causeMapper.register(cause);
    }
    @Override
    public void delete(Long idx) {
        causeMapper.delete(idx);
    }
}
