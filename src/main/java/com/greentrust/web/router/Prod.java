package com.greentrust.web.router;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-02 16:40
 */
@RestController
@RequestMapping("/prod")
public class Prod extends Cors {
     
    private String tempStr = "prod";
    private static final Logger logger = LogManager.getLogger(Prod.class);

    /*
     * @description:获取商品的详情
     * @author Yangk.
     * @date 2018/4/2 16:39
     * @param
     * @return
     */
    @GetMapping("/detial/{id}")
    public String getProdDetial(@PathVariable("id") int prodid){

        logger.info("info execute index method");
        logger.warn("warn execute index method");
        logger.error("error execute index method");

        return tempStr + "proddetial" + prodid ;

    }
     /*
      * @description:获取商品列表
      * @author Yangk.
      * @date 2018/4/2 16:32
      * @param
      * @return
      */
    @GetMapping("/getlist")
    public String getProdList(){
        return tempStr + "getlist" ;
    }

}
