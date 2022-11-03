package com.example.purplepeople.service;

import com.example.purplepeople.domain.Grant;
import com.example.purplepeople.domain.Schedule;

public interface GrantService {
    public void register(Grant grant);
    public void delete(Long idx);
}