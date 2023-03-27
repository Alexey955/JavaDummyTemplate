package hello.classes.bodies;

public class ULBS_BS97_bodies {
    public String getBodyGetNotificationSMS(){
        return  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
                "	<SOAP-ENV:Header/>"+
                "	<SOAP-ENV:Body>"+
                "		<ns2:SendMessageBySMS_Rs xmlns:ns2=\"http://www.vtb24.ru/ApplicationObjectLibrary/BO/schemas/Requesters/NotificationBOReqA/V1\">"+
                "			<ns2:Header CorrelationUID=\"12345678987654321\" ErrorCode=\"\" MessageId=\"18d09c13-31dc-4251-9fd1-56b3c0c76209-resp\" SystemFrom=\"STUB\" SystemTo=\"?\"/>"+
                "		</ns2:SendMessageBySMS_Rs>"+
                "	</SOAP-ENV:Body>"+
                "</SOAP-ENV:Envelope>";
    }

    public String getBodyGetNotificationEMAIL(){
        return  "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
                "	<SOAP-ENV:Header/>"+
                "	<SOAP-ENV:Body>"+
                "		<ns2:SendMessageByEMail_Rs xmlns:ns2=\"http://www.vtb24.ru/ApplicationObjectLibrary/BO/schemas/Requesters/NotificationBOReqA/V1\">"+
                "			<ns2:Header CorrelationUID=\"12345678987654321\" ErrorCode=\"00\" MessageId=\"83bb9088-ba91-4e74-bb3c-2877fe748e69\" SystemFrom=\"STUB\" SystemTo=\"\"/>"+
                "		</ns2:SendMessageByEMail_Rs>"+
                "	</SOAP-ENV:Body>"+
                "</SOAP-ENV:Envelope>";
    }

    public String getBodyGetOrganization(){
        return  "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">"+
                "	<env:Header>"+
                "		<wsa:Action>MatchOrganizationInBlackLists</wsa:Action>"+
                "		<wsa:MessageID>urn:903c3e26-621e-11eb-811d-005056b7a1eb</wsa:MessageID>"+
                "		<wsa:ReplyTo>"+
                "			<wsa:Address>http://www.w3.org/2005/08/addressing/anonymous</wsa:Address>"+
                "			<wsa:ReferenceParameters>"+
                "				<instra:tracking.ecid xmlns:instra=\"http://xmlns.oracle.com/sca/tracking/1.0\">52b71990-179d-4e28-abbd-2ea3bccf8cab-0236dcbe</instra:tracking.ecid>"+
                "				<instra:tracking.FlowEventId xmlns:instra=\"http://xmlns.oracle.com/sca/tracking/1.0\">712376242</instra:tracking.FlowEventId>"+
                "				<instra:tracking.FlowId xmlns:instra=\"http://xmlns.oracle.com/sca/tracking/1.0\">37193649</instra:tracking.FlowId>"+
                "				<instra:tracking.CorrelationFlowId xmlns:instra=\"http://xmlns.oracle.com/sca/tracking/1.0\">0000NTDiy_z9HfaLtMs1yX1W4qTn0003CM</instra:tracking.CorrelationFlowId>"+
                "				<instra:tracking.quiescing.SCAEntityId xmlns:instra=\"http://xmlns.oracle.com/sca/tracking/1.0\">2300571</instra:tracking.quiescing.SCAEntityId>"+
                "			</wsa:ReferenceParameters>"+
                "		</wsa:ReplyTo>"+
                "		<wsa:FaultTo>"+
                "			<wsa:Address>http://www.w3.org/2005/08/addressing/anonymous</wsa:Address>"+
                "		</wsa:FaultTo>"+
                "	</env:Header>"+
                "	<env:Body>"+
                "		<MatchOrganizationInBlackListsResponseEBM xmlns=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Services/Organization/V1\" xmlns:ebm=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Services/Organization/V1\" xmlns:ebmp=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Services/Person/V2\" xmlns:ns10=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/BankCard/V1\" xmlns:ns11=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/PersonCreditRisk/V1\" xmlns:ns6=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/BankAccount/V1\" xmlns:ns7=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/ComplianceControl/V1\" xmlns:ns8=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/InvestmentContractOrder/V1\" xmlns:ns9=\"http://www.vtb24.ru/EnterpriseObjectLibrary/Business/Common/Model/LoanApplication/V1\" xmlns:oracle-xsl-mapper=\"http://www.oracle.com/xsl/mapper/schemas\" xmlns:oraxsl=\"http://www.oracle.com/XSL/Transform/java\">"+
                "			<EBMHeader xmlns=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Common/V2\">"+
                "				<ns2:EBMID xmlns:ns2=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Common/V2\">35313432333636323435373634313836</ns2:EBMID>"+
                "				<ns2:CreationDateTime xmlns:ns2=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Common/V2\">2021-01-29T13:41:36.972+03:00</ns2:CreationDateTime>"+
                "				<ns2:Sender xmlns:ns2=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Common/V2\">"+
                "					<ns2:ID>SBL_FR</ns2:ID>"+
                "					<ns2:SenderMessageID>d06e58ade9a14e4c869e8594ff118bb3</ns2:SenderMessageID>"+
                "				</ns2:Sender>"+
                "				<RequestEBMID>5ecb5eecb32e48efb3694b6471d1b326</RequestEBMID>"+
                "			</EBMHeader>"+
                "			<ebm:DataArea/>"+
                "		</MatchOrganizationInBlackListsResponseEBM>"+
                "	</env:Body>"+
                "</env:Envelope>";
    }
}
