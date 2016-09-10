/**
 * 
 */
package com.maacsport.controllers;

/**
 * @author maaguilera
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.maacsport.service.PriceIncrease;
import com.maacsport.service.LogicManager;
import com.maacsport.service.LogicManagerImpl;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private LogicManagerImpl logicManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        logicManager.increasePrice(increase);

        return "redirect:/reservations.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject(HttpServletRequest request) throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public void setProductManager(LogicManagerImpl productManager) {
        this.logicManager = productManager;
    }

    public LogicManagerImpl getProductManager() {
        return logicManager;
    }

}