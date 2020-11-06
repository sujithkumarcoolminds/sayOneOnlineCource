package com.sayone.online.controller;

import com.sayone.online.modal.OnlineCourse;
import com.sayone.online.modal.Response;
import com.sayone.online.service.OnlineCourceService;
import com.sayone.online.utils.Constants;
import com.sayone.online.utils.ResponseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sayone")
public class OnlineCourceController {

    private static final Logger LOGGER = LogManager.getLogger(OnlineCourceController.class);

    @Autowired
    OnlineCourceService onlineCourceService;

    @GetMapping(value = "/online-courses/{country_code}/courses/{course_id}")
    public Map<String,Object> getCourseDetails(@PathVariable("course_id") Integer courseId, @PathVariable("country_code") String countryCode){

        LOGGER.debug("ENTER: OnlineCourceController#getCourseDetails");
        OnlineCourse onlineCourse=null;
        try {
               // dcData = dcService.getDCData(filters);

            LOGGER.info("Insinde tryyy>>>>>>>>"+courseId +"-----------"+countryCode);
            onlineCourse =  onlineCourceService.getOnlineCourceDetails(courseId,countryCode);

        } catch (Exception e) {
            LOGGER.error(Constants.DATA_ERROR,e);
            return ResponseUtils.convertObjectToMap(new Response(Constants.HTTP_ERROR,Constants.DATA_ERROR));
        }
        LOGGER.debug("EXIT: OnlineCourceController#getCourseDetails");
        return ResponseUtils.convertObjectToMap(new Response(Constants.HTTP_OK,onlineCourse));

    }


}
