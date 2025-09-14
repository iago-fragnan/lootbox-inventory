package dev.iagof.lootbox.helpers;

import dev.iagof.lootbox.enumerables.RequestStatus;
import dev.iagof.lootbox.models.RequestModel;

public class RequestResponse {

    RequestModel requestModel;

    public RequestResponse() {
        requestModel = new RequestModel();
    }

    public RequestModel getRequestModel() {
        return requestModel;
    }

    public RequestModel SetSuccess(String code, Object data){
        this.requestModel.setRequestStatus(RequestStatus.success);
        this.requestModel.setCode(code);
        this.requestModel.setData(data);
        return this.requestModel;
    }

    public RequestModel SetFailed(String code, String message){
        this.requestModel.setRequestStatus(RequestStatus.error);
        this.requestModel.setMessage(message);
        this.requestModel.setCode(code);
        return this.requestModel;
    }


}
