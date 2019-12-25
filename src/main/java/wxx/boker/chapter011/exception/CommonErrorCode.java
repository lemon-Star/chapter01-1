package wxx.boker.chapter011.exception;

public enum CommonErrorCode {

    PARAMENTER_EXCEPTION("10001","参数错误");

    private String errorCode;

    private String errorMessg;

    CommonErrorCode(String errorCode,String errorMessg){
        this.errorCode=errorCode;
        this.errorMessg=errorMessg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessg() {
        return errorMessg;
    }

    public void setErrorMessg(String errorMessg) {
        this.errorMessg = errorMessg;
    }
}
