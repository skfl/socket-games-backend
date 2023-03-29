package ru.skfl.socketgames.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResponseInfo implements Serializable {

    private ResultCode resultCode;
    private String id;
    private String message;
    private String systemMessage;

    public ResponseInfo(ResultCode resultCode, String info, String message, String systemMessage) {
        this.resultCode = resultCode;
        this.id = info;
        this.message = message;
        this.systemMessage = systemMessage;
    }

    public static ResponseInfo getInstance() {
        return getInstance(ResultCode.OK, null, null );
    }

    public static ResponseInfo getInstance(ResultCode resultCode) {
        return getInstance(resultCode, null, null);
    }

    public static ResponseInfo getInstance(ResultCode resultCode,String message) {
        return getInstance(resultCode, message, null);
    }

    public static ResponseInfo getInstance(ResultCode resultCode, String message, String systemMessage) {
        return new ResponseInfo(resultCode, UUID.randomUUID().toString(), message, systemMessage);
    }
}
