package com.example.purplepeople.service;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Grant;

public interface CauseService {
    public void register(Cause cause);
    public void delete(Long idx);
}