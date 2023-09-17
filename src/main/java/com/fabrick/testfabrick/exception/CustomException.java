package com.fabrick.testfabrick.exception;

import lombok.Data;
import org.springframework.web.client.HttpClientErrorException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.commons.lang3.StringUtils;

@Data
public class CustomException extends RuntimeException {

    private String errorCode;
    private String message;

    public CustomException() {
        super();
        this.errorCode = ERROR.GEN_ERR.getCode();
        this.message = ERROR.GEN_ERR.getMessage();
    }

    public CustomException(HttpClientErrorException e) {
        super();
        setParams(e);
    }

    private void setParams(HttpClientErrorException e) {
        String msg = e.getMessage();
        if(msg.contains("<EOL>")) {
            msg = msg.replace("<EOL>", "");
            msg = msg.replace("?", "");
            msg = msg.substring(msg.indexOf("{"), msg.length() - 1);

            JSONObject obj = new JSONObject(msg);
            JSONArray errors = obj.getJSONArray("errors");

            JSONObject error = errors.getJSONObject(0);
            String code = error.getString("code");

            if (StringUtils.isNotBlank(code)) {
                this.errorCode = code;
                this.message = error.getString("description");
            } else {
                this.errorCode = ERROR.GEN_ERR.getCode();
                this.message = ERROR.GEN_ERR.getMessage();
            }
        }else{
            this.errorCode = ERROR.GEN_ERR.getCode();
            this.message = ERROR.GEN_ERR.getMessage();
        }
    }
}
