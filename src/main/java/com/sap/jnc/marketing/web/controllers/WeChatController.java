package com.sap.jnc.marketing.web.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.jnc.marketing.persistence.models.Wine;
import com.sap.jnc.marketing.persistence.repositories.interfaces.WineRepository;
import com.sap.jnc.marketing.wechat.ReceiveXmlEntity;
import com.sap.jnc.marketing.wechat.ReceiveXmlProcess;
import com.sap.jnc.marketing.wechat.WeChatAutoResponse;

/**
 * @author Andy He
 */
@RestController
@RequestMapping
public class WeChatController {

	@Autowired
	private WineRepository wineRepository;

	@RequestMapping(value = "/wechat/scan/{id}", method = RequestMethod.GET)
	public Wine AndyTest(@PathVariable("id") String id) {
		Wine wine = wineRepository.findOne(id);
		return wine;
	}

	@RequestMapping(value = "/wechatadaptor", method = { RequestMethod.POST, RequestMethod.GET })
	public void AndyTest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String currentDate = new Date().toString();
			System.out.println(currentDate);
			String result = "";
			String echostr = request.getParameter("echostr");
			if (echostr != null && !"".equals(echostr)) {
				result = echostr;
			} else {
				InputStream is = request.getInputStream();
				StringBuffer sb = new StringBuffer();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String s = "";
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
				String xml = sb.toString();
				System.out.println(xml);
				ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);
				if (xmlEntity != null) {
					String bottelID = "";
					if ("subscribe".equalsIgnoreCase(xmlEntity.getEvent())) {
						bottelID = xmlEntity.getEventKey();
						if (bottelID != null && !"".equals(bottelID.trim())) {
							if (bottelID.startsWith("qrscene_")) {
								bottelID = bottelID.replaceFirst("qrscene_", "");
							} else {
								bottelID = "";
							}
						}
					}
					if ("SCAN".equalsIgnoreCase(xmlEntity.getEvent())) {
						bottelID = xmlEntity.getEventKey();
					}
					if (!"".equals(bottelID.trim())) {
						Wine wine = wineRepository.findOne(bottelID);
						if (wine != null) {
							if (wine.getFlagBonusA() == '0') {
								result = "谢谢关注剑南春，本次红包金额：" + wine.getAmountA().toString() + "。";
								wine.setFlagBonusA('1');
								wineRepository.saveAndFlush(wine);
							} else {
								result = "红包已领取，谢谢关注剑南春。";
							}

						}
					}
					if ("".equals(result.trim())) {
						result = "谢谢关注剑南春。";
					}
					result = new WeChatAutoResponse().response(xml, result);
				}

			}
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
			out = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
