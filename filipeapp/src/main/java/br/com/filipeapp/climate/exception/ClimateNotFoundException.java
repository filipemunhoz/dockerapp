package br.com.filipeapp.climate.exception;

public class ClimateNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 3758385277834443817L;

	public ClimateNotFoundException(Long id) {
        super("Climate id not found : " + id);
    }
}
