package hello.templates.classes.bodies.SOAP;

public class System_num_bodies_T {

    public String getBodyMethod(){
        return  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
                "	<SOAP-ENV:Header/>"+
                "	<SOAP-ENV:Body>"+
                "		<ns2:SendMessageBySMS_Rs xmlns:ns2=\"http://www.vtb24.ru/ApplicationObjectLibrary/BO/schemas/Requesters/NotificationBOReqA/V1\">"+
                "			<ns2:Header CorrelationUID=\"12345678987654321\" ErrorCode=\"\" MessageId=\"18d09c13-31dc-4251-9fd1-56b3c0c76209-resp\" SystemFrom=\"STUB\" SystemTo=\"?\"/>"+
                "		</ns2:SendMessageBySMS_Rs>"+
                "	</SOAP-ENV:Body>"+
                "</SOAP-ENV:Envelope>";
    }
}
