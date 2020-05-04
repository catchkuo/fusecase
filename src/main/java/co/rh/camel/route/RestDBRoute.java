package co.rh.camel.route;

import org.springframework.stereotype.Component;

import co.rh.camel.process.SysoutProcessor;

@Component
public class RestDBRoute extends BaseRouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		super.init();
//		 #access formatting http://localhost:8080/case/api/selectByBean
		rest("/api/").description("Case REST service").consumes("application/json").produces("application/json")
		.get("/selectByBean").to("mybatis-bean:IGroupDAO:selectById")
			
		.get("/selectByBean/{id}").to("direct:mylog")
		
		
		.get("/selectById").to("mybatis:selectGroups?statementType=SelectOne");
		
		SysoutProcessor s = new SysoutProcessor();

		from("direct:mylog").log("Processing $simple{in.header.id}").to("mybatis-bean:IGroupDAO:selectId?inputHeader=id");
		 
	
		
	
	}

}