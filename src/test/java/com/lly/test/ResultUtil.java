package com.lly.test;

import lombok.Data;

/**
 * @author lyluo
 */
public class ResultUtil {

    public static JsonResult success() {
        JsonResult result = new JsonResult();
//        result.setCode(ResultCode.SUCCESS.code());
//        result.setMsg(ResultCode.SUCCESS.message());
        return result;
    }

    public static JsonResult success(Object object) {
        JsonResult result = new JsonResult();
//        result.setCode(ResultCode.SUCCESS.code());
//        result.setMsg(ResultCode.SUCCESS.message());
        result.setData(object);
        return result;
    }

    public static JsonResult error(Object object) {
        JsonResult result = new JsonResult();
//        result.setCode(ResultCode.SYSTEM_INNER_ERROR.code());
//        result.setMsg(ResultCode.SYSTEM_INNER_ERROR.message());
        result.setData(object);
        return result;
    }

    public static JsonResult error(String message) {
        JsonResult result = new JsonResult();
//        result.setCode(ResultCode.INTERFACE_INNER_INVOKE_ERROR.code());
        result.setMsg(message);
        return result;
    }

    @Data
    public static class JsonResult {
        /*错误码*/
        private Integer code;
        /*提示信息*/
        private String msg;
        /*具体的内容*/
        private Object data;

        public JsonResult() {

        }

        public JsonResult(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public JsonResult(Integer code, String msg, Object data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

}
