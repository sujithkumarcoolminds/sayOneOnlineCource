package com.sayone.online.service;

import com.sayone.online.dao.*;
import com.sayone.online.entity.Country;
import com.sayone.online.entity.Course;
import com.sayone.online.entity.CourseComponent;
import com.sayone.online.entity.StrategiesOption;
import com.sayone.online.modal.OnlineCourse;
import com.sayone.online.modal.PriceComponentsModal;
import com.sayone.online.modal.PriceStrategiesModal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OnlineCourceServiceImpl implements OnlineCourceService{

    private static final Logger LOGGER = LogManager.getLogger(OnlineCourceServiceImpl.class);

    @Autowired
    CountryDAO countryDAO;
    @Autowired
    CourceComponentDAO courceComponentDAO;
    @Autowired
    CourceDAO courceDAO;

    @Autowired
    StrategiesOptionDAO strategiesOptionDAO;

    @Override
    public OnlineCourse getOnlineCourceDetails(Integer courseId, String countryCode) throws Exception {

        LOGGER.debug("---------Inside getOnlineCourceDetails-----------");
        OnlineCourse onlineCourse = new OnlineCourse();
        if(courseId !=0 && !countryCode.isEmpty()){

            Country country = countryDAO.findByCode(countryCode);
            Optional<Course> optionalValue= courceDAO.findById(courseId);
            Course course = new Course(optionalValue);

            List<CourseComponent> courseComponentList = courceComponentDAO.findByCourseAndCountry(course,country);
            List<StrategiesOption> strategiesOptions = strategiesOptionDAO.findByCourse(course);

            onlineCourse.setCourseId(course.getCourseId());
            onlineCourse.setCourseName(course.getName());
            onlineCourse.setCourseDescription(course.getDescription());
            onlineCourse.setPriceComponents(getPriceComponent(courseComponentList));
            onlineCourse.setPriceStrategies(getPriceStrategies(strategiesOptions));

            BigDecimal totalPrice=BigDecimal.valueOf(0);
            for(PriceComponentsModal priceComponentsModal:onlineCourse.getPriceComponents()){
                totalPrice =  totalPrice.add(priceComponentsModal.getValue());
            }
            onlineCourse.setTotalPrice(totalPrice);

        }else{
            LOGGER.error("We have missing values");
        }

        return onlineCourse;
    }


    private  List<PriceComponentsModal>  getPriceComponent( List<CourseComponent> courseComponentList){

       return courseComponentList.stream().map(element -> toPriceComponent(element)).collect(Collectors.toList());
    }

    private PriceComponentsModal toPriceComponent(CourseComponent courseComponent){
        PriceComponentsModal convertTemp = new PriceComponentsModal();
        convertTemp.setId(courseComponent.getId());
        convertTemp.setName(courseComponent.getComponentValue().getComponentId().getName());
        convertTemp.setValue(courseComponent.getComponentValue().getValue());

        return convertTemp;
    }

    private  List<PriceStrategiesModal>  getPriceStrategies(List<StrategiesOption> StrategiesOption){

        return StrategiesOption.stream().map(element -> toPriceStrategies(element)).collect(Collectors.toList());
    }

    private PriceStrategiesModal toPriceStrategies(StrategiesOption strategiesOption){
        PriceStrategiesModal convertTemp = new PriceStrategiesModal();
        convertTemp.setStrategyID(strategiesOption.getId());
        convertTemp.setName(strategiesOption.getPriceStrategy().getName());
        convertTemp.setDuration(strategiesOption.getDurationInMonths());
        return convertTemp;
    }

}
