package pe.com.microservice.core.exception;

import org.springframework.http.HttpStatus;

public class BooxException extends Exception{
	
	private static final long serialVersionUID = 3880261424308084607L;
		
	protected String exceptionCode = null;	
	protected String exceptionId = null;	
	protected HttpStatus httpStatus;
		
    public BooxException(String message) {
        super(message);
        setExceptionId(CodeGeneratorUtil.generateCode());
    }

    public BooxException(String message, Throwable cause) {
        super(message, cause);
        this.setExceptionId(CodeGeneratorUtil.generateCode());
    }
	    
    public BooxException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.exceptionId = CodeGeneratorUtil.generateCode();
        this.exceptionCode = errorCode;
    }
	    
    public BooxException(String errorCode, String message) {
        super(message);
        this.exceptionId = CodeGeneratorUtil.generateCode();
        this.exceptionCode = errorCode;
    }
	    
   	public BooxException(Throwable cause) {
		super(cause);
		setExceptionId(CodeGeneratorUtil.generateCode());
	}
	   	
   	public BooxException(HttpStatus httpStatus) {		
   		this.httpStatus = HttpStatus.NOT_FOUND;
	}
	   	
    public Throwable fetchRootCause() {
        return ExceptionUtil.fetchRootCause(this);
    }

    public String fetchRootCauseMessage() {
        return fetchRootCause().getMessage();
    }
	    
    public String toString(Throwable aThrowable) {
		return ExceptionUtil.toString(aThrowable);
	}
	   	
    public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(String exceptionId) {
		this.exceptionId = exceptionId;
	}
		
}