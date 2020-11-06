package com.sayone.online.service;

import com.sayone.online.modal.OnlineCourse;
import org.springframework.stereotype.Service;

@Service
public interface OnlineCourceService {

    public OnlineCourse getOnlineCourceDetails(Integer courseId, String countryCode) throws Exception;
}
