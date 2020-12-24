package org.lalajiang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    public Boolean login(String name, String pwd, String yhip, String yhdz, String yhzd) {
        if ("xiaohu".equals(name) && "0817".equals(pwd)) {
            log.info(yhip + "用户在" + yhdz + "使用" + yhzd + "登陆成功！");
            return true;
        }
        log.info(yhip + "用户在" + yhdz + "使用" + yhzd + "登陆失败！");
        return false;
    }
}
