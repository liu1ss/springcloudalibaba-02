package com.aaa.controller;

import com.aaa.entity.Account;
import com.aaa.entity.ReturnData;
import com.aaa.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Value("${my.jwt.effective-time}")
    private String effectiveTime;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("login")
    @ResponseBody
    @CrossOrigin
    public ReturnData<String> login(Account account) throws Exception {
        // Account ac=this.authService.getJwtUser(account);//自定义验证前端传过来的用户名密码是否正确，使用者自行修改。

        if (account.getUsername().equals("admin") && account.getPassword().equals("admin")) {
            int effectivTimeInt = Integer.valueOf(effectiveTime.substring(0, effectiveTime.length() - 1));
            String effectivTimeUnit = effectiveTime.substring(effectiveTime.length() - 1, effectiveTime.length());
            String jwt = null;
            switch (effectivTimeUnit) {
                case "s": {
                    //秒
                    jwt = JwtUtil.createJWT("qmy", "0339", objectMapper.writeValueAsString(account), effectivTimeInt * 1000L);
                    break;
                }
                case "m": {
                    //分钟
                    jwt = JwtUtil.createJWT("qmy", "0339", objectMapper.writeValueAsString(account), effectivTimeInt * 60L * 1000L);
                    break;
                }
                case "h": {
                    //小时
                    jwt = JwtUtil.createJWT("qmy", "0339", objectMapper.writeValueAsString(account), effectivTimeInt * 60L * 60L * 1000L);
                    break;
                }
                case "d": {
                    //小时
                    jwt = JwtUtil.createJWT("qmy", "0339", objectMapper.writeValueAsString(account), effectivTimeInt * 24L * 60L * 60L * 1000L);
                    break;
                }
            }
            return new ReturnData<String>(200, "认证成功", jwt);
        } else {
            return new ReturnData<String>(401, "认证失败，用户名或密码错误，请重新输入", null);
        }

    }


}
