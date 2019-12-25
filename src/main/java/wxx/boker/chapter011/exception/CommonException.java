package wxx.boker.chapter011.exception;

public class CommonException extends  RuntimeException{

    private String errorCode;

    private String errorMsg;

    CommonException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    CommonException(CommonErrorCode commonErrorCode){
        super(commonErrorCode.getErrorMessg());
        this.errorCode = commonErrorCode.getErrorCode();
        this.errorMsg = commonErrorCode.getErrorMessg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
