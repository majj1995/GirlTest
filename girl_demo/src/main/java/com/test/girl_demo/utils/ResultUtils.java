package com.test.girl_demo.utils;

import com.test.girl_demo.domain.Result;

public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setData(object);
        result.setMsg("成功");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
