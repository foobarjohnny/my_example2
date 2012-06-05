package ilife.common.controller;

import ilife.common.dao.GenericDao;
import ilife.common.model.Feedback;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedbackController {
    private GenericDao<Feedback, Serializable> genericDao;

    @RequestMapping("/feedback")
    public String addFeedback(ModelMap map){
        Feedback fb = (Feedback) map.get("feedback");
        genericDao.save(fb);
        return "";
    }
    
}
