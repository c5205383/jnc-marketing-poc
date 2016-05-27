package com.sap.jnc.marketing.wechat;

public class WeChatAutoResponse {
	
	public String response(String xml, String responseStr) {
		ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);
		String response = "";
		if(responseStr==null || "".equals(responseStr.trim())){
			response = "Thank you for subscribing our account, we will always share with you interesting and latest information. ";
		}else{
			response = responseStr.trim();
		}

		String result = new FormatXmlProcess().formatXmlAnswer(
				xmlEntity.getFromUserName(), xmlEntity.getToUserName(), response);
		return result;
	}
	
	public String response(String xml){
		return this.response(xml, null);
	}
}
