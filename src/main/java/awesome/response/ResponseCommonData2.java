package awesome.response;


import awesome.common.ApiServiceException;
import awesome.common.Code;
import awesome.common.Err;

public class ResponseCommonData2<T> {

    private int status;
    private int errCode;
    private String msg;
    private T data;

    public ResponseCommonData2(T data) {
        this.status = Code.API_STATUS_NAOMAL;
        this.data = data;
    }

    public ResponseCommonData2() {
        this.status = Code.API_STATUS_NAOMAL;
        this.data = null;
    }

    public ResponseCommonData2(Err err) {
        this.status = Code.API_STATUS_ERROR;
        this.errCode = err.getErrCode();
        this.msg = err.getErrMsg();
    }
    
    public ResponseCommonData2(ApiServiceException e) {
        this.status = Code.API_STATUS_ERROR;
        this.errCode = e.getErrCode();
        this.msg = e.getErrMsg();
    }
    

    public ResponseCommonData2(int errCode, String errMsg) {
        this.status = Code.API_STATUS_ERROR;
        this.errCode = errCode;
        this.msg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return msg;
    }

    public void setErrMsg(String errMsg) {
        this.msg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
		return status;
	}

	@Override
    public String toString() {
        return "ResponseCommonData{" +
                "status=" + status +
                ", errCode=" + errCode +
                ", errMsg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
