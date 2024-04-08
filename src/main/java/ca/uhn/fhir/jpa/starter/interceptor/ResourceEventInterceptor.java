package ca.uhn.fhir.jpa.starter.interceptor;

import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.servlet.ServletRequestDetails;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;

/**
 * This method is called just before the actual implementing server method is invoked.
 */
@Component
@Interceptor
public class ResourceEventInterceptor {

	@Hook(Pointcut.SERVER_INCOMING_REQUEST_POST_PROCESSED)
	public void incomingRequestPreProcessed(RequestDetails requestDetails) {
		ServletRequestDetails servletRequestDetails = (ServletRequestDetails) requestDetails;
		HttpServletRequest request = servletRequestDetails.getServletRequest();
		System.out.println("RawRequestInterceptor.incomingRequestPreProcessed: " + request.getMethod() + " " + request.getRequestURI());
	}
}