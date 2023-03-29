package ru.skfl.socketgames.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardResponse implements Serializable {
    private ResponseInfo responseInfo;

    public StandardResponse() {
        setResponseInfo(ResponseInfo.getInstance());
    }

    public StandardResponse(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
