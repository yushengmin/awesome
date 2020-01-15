package awesome.common;

/**
 * Created by sundm on 15/6/27.
 */
public class ApiServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3433886233063314339L;
	private int errCode;
	private String errMsg;

	public ApiServiceException(Err err) {
		this.errCode = err.getErrCode();
		this.errMsg = err.getErrMsg();
	}

	public ApiServiceException(int errCode, String errMsg) {
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
