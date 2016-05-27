package com.sap.jnc.marketing.wechat;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ReceiveXmlProcess {
	/**
	 */
	public ReceiveXmlEntity getMsgEntity(String strXml) {
		ReceiveXmlEntity msg = null;
		try {
			if (strXml.length() <= 0 || strXml == null)
				return null;

			Document document = DocumentHelper.parseText(strXml);
			Element root = document.getRootElement();
			Iterator<?> iter = root.elementIterator();

			msg = new ReceiveXmlEntity();
			Class<?> c = Class.forName("com.sap.jnc.marketing.wechat.ReceiveXmlEntity");
			msg = (ReceiveXmlEntity) c.newInstance();

			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				if(ele.getName() != null && "SendLocationInfo".equals((ele.getName()))){
					Iterator<?> subiter = ele.elementIterator();
					while (subiter.hasNext()) {
						Element ele1 = (Element) subiter.next();
						Field field1 = c.getDeclaredField(ele1.getName());
						Method method1 = c.getDeclaredMethod("set" + ele1.getName(),
								field1.getType());
						method1.invoke(msg, ele1.getText());
					}
				}else{
					Field field = c.getDeclaredField(ele.getName());
					Method method = c.getDeclaredMethod("set" + ele.getName(),
							field.getType());
					
					method.invoke(msg, ele.getText());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return msg;
	}
}
