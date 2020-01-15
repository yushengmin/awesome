package awesome.common;


public enum Err {


    /**
     * 登录异常
     */
    LOGIN_ERR_ERR(210,"用户不存在或密码错误"),
    LOGIN_ERR_TOKEN_ERR(211,"token丢失"),
    MODIFI_PASSWORD_ERR(212,"密码错误"),
    TOKEN_DISABLE_ERR(213,"token错误");

	
    private final int errCode;
    private final String errMsg;

    Err(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

}
