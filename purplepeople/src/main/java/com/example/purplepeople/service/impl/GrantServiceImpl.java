package com.example.purplepeople.service.impl;

import com.example.purplepeople.domain.Grant;
import com.example.purplepeople.mapper.GrantMapper;
import com.example.purplepeople.service.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrantServiceImpl implements GrantService {

    @Autowired
    private GrantMapper grantMapper;

    @Override
    public void register(Grant grant) {
        grantMapper.register(grant);
    }
    @Override
    public void delete(Long idx) {
        grantMapper.delete(idx);
    }
}
