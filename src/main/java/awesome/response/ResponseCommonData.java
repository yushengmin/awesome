package awesome.response;


import awesome.common.ApiServiceException;
import awesome.common.Code;
import awesome.common.Err;

public class ResponseCommonData<T> {

    private int status;
    private boolean islogin;
    private String msg;
    private T data;

    public ResponseCommonData(T data) {
        this.status = Code.API_STATUS_NAOMAL;
        this.islogin=true;
        this.data = data;
    }

    public ResponseCommonData() {
        this.status = Code.API_STATUS_NAOMAL;
        this.islogin=true;
        this.data = null;
    }

    public ResponseCommonData(Err err) {
        this.status =err.getErrCode();
        this.msg = err.getErrMsg();
        this.islogin=true;

    }

    public ResponseCommonData(ApiServiceException e) {
        this.status = Code.API_STATUS_ERROR;
        this.msg = e.getErrMsg();
        this.islogin=true;

    }

    public ResponseCommonData(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.islogin=true;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isIslogin() {
        return islogin;
    }

    public void setIslogin(boolean islogin) {
        this.islogin = islogin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseCommonData1{" +
                "status=" + status +
                ", islogin=" + islogin +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
