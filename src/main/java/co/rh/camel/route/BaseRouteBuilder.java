package co.rh.camel.route;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.rh.camel.common.FailOverProcesser;

@Component
public abstract class BaseRouteBuilder extends RouteBuilder {
	
	@Resource
	public FailOverProcesser fallOutputProcesser;
	
	public BaseRouteBuilder() {
		super();
	}
	
	
	
	@Value("${camel.component.servlet.mapping.contextPath}")
	private String contextPath;
	
	@Value("${server.port}")
	private String port;
	
	protected final void init() {
		
		onException(Throwable.class).process(fallOutputProcesser).logHandled(true)
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(500)).handled(true);
		
//		restConfiguration().component("netty4-http").bindingMode(RestBindingMode.json)
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
		.dataFormatProperty("prettyPrint", "true").apiContextPath("/api-doc")
		.apiProperty("api.title", "REST Pay API").apiProperty("api.version", "1.0.0").apiProperty("cors", "true")
		.host("localhost").port(port).apiContextPath(contextPath)
		
		;
	
	}
	
}
