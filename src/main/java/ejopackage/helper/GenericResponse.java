package ejopackage.helper;

public class GenericResponse  <T,I> {
    private boolean status;
    private I  responseid;
    private String  responsemessage;
    private T    data;

	public GenericResponse() {
	
	}

	
	public GenericResponse(boolean status, I responseid, String responsemessage, T data) {
		super();
		this.status = status;
		this.responseid = responseid;
		this.responsemessage = responsemessage;
		this.data = data;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getResponsemessage() {
		return responsemessage;
	}

	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}

	public I getResponseid() {
		return responseid;
	}

	public void setResponseid(I responseid) {
		this.responseid = responseid;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	

}
